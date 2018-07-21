package com.olshevskyi.builder.impl

import com.olshevskyi.domain.DefaultLetterCollection
import com.olshevskyi.domain.Letter
import com.olshevskyi.domain.TShirt
import org.junit.Ignore
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

    @Test
    void testGetAllLettersSingle() {
        def a = new Letter(value: 'a')
        def b = new Letter(value: 'b')
        def c = new Letter(value: 'c')
        def d = new Letter(value: 'd')
        def e = new Letter(value: 'e')

        a.incompatibleLetters = ['b', 'c']
        b.incompatibleLetters = ['a', 'c']
        c.incompatibleLetters = ['a', 'b', 'd', 'e']
        d.incompatibleLetters = ['c', 'e']
        e.incompatibleLetters = ['c', 'd']

        def expected = new DefaultLetterCollection()
        expected.putAll([a, b, c, d, e])
        def actual = builder.getLetters(["abc", "cde"])

        assert expected == actual
    }

    @Test
    void testGetAllLettersMultiple() {
        def a = new Letter(value: 'a')
        def b = new Letter(value: 'b')
        def c = new Letter(value: 'c')
        def c2 = new Letter(value: 'c')
        def d = new Letter(value: 'd')
        def e = new Letter(value: 'e')

        a.incompatibleLetters = ['b', 'c']
        b.incompatibleLetters = ['a', 'c']
        c.incompatibleLetters = ['a', 'b', 'd', 'e']
        c2.incompatibleLetters = ['d', 'e']
        d.incompatibleLetters = ['c', 'e', 'c']
        e.incompatibleLetters = ['c', 'd', 'c']

        def expected = new DefaultLetterCollection()
        expected.putAll([a, b, c, d, e, c2])
        def actual = builder.getLetters(["abc", "cdec"])

        assert expected == actual
    }

    @Test
    void testBuild() {
        def t1 = new TShirt(front: 'f', back: '')
        def t2 = new TShirt(front: 'u', back: 'n')
        def t3 = new TShirt(front: 'e', back: 'l')
        def t4 = new TShirt(front: 's', back: 'k')
        def t5 = new TShirt(front: 'f', back: 't')
        def t6 = new TShirt(front: 'r', back: '')
        def expected = null//[t1, t2, t3, t4, t5, t6]

        def result = builder.buildTShirts(["suffer", "fulk", "fent"])
        assert expected == result
    }

    @Test
    @Ignore
    void testBuild2() {
        def t1 = new TShirt(front: 'u', back: '')
        def t2 = new TShirt(front: 't', back: 'f')
        def t3 = new TShirt(front: 't', back: 'f')
        def expected = [t1, t2, t3]

        def result = builder.buildTShirts(["fut", "tut", "fuf"])
        assert expected == result
    }

}