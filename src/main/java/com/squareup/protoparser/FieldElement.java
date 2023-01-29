// Copyright 2014 Square, Inc.
package com.squareup.protoparser;

//import com.google.auto.value.AutoValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import static com.squareup.protoparser.ProtoFile.isValidTag;
import static com.squareup.protoparser.Utils.*;

//@AutoValue
public abstract class FieldElement {
    FieldElement() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public abstract Label label();

    /**
     * Returns the type of this field. May be a message type name, an enum type
     * name, or a <a href="https://developers.google.com/protocol-buffers/docs/proto#scalar">
     * scalar value type</a> like {@code int64} or {@code bytes}.
     */
    public abstract DataType type();

    public abstract String name();

    public abstract int tag();

    public abstract String documentation();

    public abstract List<OptionElement> options();

    /**
     * Returns true when the {@code deprecated} option is present and set to true.
     */
    public final boolean isDeprecated() {
        OptionElement deprecatedOption = OptionElement.findByName(options(), "deprecated");
        return deprecatedOption != null && "true".equals(deprecatedOption.value());
    }

    /**
     * Returns true when the {@code packed} option is present and set to true.
     */
    public final boolean isPacked() {
        OptionElement packedOption = OptionElement.findByName(options(), "packed");
        return packedOption != null && "true".equals(packedOption.value());
    }

    /**
     * Returns the {@code default} option value or {@code null}.
     */
    public final OptionElement getDefault() {
        OptionElement defaultOption = OptionElement.findByName(options(), "default");
        return defaultOption != null ? defaultOption : null;
    }

    public final String toSchema() {
        StringBuilder builder = new StringBuilder();
        appendDocumentation(builder, documentation());
        if (label() != Label.ONE_OF && label() != Label.NONE) {
            builder.append(label().name().toLowerCase(Locale.US)).append(' ');
        }
        builder.append(type())
                .append(' ')
                .append(name())
                .append(" = ")
                .append(tag());
        if (!options().isEmpty()) {
            builder.append(" [\n");
            for (OptionElement option : options()) {
                appendIndented(builder, option.toSchema());
            }
            builder.append(']');
        }
        return builder.append(";\n").toString();
    }

    public enum Label {
        /**
         * NONE 用于兼容 proto3
         */
        NONE,
        OPTIONAL, REQUIRED,
        REPEATED,
        /**
         * Indicates the field is a member of a {@code oneof} block.
         */
        ONE_OF
    }

    public static final class Builder {
        private final List<OptionElement> options = new ArrayList<>();
        private Label label;
        private DataType type;
        private String name;
        private Integer tag;
        private String documentation = "";

        private Builder() {
        }

        public Builder label(Label label) {
            this.label = checkNotNull(label, "label");
            return this;
        }

        public Builder type(DataType type) {
            this.type = checkNotNull(type, "type");
            return this;
        }

        public Builder name(String name) {
            this.name = checkNotNull(name, "name");
            return this;
        }

        public Builder tag(int tag) {
            this.tag = tag;
            return this;
        }

        public Builder documentation(String documentation) {
            this.documentation = checkNotNull(documentation, "documentation");
            return this;
        }

        public Builder addOption(OptionElement option) {
            options.add(checkNotNull(option, "option"));
            return this;
        }

        public Builder addOptions(Collection<OptionElement> options) {
            for (OptionElement option : checkNotNull(options, "options")) {
                addOption(option);
            }
            return this;
        }

        public FieldElement build() {

            if (label == null) {

                label = Label.NONE;
            }

            checkNotNull(label, "label");
            checkNotNull(type, "type");
            checkNotNull(name, "name");
            checkNotNull(tag, "tag");

            checkArgument(isValidTag(tag), "Illegal tag value: %s", tag);

            return new AutoValue_FieldElement(label, type, name, tag, documentation,
                    immutableCopyOf(options));
        }
    }
}
