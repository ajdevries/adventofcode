package day04

import DefaultDay
import groovy.transform.Immutable

import java.security.MessageDigest
import java.util.stream.Stream

class Day extends DefaultDay {
    def mine(key) {
        (0..10000000).find { number ->
            md5(key + number).startsWith('00000')
        }
    }

    def mineSix(key) {
        (0..10000000).find { number ->
            md5(key + number).startsWith('000000')
        }
    }

    protected def md5(str) {
        MessageDigest.getInstance("MD5").digest(str.bytes).encodeHex().toString()
    }
}
