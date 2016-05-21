package de.trublu.kata.fizzbuzz;

public class FizzBuzz {

    public static String print(int max) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            builder.append(transform(i)).append("\n");
        }
        return builder.toString();
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
