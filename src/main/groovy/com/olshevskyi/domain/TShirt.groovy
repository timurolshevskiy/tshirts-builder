package com.olshevskyi.domain

class TShirt {

    String front
    String back

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        TShirt tShirt = (TShirt) o

        if (back != tShirt.back) return false
        if (front != tShirt.front) return false

        return true
    }

    int hashCode() {
        int result
        result = (front != null ? front.hashCode() : 0)
        result = 31 * result + (back != null ? back.hashCode() : 0)
        return result
    }

    String toString() {
        "[$front, $back]"
    }
}
