package de.trublu.kata.fizzbuzz;

public class FizzBuzz {
    public static String transform(int input) {
        String result = "";
        if (input % 3 == 0) {
            result = "Fizz";
        }
        if (input % 5 == 0) {
            result += "Buzz";
        }
        if (result.isEmpty()) {
            result = String.valueOf(input);
        }
        return result;
    }
}
