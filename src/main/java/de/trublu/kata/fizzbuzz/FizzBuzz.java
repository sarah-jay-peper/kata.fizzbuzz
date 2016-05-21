package de.trublu.kata.fizzbuzz;

public class FizzBuzz {
    public static String transform(Integer input) {
        if (input == 3 ) {
            return "Fizz";
        }
        if (input == 5 ) {
            return "Buzz";
        }
        return input.toString();
    }
}
