//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.squareup.protoparser;

final class AutoValue_ExtensionsElement extends ExtensionsElement {
    private final String documentation;
    private final int start;
    private final int end;

    AutoValue_ExtensionsElement(String documentation, int start, int end) {
        if (documentation == null) {
            throw new NullPointerException("Null documentation");
        } else {
            this.documentation = documentation;
            this.start = start;
            this.end = end;
        }
    }

    public String documentation() {
        return this.documentation;
    }

    public int start() {
        return this.start;
    }

    public int end() {
        return this.end;
    }

    public String toString() {
        return "ExtensionsElement{documentation=" + this.documentation + ", start=" + this.start + ", end=" + this.end + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ExtensionsElement)) {
            return false;
        } else {
            ExtensionsElement that = (ExtensionsElement) o;
            return this.documentation.equals(that.documentation()) && this.start == that.start() && this.end == that.end();
        }
    }

    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.documentation.hashCode();
        h *= 1000003;
        h ^= this.start;
        h *= 1000003;
        h ^= this.end;
        return h;
    }
}
