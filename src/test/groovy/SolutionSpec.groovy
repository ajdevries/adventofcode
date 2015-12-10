import spock.lang.Specification

public class SolutionSpec extends Specification {

    void "Day 00 - Getting things up and running, expecting day not found for day 32"() {
        expect:
        Solution.day 32, "solve", "" == "day not found"
    }

    void "Day 00 - Getting things up and running, solution not found for missing method"() {
        expect:
        Solution.day 32, "not found", "" == "solution not found"
    }



}