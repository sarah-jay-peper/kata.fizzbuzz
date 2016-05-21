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
        replaceFizz();
        replaceBuzz();
        replaceFaceValue();
        return getResult();
    }

    private void replaceFaceValue() {
        result = result.isEmpty() ? String.valueOf(number) : result;
    }

    private void replaceFizz() {
        result = isDivisibleByThree(number) ? result + "Fizz" : result;
    }

    private void replaceBuzz() {
        result = isDivisibleByFive(number) ? result + "Buzz" : result;
    }

    private static boolean isDivisibleByFive(int input) {return isDivisibleBy(5, input);}

    private static boolean isDivisibleByThree(int input) {return isDivisibleBy(3, input);}

    private static boolean isDivisibleBy(int divisor, int input) {return input % divisor == 0;}
}
