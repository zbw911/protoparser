//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.squareup.protoparser;

import java.util.List;

final class AutoValue_MessageElement extends MessageElement {
    private final String name;
    private final String qualifiedName;
    private final String documentation;
    private final List<FieldElement> fields;
    private final List<OneOfElement> oneOfs;
    private final List<TypeElement> nestedElements;
    private final List<ExtensionsElement> extensions;
    private final List<OptionElement> options;

    AutoValue_MessageElement(String name, String qualifiedName, String documentation, List<FieldElement> fields, List<OneOfElement> oneOfs, List<TypeElement> nestedElements, List<ExtensionsElement> extensions, List<OptionElement> options) {
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
                    if (fields == null) {
                        throw new NullPointerException("Null fields");
                    } else {
                        this.fields = fields;
                        if (oneOfs == null) {
                            throw new NullPointerException("Null oneOfs");
                        } else {
                            this.oneOfs = oneOfs;
                            if (nestedElements == null) {
                                throw new NullPointerException("Null nestedElements");
                            } else {
                                this.nestedElements = nestedElements;
                                if (extensions == null) {
                                    throw new NullPointerException("Null extensions");
                                } else {
                                    this.extensions = extensions;
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

    public List<FieldElement> fields() {
        return this.fields;
    }

    public List<OneOfElement> oneOfs() {
        return this.oneOfs;
    }

    public List<TypeElement> nestedElements() {
        return this.nestedElements;
    }

    public List<ExtensionsElement> extensions() {
        return this.extensions;
    }

    public List<OptionElement> options() {
        return this.options;
    }

    public String toString() {
        return "MessageElement{name=" + this.name + ", qualifiedName=" + this.qualifiedName + ", documentation=" + this.documentation + ", fields=" + this.fields + ", oneOfs=" + this.oneOfs + ", nestedElements=" + this.nestedElements + ", extensions=" + this.extensions + ", options=" + this.options + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MessageElement)) {
            return false;
        } else {
            MessageElement that = (MessageElement) o;
            return this.name.equals(that.name()) && this.qualifiedName.equals(that.qualifiedName()) && this.documentation.equals(that.documentation()) && this.fields.equals(that.fields()) && this.oneOfs.equals(that.oneOfs()) && this.nestedElements.equals(that.nestedElements()) && this.extensions.equals(that.extensions()) && this.options.equals(that.options());
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
        h ^= this.fields.hashCode();
        h *= 1000003;
        h ^= this.oneOfs.hashCode();
        h *= 1000003;
        h ^= this.nestedElements.hashCode();
        h *= 1000003;
        h ^= this.extensions.hashCode();
        h *= 1000003;
        h ^= this.options.hashCode();
        return h;
    }
}
