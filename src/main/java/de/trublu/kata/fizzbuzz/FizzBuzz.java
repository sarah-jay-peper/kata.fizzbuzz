package de.trublu.kata.fizzbuzz;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FizzBuzz {

    private static final String NEWLINE = "\n";

    private static final String FIZZ = "Fizz";

    private final int number;

    private String result = "";

    public static String print(int max) {
        return IntStream.rangeClosed(1, max)
                .mapToObj(FizzBuzz::new)
                .map(FizzBuzz::transform)
                .reduce(FizzBuzz::reduceOutput)
                .orElse("");
    }

    public String transform() {
        addFizzIfDivisibleByThreeOrContainsThree();
        addBuzzIfDivisibleByFive();
        addFaceValueIfEmpty();
        return getResult();
    }

    private static String reduceOutput(String result, String current) {return result + NEWLINE + current;}

    private void addFaceValueIfEmpty() {
        if (result.isEmpty()) result = String.valueOf(number);
    }

    private void addFizzIfDivisibleByThreeOrContainsThree() {
        if (isDivisibleByThree(number) || containsThree(number)) result += FIZZ;
    }

    private void addBuzzIfDivisibleByFive() {
        if (isDivisibleByFive(number)) result += "Buzz";
    }

    private boolean containsThree(int number) {return String.valueOf(number).contains("3");}

    private static boolean isDivisibleByFive(int input) {return isDivisibleBy(5, input);}

    private static boolean isDivisibleByThree(int input) {return isDivisibleBy(3, input);}

    private static boolean isDivisibleBy(int divisor, int input) {return input % divisor == 0;}
}
