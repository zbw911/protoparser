//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.squareup.protoparser;

import java.util.List;

final class AutoValue_EnumElement extends EnumElement {
    private final String name;
    private final String qualifiedName;
    private final String documentation;
    private final List<EnumConstantElement> constants;
    private final List<OptionElement> options;

    AutoValue_EnumElement(String name, String qualifiedName, String documentation, List<EnumConstantElement> constants, List<OptionElement> options) {
        if (name == null) {
            throw new NullPointerException("Null name");
        } else {
            this.name = name;
            if (qualifiedName == null) {
                throw new NullPointerException("Null qualifiedName");
            } else {
                this.qualifiedName = qualifiedName;
                if (documentation == null) {
                    throw new NullPointerException("Null documentation");
                } else {
                    this.documentation = documentation;
                    if (constants == null) {
                        throw new NullPointerException("Null constants");
                    } else {
                        this.constants = constants;
                        if (options == null) {
                            throw new NullPointerException("Null options");
                        } else {
                            this.options = options;
                        }
                    }
                }
            }
        }
    }

    public String name() {
        return this.name;
    }

    public String qualifiedName() {
        return this.qualifiedName;
    }

    public String documentation() {
        return this.documentation;
    }

    public List<EnumConstantElement> constants() {
        return this.constants;
    }

    public List<OptionElement> options() {
        return this.options;
    }

    public String toString() {
        return "EnumElement{name=" + this.name + ", qualifiedName=" + this.qualifiedName + ", documentation=" + this.documentation + ", constants=" + this.constants + ", options=" + this.options + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof EnumElement)) {
            return false;
        } else {
            EnumElement that = (EnumElement) o;
            return this.name.equals(that.name()) && this.qualifiedName.equals(that.qualifiedName()) && this.documentation.equals(that.documentation()) && this.constants.equals(that.constants()) && this.options.equals(that.options());
        }
    }

    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.name.hashCode();
        h *= 1000003;
        h ^= this.qualifiedName.hashCode();
        h *= 1000003;
        h ^= this.documentation.hashCode();
        h *= 1000003;
        h ^= this.constants.hashCode();
        h *= 1000003;
        h ^= this.options.hashCode();
        return h;
    }
}
