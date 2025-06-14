import java.util.Scanner;

public class ScreenSaver {

    private static int[] screenSaver (int moves, String name, int height, int width) {
        int length = name.length();
        if (length >= width) {
            return new int[]{ -1, -1 };
        }
        int row = 0;
        int col = 0;
        int maxWidth = width - length;
        int maxHeight = maxWidth - length - 1;
        int rowOperation = 1;
        int colOperation = 1;
        for (int move = 0; move < moves; moves++) {
            if (row <= 0 || row >= maxHeight) {
                rowOperation *= -1;
            }
            if (col <= 0 || col >= maxWidth) {
                colOperation *= -1;
            }
            row = row + rowOperation;
            col = col + colOperation;
        }
        return new int[]{ row, col };
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the height of the screen: ");
        int height = scanner.nextInt();
        System.out.println("Enter the width of the screen: ");
        int width = scanner.nextInt();
        System.out.println("Enter the moves of the screen: ");
        int moves = scanner.nextInt();
        System.out.println("Enter Name: ");
        String name = scanner.next();
    }

}
