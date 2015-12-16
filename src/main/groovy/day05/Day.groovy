package day05

import DefaultDay
import groovy.transform.Immutable

import java.security.MessageDigest
import java.util.stream.Stream

class Day extends DefaultDay {
    def nice(strings) {
        strings.split('\n').count { str ->
            def vowels = str =~ /[aeiou]/
            def twice = str =~ /(\w)\1{1}/
            def naughty = str =~ /ab|cd|pq|xy/
            vowels.count > 2 && twice.count > 0 && naughty.count == 0
        }
    }

    def nice2(strings) {
        strings.split('\n').count { str ->
            def twice = str =~ /(\w{2})\w*\1/
            def letterBetween = str =~ /(\w)\w\1/
            twice.count > 0 && letterBetween.count > 0
        }
    }
}
