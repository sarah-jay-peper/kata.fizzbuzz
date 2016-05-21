package de.trublu.kata.fizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzz {

    private static final String NEWLINE = "\n";

    public static String print(int max) {
        return IntStream.rangeClosed(1, max)
                .mapToObj(FizzBuzz::transform)
                .reduce((result, current) -> result + NEWLINE + current)
                .orElse("");
    }

    public static String transform(int input) {
        String result = "";
        result = replaceFizz(input, result);
        result = replaceBuzz(input, result);
        result = replaceFaceValue(input, result);
        return result;
    }

    private static String replaceFaceValue(int input, String result) {
        if (result.isEmpty()) {
            result = String.valueOf(input);
        }
        return result;
    }

    private static String replaceFizz(int input, String result) {
        if (input % 3 == 0) {
            result += "Fizz";
        }
        return result;
    }

    private static String replaceBuzz(int input, String result) {
        if (input % 5 == 0) {
            result += "Buzz";
        }
        return result;
    }
}
