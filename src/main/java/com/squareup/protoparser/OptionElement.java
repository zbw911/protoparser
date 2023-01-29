// Copyright 2013 Square, Inc.
package com.squareup.protoparser;

//import com.google.auto.value.AutoValue;

import java.util.*;

import static com.squareup.protoparser.Utils.appendIndented;
import static com.squareup.protoparser.Utils.checkNotNull;
import static java.util.Collections.unmodifiableMap;

//@AutoValue
public abstract class OptionElement {
    public enum Kind {
        STRING,
        BOOLEAN,
        NUMBER,
        ENUM,
        MAP,
        LIST,
        OPTION
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> optionsAsMap(List<OptionElement> options) {
        Map<String, Object> map = new LinkedHashMap<>();
        for (OptionElement option : options) {
            String name = option.name();
            Object value = option.value();

            if (value instanceof String || value instanceof List) {
                map.put(name, value);
            } else if (value instanceof OptionElement) {
                Map<String, Object> newMap = optionsAsMap(Collections.singletonList((OptionElement) value));

                Object oldValue = map.get(name);
                if (oldValue instanceof Map) {
                    Map<String, Object> oldMap = (Map<String, Object>) oldValue;
                    // Existing nested maps are immutable. Make a mutable copy, update, and replace.
                    oldMap = new LinkedHashMap<>(oldMap);
                    oldMap.putAll(newMap);
                    map.put(name, oldMap);
                } else {
                    map.put(name, newMap);
                }
            } else if (value instanceof Map) {
                Object oldValue = map.get(name);
                if (oldValue instanceof Map) {
                    ((Map<String, Object>) oldValue).putAll((Map<String, Object>) value);
                } else {
                    map.put(name, value);
                }
            } else {
                throw new AssertionError("Option value must be String, Option, List, or Map<String, ?>");
            }
        }
        return unmodifiableMap(map);
    }

    /**
     * Return the option with the specified name from the supplied list or null.
     */
    public static OptionElement findByName(List<OptionElement> options, String name) {
        checkNotNull(options, "options");
        checkNotNull(name, "name");

        OptionElement found = null;
        for (OptionElement option : options) {
            if (option.name().equals(name)) {
                if (found != null) {
                    throw new IllegalStateException("Multiple options match name: " + name);
                }
                found = option;
            }
        }
        return found;
    }

    public static OptionElement create(String name, Kind kind, Object value) {
        return create(name, kind, value, false);
    }

    public static OptionElement create(String name, Kind kind, Object value,
                                       boolean isParenthesized) {
        checkNotNull(name, "name");
        checkNotNull(value, "value");

        return new AutoValue_OptionElement(name, kind, value, isParenthesized);
    }

    OptionElement() {
    }

    public abstract String name();

    public abstract Kind kind();

    public abstract Object value();

    public abstract boolean isParenthesized();

    public final String toSchema() {
        Object value = value();
        switch (kind()) {
            case STRING:
                return formatName() + " = \"" + value + '"';
            case BOOLEAN:
            case NUMBER:
            case ENUM:
                return formatName() + " = " + value;
            case OPTION: {
                StringBuilder builder = new StringBuilder();
                OptionElement optionValue = (OptionElement) value;
                // Treat nested options as non-parenthesized always, prevents double parentheses.
                optionValue =
                        OptionElement.create(optionValue.name(), optionValue.kind(), optionValue.value());
                builder.append(formatName()).append('.').append(optionValue.toSchema());
                return builder.toString();
            }
            case MAP: {
                StringBuilder builder = new StringBuilder();
                builder.append(formatName()).append(" = {\n");
                //noinspection unchecked
                Map<String, ?> valueMap = (Map<String, ?>) value;
                formatOptionMap(builder, valueMap);
                builder.append('}');
                return builder.toString();
            }
            case LIST: {
                StringBuilder builder = new StringBuilder();
                builder.append(formatName()).append(" = [\n");
                //noinspection unchecked
                List<OptionElement> optionList = (List<OptionElement>) value;
                formatOptionList(builder, optionList);
                builder.append(']');
                return builder.toString();
            }
            default:
                throw new AssertionError();
        }
    }

    public final String toSchemaDeclaration() {
        return "option " + toSchema() + ";\n";
    }

    static void formatOptionList(StringBuilder builder, List<OptionElement> optionList) {
        for (int i = 0, count = optionList.size(); i < count; i++) {
            String endl = (i < count - 1) ? "," : "";
            appendIndented(builder, optionList.get(i).toSchema() + endl);
        }
    }

    static void formatOptionMap(StringBuilder builder, Map<String, ?> valueMap) {
        List<? extends Map.Entry<String, ?>> entries = new ArrayList<>(valueMap.entrySet());
        for (int i = 0, count = entries.size(); i < count; i++) {
            Map.Entry<String, ?> entry = entries.get(i);
            String endl = (i < count - 1) ? "," : "";
            appendIndented(builder,
                    entry.getKey() + ": " + formatOptionMapValue(entry.getValue()) + endl);
        }
    }

    static String formatOptionMapValue(Object value) {
        checkNotNull(value, "value == null");
        if (value instanceof String) {
            return "\"" + value + '"';
        }
        if (value instanceof Map) {
            StringBuilder builder = new StringBuilder().append("{\n");
            //noinspection unchecked
            Map<String, ?> map = (Map<String, ?>) value;
            formatOptionMap(builder, map);
            return builder.append('}').toString();
        }
        if (value instanceof List) {
            StringBuilder builder = new StringBuilder().append("[\n");
            List<?> list = (List<?>) value;
            for (int i = 0, count = list.size(); i < count; i++) {
                String endl = (i < count - 1) ? "," : "";
                appendIndented(builder, formatOptionMapValue(list.get(i)) + endl);
            }
            return builder.append("]").toString();
        }
        return value.toString();
    }

    private String formatName() {
        if (isParenthesized()) {
            return '(' + name() + ')';
        } else {
            return name();
        }
    }
}
