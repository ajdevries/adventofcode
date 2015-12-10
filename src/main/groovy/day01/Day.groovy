package day01

import DefaultDay

class Day extends DefaultDay {
    private static String UP = '('
    private static int BASEMENT = -1

    def floor(input) {
        (input as List).sum { direction -> this."${direction}"() }
    }

    def basement(input) {
        def floor = 0
        (input as List).findIndexOf { direction -> floor += this."${direction}"(); floor == BASEMENT } + 1
    }

    protected def "("() {
        1
    }

    protected def ")"() {
        -1
    }
}
