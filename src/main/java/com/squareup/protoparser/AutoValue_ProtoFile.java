//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.squareup.protoparser;

import java.util.List;

final class AutoValue_ProtoFile extends ProtoFile {
    private final String filePath;
    private final String packageName;
    private final Syntax syntax;
    private final List<String> dependencies;
    private final List<String> publicDependencies;
    private final List<TypeElement> typeElements;
    private final List<ServiceElement> services;
    private final List<ExtendElement> extendDeclarations;
    private final List<OptionElement> options;

    AutoValue_ProtoFile(String filePath, String packageName, Syntax syntax, List<String> dependencies, List<String> publicDependencies, List<TypeElement> typeElements, List<ServiceElement> services, List<ExtendElement> extendDeclarations, List<OptionElement> options) {
        if (filePath == null) {
            throw new NullPointerException("Null filePath");
        } else {
            this.filePath = filePath;
            this.packageName = packageName;
            this.syntax = syntax;
            if (dependencies == null) {
                throw new NullPointerException("Null dependencies");
            } else {
                this.dependencies = dependencies;
                if (publicDependencies == null) {
                    throw new NullPointerException("Null publicDependencies");
                } else {
                    this.publicDependencies = publicDependencies;
                    if (typeElements == null) {
                        throw new NullPointerException("Null typeElements");
                    } else {
                        this.typeElements = typeElements;
                        if (services == null) {
                            throw new NullPointerException("Null services");
                        } else {
                            this.services = services;
                            if (extendDeclarations == null) {
                                throw new NullPointerException("Null extendDeclarations");
                            } else {
                                this.extendDeclarations = extendDeclarations;
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

    public String filePath() {
        return this.filePath;
    }

    public String packageName() {
        return this.packageName;
    }

    public Syntax syntax() {
        return this.syntax;
    }

    public List<String> dependencies() {
        return this.dependencies;
    }

    public List<String> publicDependencies() {
        return this.publicDependencies;
    }

    public List<TypeElement> typeElements() {
        return this.typeElements;
    }

    public List<ServiceElement> services() {
        return this.services;
    }

    public List<ExtendElement> extendDeclarations() {
        return this.extendDeclarations;
    }

    public List<OptionElement> options() {
        return this.options;
    }

    public String toString() {
        return "ProtoFile{filePath=" + this.filePath + ", packageName=" + this.packageName + ", syntax=" + this.syntax + ", dependencies=" + this.dependencies + ", publicDependencies=" + this.publicDependencies + ", typeElements=" + this.typeElements + ", services=" + this.services + ", extendDeclarations=" + this.extendDeclarations + ", options=" + this.options + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ProtoFile)) {
            return false;
        } else {
            ProtoFile that = (ProtoFile) o;
            boolean var10000;
            if (this.filePath.equals(that.filePath())) {
                label51:
                {
                    if (this.packageName == null) {
                        if (that.packageName() != null) {
                            break label51;
                        }
                    } else if (!this.packageName.equals(that.packageName())) {
                        break label51;
                    }

                    if (this.syntax == null) {
                        if (that.syntax() != null) {
                            break label51;
                        }
                    } else if (!this.syntax.equals(that.syntax())) {
                        break label51;
                    }

                    if (this.dependencies.equals(that.dependencies()) && this.publicDependencies.equals(that.publicDependencies()) && this.typeElements.equals(that.typeElements()) && this.services.equals(that.services()) && this.extendDeclarations.equals(that.extendDeclarations()) && this.options.equals(that.options())) {
                        var10000 = true;
                        return var10000;
                    }
                }
            }

            var10000 = false;
            return var10000;
        }
    }

    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.filePath.hashCode();
        h *= 1000003;
        h ^= this.packageName == null ? 0 : this.packageName.hashCode();
        h *= 1000003;
        h ^= this.syntax == null ? 0 : this.syntax.hashCode();
        h *= 1000003;
        h ^= this.dependencies.hashCode();
        h *= 1000003;
        h ^= this.publicDependencies.hashCode();
        h *= 1000003;
        h ^= this.typeElements.hashCode();
        h *= 1000003;
        h ^= this.services.hashCode();
        h *= 1000003;
        h ^= this.extendDeclarations.hashCode();
        h *= 1000003;
        h ^= this.options.hashCode();
        return h;
    }
}
