package de.trublu.kata.fizzbuzz;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

public final class FizzBuzz {
    private static final String NEWLINE = "\n";

    public String print(int max) {
        return IntStream.rangeClosed(1, max)
                .mapToObj(FizzBuzzNumber::new)
                .map(this::transform)
                .reduce(FizzBuzz::reduceOutput)
                .orElse("");
    }

    public String transform(FizzBuzzNumber number) {
        return number.addFizzIfDivisibleByThreeOrContainsThree()
                .addBuzzIfDivisibleByFiveOrContainsFive()
                .addFaceValueIfEmpty()
                .toString();
    }

    private static String reduceOutput(String result, String current) {return result + NEWLINE + current;}

}

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class FizzBuzzInput {
    private final int number;

    boolean contains(int numeral) {
        return String.valueOf(number).contains(String.valueOf(numeral));
    }

    boolean isDivisibleBy(int divisor) {return number % divisor == 0;}

    public String toString() {
        return String.valueOf(number);
    }
}

class FizzBuzzNumber {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    private String result = "";

    private final FizzBuzzInput input;

    FizzBuzzNumber(int input) {
        this.input = new FizzBuzzInput(input);
        result = "";
    }

    FizzBuzzNumber addFaceValueIfEmpty() {
        if (result.isEmpty()) set(input.toString());
        return this;
    }

    FizzBuzzNumber addFizzIfDivisibleByThreeOrContainsThree() {
        if (input.isDivisibleBy(3) || input.contains(3)) add(FIZZ);
        return this;
    }

    FizzBuzzNumber addBuzzIfDivisibleByFiveOrContainsFive() {
        if (input.isDivisibleBy(5) || input.contains(5)) add(BUZZ);
        return this;
    }

    public String toString() {return result;}

    private void set(String input) { result = input;}

    private void add(String input) {result += input;}
}