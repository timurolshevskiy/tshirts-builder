package com.olshevskyi.domain

class Letter {

    boolean used
    String value
    def incompatibleLetters = []

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Letter letter = (Letter) o

        if (incompatibleLetters != letter.incompatibleLetters) return false
        if (value != letter.value) return false

        return true
    }

    int hashCode() {
        int result
        result = (value != null ? value.hashCode() : 0)
        result = 31 * result + (incompatibleLetters != null ? incompatibleLetters.hashCode() : 0)
        return result
    }

    @Override
    String toString() {
        "${value.toUpperCase()}: ${incompatibleLetters.toString()}"
    }
//    boolean equals(o) {
//        if (this.is(o)) return true
//        if (getClass() != o.class) return false
//
//        Letter letter = (Letter) o
//
//        if (value != letter.value) return false
//
//        return true
//    }
//
//    int hashCode() {
//        return (int) (value ^ (value >>> 32))
//    }
}
