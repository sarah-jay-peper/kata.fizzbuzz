package de.trublu.kata.fizzbuzz;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

public class FizzBuzz {

    private static final String NEWLINE = "\n";


    @Getter
    private FizzBuzzResult result;

    public FizzBuzz(int number) {
        result = new FizzBuzzResult(number);
    }

    public static String print(int max) {
        return IntStream.rangeClosed(1, max)
                .mapToObj(FizzBuzz::new)
                .map(FizzBuzz::transform)
                .reduce(FizzBuzz::reduceOutput)
                .orElse("");
    }

    public String transform() {
        return result.addFizzIfDivisibleByThreeOrContainsThree()
                .addBuzzIfDivisibleByFiveOrContainsFive()
                .addFaceValueIfEmpty()
                .toString();
    }

    private static String reduceOutput(String result, String current) {return result + NEWLINE + current;}

}

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class FizzBuzzNumber {
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

class FizzBuzzResult {

    private static final String FIZZ = "Fizz";

    private static final String BUZZ = "Buzz";

    private String result = "";

    private final FizzBuzzNumber number;

    FizzBuzzResult(int number) {
        this.number = new FizzBuzzNumber(number);
        result = "";
    }

    FizzBuzzResult addFaceValueIfEmpty() {
        if (result.isEmpty()) set(number.toString());
        return this;
    }

    FizzBuzzResult addFizzIfDivisibleByThreeOrContainsThree() {
        if (number.isDivisibleByThree() || number.containsThree()) add(FIZZ);
        return this;
    }

    FizzBuzzResult addBuzzIfDivisibleByFiveOrContainsFive() {
        if (number.isDivisibleByFive() || number.containsFive()) add(BUZZ);
        return this;
    }

    public String toString() {return result;}

    private void set(String input) { result = input;}

    private void add(String input) {result += input;}
}