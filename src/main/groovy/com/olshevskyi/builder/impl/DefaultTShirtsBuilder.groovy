package com.olshevskyi.builder.impl

import com.olshevskyi.builder.TShirtsBuilder
import com.olshevskyi.domain.Letter
import com.olshevskyi.domain.TShirt

class DefaultTShirtsBuilder implements TShirtsBuilder {

    @Override
    List<TShirt> buildTShirts(List<String> words) {

    }

    List<Letter> getLetters(List<String> words) {
        def letters = new TreeSet<Letter>()
        words.each {
            letters.addAll(getWordLetters(it))
        }
        return letters
    }

    List<Letter> getWordLetters(String word) {
        def letters = []
        def charArray = word.toCharArray()
        charArray.each {
            def letter = new Letter(value: it)
            letters << letter
        }

        letters.each {
            it.incompatibleLetters = letters.collect {it.value} - it.value
        }
        letters
    }
}
