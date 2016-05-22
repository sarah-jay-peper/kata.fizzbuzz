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

    boolean containsThree() {return containsNumeral(3, number);}

    boolean containsFive() {return containsNumeral(5, number);}

    boolean isDivisibleByFive() {return isDivisibleBy(5, number);}

    boolean isDivisibleByThree() {return isDivisibleBy(3, number);}

    private static boolean containsNumeral(int numeral, int number) {
        return String.valueOf(number).contains(String.valueOf(numeral));
    }

    private static boolean isDivisibleBy(int divisor, int input) {return input % divisor == 0;}

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
        if (input.isDivisibleByThree() || input.containsThree()) add(FIZZ);
        return this;
    }

    FizzBuzzNumber addBuzzIfDivisibleByFiveOrContainsFive() {
        if (input.isDivisibleByFive() || input.containsFive()) add(BUZZ);
        return this;
    }

    public String toString() {return result;}

    private void set(String input) { result = input;}

    private void add(String input) {result += input;}
}