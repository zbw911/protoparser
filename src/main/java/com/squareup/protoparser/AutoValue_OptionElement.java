//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.squareup.protoparser;

final class AutoValue_OptionElement extends OptionElement {
    private final String name;
    private final Kind kind;
    private final Object value;
    private final boolean isParenthesized;

    AutoValue_OptionElement(String name, Kind kind, Object value, boolean isParenthesized) {
        if (name == null) {
            throw new NullPointerException("Null name");
        } else {
            this.name = name;
            if (kind == null) {
                throw new NullPointerException("Null kind");
            } else {
                this.kind = kind;
                if (value == null) {
                    throw new NullPointerException("Null value");
                } else {
                    this.value = value;
                    this.isParenthesized = isParenthesized;
                }
            }
        }
    }

    public String name() {
        return this.name;
    }

    public Kind kind() {
        return this.kind;
    }

    public Object value() {
        return this.value;
    }

    public boolean isParenthesized() {
        return this.isParenthesized;
    }

    public String toString() {
        return "OptionElement{name=" + this.name + ", kind=" + this.kind + ", value=" + this.value + ", isParenthesized=" + this.isParenthesized + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OptionElement)) {
            return false;
        } else {
            OptionElement that = (OptionElement) o;
            return this.name.equals(that.name()) && this.kind.equals(that.kind()) && this.value.equals(that.value()) && this.isParenthesized == that.isParenthesized();
        }
    }

    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.name.hashCode();
        h *= 1000003;
        h ^= this.kind.hashCode();
        h *= 1000003;
        h ^= this.value.hashCode();
        h *= 1000003;
        h ^= this.isParenthesized ? 1231 : 1237;
        return h;
    }
}
