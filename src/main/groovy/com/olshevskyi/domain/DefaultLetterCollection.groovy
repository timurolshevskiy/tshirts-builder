package com.olshevskyi.domain

class DefaultLetterCollection implements LettersCollection {

    def letters = []

    @Override
    void putLetter(Letter letter, int positionNumber) {
        def listLetter = letters.find {
            it.value == letter.value && positionNumber-- == 0
        }
        if (listLetter) {
            listLetter.incompatibleLetters = completeList(listLetter.incompatibleLetters, letter.incompatibleLetters)
            // todo
        } else {
            letters.add(letter)
        }
    }

    private List<Letter> completeList(List<String> first, List<String> second) {
        def result = []
        first.each {
            if (!result.contains(it)) {
                def letterCount = Math.max(countLetters(first, it), countLetters(second, it))
                letterCount.times { counter ->
                    result.add(it)
                }
            }
        }
        (second - first).each {
            if (!result.contains(it)) {
                result.add(it)
            }
        }
        result
    }

    private int countLetters(List<String> list, String letter) {
        list.count {
            it == letter
        }
    }

    void putAll(List<Letter> letters) {
        letters.eachWithIndex { Letter letter, int i ->
            int counter = 0
            letters.eachWithIndex { Letter entry, int j ->
                if (j < i && entry.value == letter.value) {
                    counter++
                }
            }
            putLetter(letter, counter)
        }
    }

    void sort() {
        letters.sort(new OrderBy<Letter>([{ it.incompatibleLetters.size() }]).reversed())
    }

    void each(Closure closure) {
        letters.each(closure)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        DefaultLetterCollection that = (DefaultLetterCollection) o

        if (letters != that.letters) return false

        return true
    }

    int hashCode() {
        return (letters != null ? letters.hashCode() : 0)
    }

    @Override
    Iterator<Letter> iterator() {
        return letters.iterator()
    }

    @Override
    String toString() {
        letters.toString()
    }
}
