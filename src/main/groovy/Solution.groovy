class Solution {

    static void main(String[] args) {
        if (args.length == 2) {
            long start = System.currentTimeMillis()
            println "Solution for day '${args[0]}', problem '${args[1]}' is: " +
                    Solution.day(args[0], args[1], new File("src/main/groovy/${day(args[0])}/input").text)
            println "In ${System.currentTimeMillis() - start} msec."
        } else if (args.length == 1 && args[0] == 'solutions') {
            (1..31).each { number ->
                def day = dayClass(number)
                if (day.simpleName == 'Day') {
                    day.newInstance().problems().each { problem ->
                        println "Day ${(number as String).padLeft(2, '0')} - Problem ${problem}. Start with ./gradlew solution -Pday=${number} -Pproblem=${problem}"
                    }
                }
            }
        } else {
            println "Missing day or problem or both. Start with ./gradlew solution -Pday=2 -Pproblem=wrappingpaper or try ./gradlew solutions"
        }
    }

    static def day(number, problem, input) {
        def day = dayClass number
        day.newInstance()."${problem}"(input)
    }

    static def dayClass(number) {
        try {
            return Class.forName("${day(number)}.Day".toString())
        } catch (ClassNotFoundException e) {
            // ignore
        }
        DefaultDay.class
    }

    protected static def day(number) {
        "day${(number as String).padLeft(2, '0')}"
    }
}
