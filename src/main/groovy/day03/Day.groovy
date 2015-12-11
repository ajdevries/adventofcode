package day03

import DefaultDay
import groovy.transform.Immutable

class Day extends DefaultDay {
    def houses(directions) {
        def current = new Location()
        def houses = [(current):1]
        (directions as List).each { direction ->
            current = current."move${direction}"()
            houses[current] = houses.get(current, 0) + 1
        }
        houses.size()
    }

    def housesWithRoboSanta(directions) {
        def santa = new Location(who: 'Santa')
        def roboSanta = new Location(who: 'Robo-Santa')
        def houses = [(santa):1, (roboSanta) : 1]
        (directions as List).eachWithIndex { direction, index ->
            def santas = this."move${index % 2}"(direction, houses, santa, roboSanta)
            santa = santas[0]
            roboSanta = santas[1]
        }
        houses.size() - 1
    }

    // moves santa
    protected def move0(direction, houses, santa, roboSanta) {
        santa = santa."move${direction}"()
        houses[santa] = houses.get(santa, 0) + 1
        [santa, roboSanta]
    }

    protected def move1(direction, houses, santa, roboSanta) {
        roboSanta = roboSanta."move${direction}"()
        houses[roboSanta] = houses.get(roboSanta, 0) + 1
        [santa, roboSanta]
    }

    @Immutable
    class Location {
        int x=0,y=0
        String who = "Santa"

        def "move^"() {
            new Location(x:this.x, y:this.y+1)
        }

        def movev() {
            new Location(x:this.x, y:this.y-1)
        }

        def "move>"() {
            new Location(x:this.x+1, y:this.y)
        }

        def "move<"() {
            new Location(x:this.x-1, y:this.y)
        }

        @Override
        String toString() {
            "${x}x${y}"
        }
    }
}
