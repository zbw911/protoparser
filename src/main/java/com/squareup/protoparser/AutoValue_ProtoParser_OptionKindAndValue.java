//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.squareup.protoparser;

final class AutoValue_ProtoParser_OptionKindAndValue extends ProtoParser.OptionKindAndValue {
    private final OptionElement.Kind kind;
    private final Object value;

    AutoValue_ProtoParser_OptionKindAndValue(OptionElement.Kind kind, Object value) {
        if (kind == null) {
            throw new NullPointerException("Null kind");
        } else {
            this.kind = kind;
            if (value == null) {
                throw new NullPointerException("Null value");
            } else {
                this.value = value;
            }
        }
    }

    OptionElement.Kind kind() {
        return this.kind;
    }

    Object value() {
        return this.value;
    }

    public String toString() {
        return "OptionKindAndValue{kind=" + this.kind + ", value=" + this.value + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ProtoParser.OptionKindAndValue)) {
            return false;
        } else {
            ProtoParser.OptionKindAndValue that = (ProtoParser.OptionKindAndValue) o;
            return this.kind.equals(that.kind()) && this.value.equals(that.value());
        }
    }

    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.kind.hashCode();
        h *= 1000003;
        h ^= this.value.hashCode();
        return h;
    }
}
