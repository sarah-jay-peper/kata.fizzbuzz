package de.trublu.kata.fizzbuzz;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@Getter
public class FizzBuzz {

    private static final String NEWLINE = "\n";

    private static final String FIZZ = "Fizz";

    private static final String BUZZ = "Buzz";

    private final FizzBuzzNumber number;

    private String result = "";

    public FizzBuzz(int number) {
        this.number = new FizzBuzzNumber(number);
    }

    public static String print(int max) {
        return IntStream.rangeClosed(1, max)
                .mapToObj(FizzBuzz::new)
                .map(FizzBuzz::transform)
                .reduce(FizzBuzz::reduceOutput)
                .orElse("");
    }

    public String transform() {
        addFizzIfDivisibleByThreeOrContainsThree();
        addBuzzIfDivisibleByFiveOrContainsFive();
        addFaceValueIfEmpty();
        return getResult();
    }

    private static String reduceOutput(String result, String current) {return result + NEWLINE + current;}

    private void addFaceValueIfEmpty() {
        if (result.isEmpty()) result = number.toString();
    }

    private void addFizzIfDivisibleByThreeOrContainsThree() {
        if (number.isDivisibleByThree() || number.containsThree()) result += FIZZ;
    }

    private void addBuzzIfDivisibleByFiveOrContainsFive() {
        if (number.isDivisibleByFive() || number.containsFive()) result += BUZZ;
    }
}

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class FizzBuzzNumber {
    final int number;

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
