package day06

import DefaultDay
import groovy.transform.Immutable

import java.security.MessageDigest
import java.util.stream.Stream

class Day extends DefaultDay {
    def lights(instructions) {
        def grid = []
        1000.times {
            grid[it] = [0] * 1000
        }
        instructions.split('\n').each { instruction ->
            def m = instruction =~ /([a-z| ]*).* (\d*,\d*).* through (\d*,\d*)/
            def action = m[0][1]
            def from = m[0][2]
            def to = m[0][3]
            this."${action}"(grid, from, to)
        }
        grid.sum { it.count { it == 1 } }
    }

    def brightness(instructions) {
        def grid = []
        1000.times {
            grid[it] = [0] * 1000
        }
        instructions.split('\n').each { instruction ->
            def m = instruction =~ /([a-z| ]*).* (\d*,\d*).* through (\d*,\d*)/
            def action = m[0][1]
            def from = m[0][2]
            def to = m[0][3]
            this."brightness ${action}"(grid, from, to)
        }
        grid.sum { it.sum() }
    }

    protected def "turn on"(grid, from ,to) {
        apply(grid,from,to, { 1 } )
    }

    protected def "turn off"(grid, from ,to) {
        apply(grid,from,to, { 0 } )
    }

    protected def toggle(grid, from, to) {
        apply(grid,from,to, { light -> Math.abs(light - 1) } )
    }

    protected def "brightness turn on"(grid, from ,to) {
        apply(grid,from,to, { light -> light + 1 } )
    }

    protected def "brightness turn off"(grid, from ,to) {
        apply(grid,from,to, { light -> Math.max(light - 1, 0)} )
    }

    protected def "brightness toggle"(grid, from, to) {
        apply(grid,from,to, { light -> light + 2 } )
    }

    protected def apply(grid, from, to, closure) {
        int[] fromCoords = from.split(',').collect { it as Integer }
        int[] toCoords = to.split(',').collect { it as Integer }
        (fromCoords[0]..toCoords[0]).each { x ->
            (fromCoords[1]..toCoords[1]).each { y ->
                grid[x][y] = closure.call(grid[x][y])
            }
        }
    }
}
