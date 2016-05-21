package de.trublu.kata.fizzbuzz;

public class FizzBuzz {
    public static String transform(int input) {
        if (input % 3 == 0) {
            return "Fizz";
        }
        if (input % 5 == 0) {
            return "Buzz";
        }
        return input + "";
    }
}
