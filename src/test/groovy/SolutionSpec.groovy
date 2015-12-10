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

    void "Day 00 - Getting things up and running, available problems"() {
        expect:
        Solution.dayClass(1).newInstance().problems() == ['basement','floor']
    }

    void "Day 01 - Not Quite Lisp - On which floor is Santa"() {
        expect:
        Solution.day(1, "floor", input) == floor

        where:
        input       || floor
        '('         || 1
        '(())'      || 0
        '()()'      || 0
        '((('       || 3
        '(()(()('   || 3
        '))((((('   || 3
        '())'       || -1
        '))('       || -1
        ')))'       || -3
        ')())())'   || -3
    }

    void "Day 01 - Not Quite Lisp - On which position is Santa in the basement"() {
        expect:
        Solution.day(1, "basement", input) == position

        where:
        input       || position
        ')'         || 1
        '()())'     || 5
        '())()))('  || 3
    }
}