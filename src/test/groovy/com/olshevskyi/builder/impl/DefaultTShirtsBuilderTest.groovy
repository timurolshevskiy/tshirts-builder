package com.olshevskyi.builder.impl

import com.olshevskyi.domain.Letter
import org.junit.Test

class DefaultTShirtsBuilderTest {

    def builder = new DefaultTShirtsBuilder()

    @Test
    void testGetWordLettersSingleLetters() {
        def a = new Letter(value: 'a')
        def b = new Letter(value: 'b')
        def c = new Letter(value: 'c')

        a.incompatibleLetters = ['b', 'c']
        b.incompatibleLetters = ['a', 'c']
        c.incompatibleLetters = ['a', 'b']

        def expected = [a, b, c]
        def actual = builder.getWordLetters("abc")

        assert expected == actual
    }

}