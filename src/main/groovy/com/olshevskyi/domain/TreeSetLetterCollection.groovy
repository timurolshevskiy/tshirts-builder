package com.olshevskyi.domain

class TreeSetLetterCollection implements LettersCollection {

    def letters = []

    @Override
    void putLetter(Letter letter) {
        if (!containsLetter(letter)) {
            def listLetter = letters.find {
                it.value == letter.value
            }
            if (listLetter) {
                // todo
            }
        }
    }

    def containsLetter(Letter letter) {
        letters.any {
            it.incompatibleLetters.containsAll(letter.incompatibleLetters)
        }
    }
}
