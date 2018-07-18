package com.olshevskyi.domain

class Letter {

    long id
    char value
    def incompatibleLetters = []

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Letter letter = (Letter) o

        if (value != letter.value) return false
        if (incompatibleLetters != letter.incompatibleLetters) return false

        return true
    }

    int hashCode() {
        int result
        result = (int) value
        result = 31 * result + (incompatibleLetters != null ? incompatibleLetters.hashCode() : 0)
        return result
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
