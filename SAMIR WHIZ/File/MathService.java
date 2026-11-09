package service;

public class MathService {

    public static int isPrime(int number) {

        if (number < 2) {
            return 0;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {

            if (number % i == 0) {
                return 0;
            }
        }

        return 1;
    }

    public static int calculateMod(int a, int b) {

        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return a % b;
    }

    public static double calculateSin(double degree) {

        return Math.sin(Math.toRadians(degree));
    }

    public static double calculateCos(double degree) {

        return Math.cos(Math.toRadians(degree));
    }

    public static double calculateTan(double degree) {

        return Math.tan(Math.toRadians(degree));
    }
}