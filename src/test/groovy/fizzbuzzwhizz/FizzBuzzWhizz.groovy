package fizzbuzzwhizz

import spock.lang.Specification

/**
 * Created by jxzhong on 17/1/21.
 */
class FizzBuzzWhizz extends Specification {

    def "fizz buzz whizz"() {
        expect:
        new CallCenter().call(n).toString() == expect
        where:
        n            | expect
        3            | "Fizz"
        5            | "Buzz"
        7            | "Whizz"
        3 * 5 * 7    | "FizzBuzzWhizz"
        3 * 5        | "FizzBuzz"
        3 * 7        | "FizzWhizz"
        (5 * 7) * 2  | "BuzzWhizz"
        13           | "Fizz"
        35 /* 5*7 */ | "Fizz"  /* not "BuzzWhizz" */
        2            | "2"
    }
}
