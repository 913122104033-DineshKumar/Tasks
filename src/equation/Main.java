package equation;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the First Equation: ");
//        String input1 = scanner.nextLine();
//        System.out.println("Enter the Second Equation: ");
//        String input2 = scanner.nextLine();
        Equation equation1 = Equation.parse("x + 9y");
        Equation equation2 = Equation.parse("10x + 11y");
        Equation finalEquation = equation1.multiply(equation2);
        System.out.println(finalEquation.toString());
    }
}
