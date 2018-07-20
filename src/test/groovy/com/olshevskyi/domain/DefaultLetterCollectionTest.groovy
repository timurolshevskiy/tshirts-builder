package com.olshevskyi.domain

import org.junit.Test

class DefaultLetterCollectionTest {

    @Test
    void testSort() {
        def a = new Letter(value: 'a', incompatibleLetters: ['b', 'c'])
        def b = new Letter(value: 'b', incompatibleLetters: ['d', 'e', 'f', 'g'])
        def c = new Letter(value: 'c', incompatibleLetters: ['h', 'i', 'j'])

        def given = new DefaultLetterCollection()
        given.putAll([a, b, c])

        def expected = new DefaultLetterCollection()
        expected.putAll([b, c, a])
        given.sort()

        assert expected == given
    }

}