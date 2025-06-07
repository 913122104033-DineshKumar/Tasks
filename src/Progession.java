import java.util.Scanner;

import static java.util.Collections.swap;

public class Progession {
    private static void arithimeticProgression (int a, int d, int n) {
        for (int i = a; i <= a * (n - 1); i += d) {
            System.out.println(i + " ");
        }
    }
    private static void geometricProgression (int a, int d, int n) {
        int num = a;
        for (int i = 1; i <= n; i++) {
            System.out.println(num);
            num *= d;
        }
    }

    private static void progression (int a, int d, int n, char type) {
        int multiplicationFactor;
        int adder;
        if (type == 'a') {
            multiplicationFactor = 1;
            adder = d;
        } else {
            multiplicationFactor = d;
            adder = 0;
        }
        int num = a;
        for (int i = 1; i <= n; i++) {
            System.out.println(num);
            num = (num * multiplicationFactor) + adder;
        }
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}
