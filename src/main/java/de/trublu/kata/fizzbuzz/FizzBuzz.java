package de.trublu.kata.fizzbuzz;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FizzBuzz {

    private static final String NEWLINE = "\n";

    private final int number;

    private String result = "";

    public static String print(int max) {
        return IntStream.rangeClosed(1, max)
                .mapToObj(FizzBuzz::new)
                .map(FizzBuzz::transform)
                .reduce((result, current) -> result + NEWLINE + current)
                .orElse("");
    }

    public String transform() {
        addFizzIfDivisibleByThree();
        addBuzzIfDivisibleByFive();
        addFaceValueIfEmpty();
        return getResult();
    }

    private void addFaceValueIfEmpty() {
        if (result.isEmpty()) result = String.valueOf(number);
    }

    private void addFizzIfDivisibleByThree() {
        if (isDivisibleByThree(number)) result += "Fizz";
    }

    private void addBuzzIfDivisibleByFive() {
        if (isDivisibleByFive(number)) result += "Buzz";
    }

    private static boolean isDivisibleByFive(int input) {return isDivisibleBy(5, input);}

    private static boolean isDivisibleByThree(int input) {return isDivisibleBy(3, input);}

    private static boolean isDivisibleBy(int divisor, int input) {return input % divisor == 0;}
}
