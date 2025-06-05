import java.util.Scanner;

public class NumericalMethods {
    private static void siameseAlgorithm (int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int currentRow = 0;
        int currentCol = n / 2;
        matrix[currentRow][currentCol] = num++;
        while (num <= n * n) {
            int nRow = ((currentRow - 1) + n) % n;
            int nCol = (currentCol + 1) % n;
            if (matrix[nRow][nCol] == 0) {
                matrix[nRow][nCol] = num++;
                currentRow = nRow;
                currentCol = nCol;
            } else {
                matrix[(currentRow + 1) % n][currentCol] = num++;
                currentRow = (currentRow + 1) % n;
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.printf("%4s", matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void babylonianAlgorithm (int n) {
        float guess = n / (float) 2;
        float minLimit = (float) n - (float) 0.002;
        float maxLimit = (float) n + (float) 0.002;
        while (true) {
            float currentGuess = (guess + ((float) n) / guess) / (float) 2;
            float sqrt = currentGuess * currentGuess;
            if (sqrt >= minLimit && sqrt <= maxLimit) {
                System.out.println(currentGuess);
                break;
            }
            guess = currentGuess;
        }
    }

    private static void gaussJordanElimination (int[][] matrix, int[] values) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] markZeroes = new int[n][m];
        int row = n - 1, col = 0;
        while (row > 0) {
            for (int r = 0; r < n; r++) {

            }
        }
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scanner.nextInt();
        babylonianAlgorithm(n);
    }

}
