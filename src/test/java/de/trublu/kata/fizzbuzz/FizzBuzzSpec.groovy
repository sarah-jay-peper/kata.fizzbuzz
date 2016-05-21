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
            testName       | number | expectedOutput
            "1"            | 1      | "1"
            "2"            | 2      | "2"
            "3, Fizz"      | 3      | "Fizz"
            "5, Buzz"      | 5      | "Buzz"
            "6, Fizz"      | 6      | "Fizz"
            "9, Fizz"      | 9      | "Fizz"
            "10, Buzz"     | 10     | "Buzz"
            "15, FizzBuzz" | 15     | "FizzBuzz"
            "30, FizzBuzz" | 30     | "FizzBuzz"
            "16"           | 16     | "16"
    }

    def "test output for values 1 to 100"() {
        when: "get up to 100"
            def result = FizzBuzz.print(20);
        then:
            result == """1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
16
17
Fizz
19
Buzz"""
    }
}
