package de.trublu.kata.fizzbuzz

import spock.lang.Specification
import spock.lang.Unroll

import static de.trublu.kata.fizzbuzz.FizzBuzz.*

class FizzBuzzSpec extends Specification {

    @Unroll
    def "test input #testName"() {
        when: "input"
            def output = transform(number);
        then:
            output == expectedOutput
        where:
            testName  | number | expectedOutput
            "1"       | 1      | "1"
            "2"       | 2      | "2"
            "3, Fizz" | 3      | "Fizz"
            "5, Buzz" | 5      | "Buzz"
            "6, Fizz" | 6      | "Fizz"
            "9, Fizz" | 9      | "Fizz"
    }

}
