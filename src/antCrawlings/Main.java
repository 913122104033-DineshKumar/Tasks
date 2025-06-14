package antCrawlings;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Number of rows: ");
//        int rows = scanner.nextInt();
//        System.out.println("Enter Number of Columns: ");
//        int columns = scanner.nextInt();
        AntMovement antMovement = new AntMovement(40, 41);
//        System.out.println("Enter the row: ");
//        int row = scanner.nextInt();
//        System.out.println("Enter the column: ");
//        int column = scanner.nextInt();
//        System.out.println("Enter the direction: ");
//        char direction = scanner.next().charAt(0);
//        System.out.println("Enter the Number of Movements: ");
//        int movements = scanner.nextInt();
        String[] ans = antMovement.getLastMovement(1, 60, 20, 20);
        System.out.println("(" + ans[0] + ", " + ans[1] + "): " + "{ direction: " + ans[2] + ", " + "Color: " + ans[3] + " }");
        destroy(scanner);
    }

    public static void destroy (Scanner scanner) {
        scanner.close();
    }

}
