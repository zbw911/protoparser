//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.squareup.protoparser;

import java.util.List;

final class AutoValue_ServiceElement extends ServiceElement {
    private final String name;
    private final String qualifiedName;
    private final String documentation;
    private final List<RpcElement> rpcs;
    private final List<OptionElement> options;

    AutoValue_ServiceElement(String name, String qualifiedName, String documentation, List<RpcElement> rpcs, List<OptionElement> options) {
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
                    if (rpcs == null) {
                        throw new NullPointerException("Null rpcs");
                    } else {
                        this.rpcs = rpcs;
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

    public List<RpcElement> rpcs() {
        return this.rpcs;
    }

    public List<OptionElement> options() {
        return this.options;
    }

    public String toString() {
        return "ServiceElement{name=" + this.name + ", qualifiedName=" + this.qualifiedName + ", documentation=" + this.documentation + ", rpcs=" + this.rpcs + ", options=" + this.options + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ServiceElement)) {
            return false;
        } else {
            ServiceElement that = (ServiceElement) o;
            return this.name.equals(that.name()) && this.qualifiedName.equals(that.qualifiedName()) && this.documentation.equals(that.documentation()) && this.rpcs.equals(that.rpcs()) && this.options.equals(that.options());
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
        h ^= this.rpcs.hashCode();
        h *= 1000003;
        h ^= this.options.hashCode();
        return h;
    }
}
