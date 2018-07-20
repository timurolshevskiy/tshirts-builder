package com.olshevskyi.domain

interface LettersCollection extends Iterable<Letter> {

    void putLetter(Letter letter, int positionNumber)

    void putAll(List<Letter> letters)

    void sort()

}
