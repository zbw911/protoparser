//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.squareup.protoparser;

import java.util.List;

final class AutoValue_EnumConstantElement extends EnumConstantElement {
    private final String name;
    private final int tag;
    private final String documentation;
    private final List<OptionElement> options;

    AutoValue_EnumConstantElement(String name, int tag, String documentation, List<OptionElement> options) {
        if (name == null) {
            throw new NullPointerException("Null name");
        } else {
            this.name = name;
            this.tag = tag;
            if (documentation == null) {
                throw new NullPointerException("Null documentation");
            } else {
                this.documentation = documentation;
                if (options == null) {
                    throw new NullPointerException("Null options");
                } else {
                    this.options = options;
                }
            }
        }
    }

    public String name() {
        return this.name;
    }

    public int tag() {
        return this.tag;
    }

    public String documentation() {
        return this.documentation;
    }

    public List<OptionElement> options() {
        return this.options;
    }

    public String toString() {
        return "EnumConstantElement{name=" + this.name + ", tag=" + this.tag + ", documentation=" + this.documentation + ", options=" + this.options + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof EnumConstantElement)) {
            return false;
        } else {
            EnumConstantElement that = (EnumConstantElement) o;
            return this.name.equals(that.name()) && this.tag == that.tag() && this.documentation.equals(that.documentation()) && this.options.equals(that.options());
        }
    }

    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.name.hashCode();
        h *= 1000003;
        h ^= this.tag;
        h *= 1000003;
        h ^= this.documentation.hashCode();
        h *= 1000003;
        h ^= this.options.hashCode();
        return h;
    }
}
