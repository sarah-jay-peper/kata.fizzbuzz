package de.trublu.kata.fizzbuzz

import spock.lang.Specification
import spock.lang.Unroll

class FizzBuzzSpec extends Specification {

    @Unroll
    def "test input #testName"() {
        when: "input"
            def output = new FizzBuzz(number).transform();
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
            "13, Fizz"     | 13     | "Fizz"
            "15, FizzBuzz" | 15     | "FizzBuzz"
            "16"           | 16     | "16"
            "23, Fizz"     | 23     | "Fizz"
            "30, FizzBuzz" | 30     | "FizzBuzz"
            "31, Fizz"     | 31     | "Fizz"
            "35, FizzBuzz" | 35     | "FizzBuzz"
            "41"           | 41     | "41"
            "52, Buzz"     | 52     | "Buzz"
            "51, Buzz"     | 51     | "FizzBuzz"
            "56, Buzz"     | 56     | "Buzz"
    }

    def "test output for values 1 to 100"() {
        when: "get up to 100"
            def result = FizzBuzz.print(100);
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
Fizz
14
FizzBuzz
16
17
Fizz
19
Buzz
Fizz
22
Fizz
Fizz
Buzz
26
Fizz
28
29
FizzBuzz
Fizz
Fizz
Fizz
Fizz
FizzBuzz
Fizz
Fizz
Fizz
Fizz
Buzz
41
Fizz
Fizz
44
FizzBuzz
46
47
Fizz
49
Buzz
FizzBuzz
Buzz
FizzBuzz
FizzBuzz
Buzz
Buzz
FizzBuzz
Buzz
Buzz
FizzBuzz
61
62
Fizz
64
Buzz
Fizz
67
68
Fizz
Buzz
71
Fizz
Fizz
74
FizzBuzz
76
77
Fizz
79
Buzz
Fizz
82
Fizz
Fizz
Buzz
86
Fizz
88
89
FizzBuzz
91
92
Fizz
94
Buzz
Fizz
97
98
Fizz
Buzz"""
    }
}
