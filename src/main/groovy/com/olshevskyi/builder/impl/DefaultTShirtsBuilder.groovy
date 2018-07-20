package com.olshevskyi.builder.impl

import com.olshevskyi.builder.TShirtsBuilder
import com.olshevskyi.domain.DefaultLetterCollection
import com.olshevskyi.domain.Letter
import com.olshevskyi.domain.LettersCollection
import com.olshevskyi.domain.TShirt

class DefaultTShirtsBuilder implements TShirtsBuilder {

    @Override
    List<TShirt> buildTShirts(List<String> words) {
        def letters = getLetters(words)
        def tShirts = []
        letters.sort()
        letters.each { letter ->
            if (!letter.used) {
                letter.used = true
                def tShirt = new TShirt(front: letter.value, back: '')
                Letter secondSide = letters.find {
                    it.value != letter.value && !it.used && !letter.incompatibleLetters.contains(it.value)
                    // todo !letter.incompatibleLetters.contains(it.value) is far from perfect and has a bug
                }
                if (secondSide) {
                    secondSide.used = true
                    tShirt.back = secondSide.value
                }
                tShirts << tShirt
            }
        }
        tShirts
    }

    LettersCollection getLetters(List<String> words) {
        def letters = new DefaultLetterCollection()
        words.each {
            letters.putAll(getWordLetters(it))
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
