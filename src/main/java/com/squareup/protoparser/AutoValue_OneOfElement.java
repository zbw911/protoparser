//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.squareup.protoparser;

import java.util.List;

final class AutoValue_OneOfElement extends OneOfElement {
    private final String name;
    private final String documentation;
    private final List<FieldElement> fields;

    AutoValue_OneOfElement(String name, String documentation, List<FieldElement> fields) {
        if (name == null) {
            throw new NullPointerException("Null name");
        } else {
            this.name = name;
            if (documentation == null) {
                throw new NullPointerException("Null documentation");
            } else {
                this.documentation = documentation;
                if (fields == null) {
                    throw new NullPointerException("Null fields");
                } else {
                    this.fields = fields;
                }
            }
        }
    }

    public String name() {
        return this.name;
    }

    public String documentation() {
        return this.documentation;
    }

    public List<FieldElement> fields() {
        return this.fields;
    }

    public String toString() {
        return "OneOfElement{name=" + this.name + ", documentation=" + this.documentation + ", fields=" + this.fields + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OneOfElement)) {
            return false;
        } else {
            OneOfElement that = (OneOfElement) o;
            return this.name.equals(that.name()) && this.documentation.equals(that.documentation()) && this.fields.equals(that.fields());
        }
    }

    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.name.hashCode();
        h *= 1000003;
        h ^= this.documentation.hashCode();
        h *= 1000003;
        h ^= this.fields.hashCode();
        return h;
    }
}
