//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.squareup.protoparser;

import java.util.List;

final class AutoValue_RpcElement extends RpcElement {
    private final String name;
    private final String documentation;
    private final DataType.NamedType requestType;
    private final DataType.NamedType responseType;
    private final List<OptionElement> options;

    AutoValue_RpcElement(String name, String documentation, DataType.NamedType requestType, DataType.NamedType responseType, List<OptionElement> options) {
        if (name == null) {
            throw new NullPointerException("Null name");
        } else {
            this.name = name;
            if (documentation == null) {
                throw new NullPointerException("Null documentation");
            } else {
                this.documentation = documentation;
                if (requestType == null) {
                    throw new NullPointerException("Null requestType");
                } else {
                    this.requestType = requestType;
                    if (responseType == null) {
                        throw new NullPointerException("Null responseType");
                    } else {
                        this.responseType = responseType;
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

    public String documentation() {
        return this.documentation;
    }

    public DataType.NamedType requestType() {
        return this.requestType;
    }

    public DataType.NamedType responseType() {
        return this.responseType;
    }

    public List<OptionElement> options() {
        return this.options;
    }

    public String toString() {
        return "RpcElement{name=" + this.name + ", documentation=" + this.documentation + ", requestType=" + this.requestType + ", responseType=" + this.responseType + ", options=" + this.options + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RpcElement)) {
            return false;
        } else {
            RpcElement that = (RpcElement) o;
            return this.name.equals(that.name()) && this.documentation.equals(that.documentation()) && this.requestType.equals(that.requestType()) && this.responseType.equals(that.responseType()) && this.options.equals(that.options());
        }
    }

    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.name.hashCode();
        h *= 1000003;
        h ^= this.documentation.hashCode();
        h *= 1000003;
        h ^= this.requestType.hashCode();
        h *= 1000003;
        h ^= this.responseType.hashCode();
        h *= 1000003;
        h ^= this.options.hashCode();
        return h;
    }
}
