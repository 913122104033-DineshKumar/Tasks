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

    private static int[] reduceRow (int[][] matrix, int r1, int r2, int scalar1, int scalar2, int operation) {
        int[] ans = matrix[r2];
        for (int col = 0; col < matrix[0].length; col++) {
            ans[col] = (scalar1 * matrix[r1][col]) + (operation * (scalar2 * matrix[r2][col]));
        }
        return ans;
    }

    private static void gaussJordanElimination (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] markZeroes = new boolean[n][m];
        int row = n - 1;
        for (int col = 0; col < n; col++) {
            while (row > 0) {
                for (int curRow = 0; curRow < n; curRow++) {
                    if (curRow != row) {
                        if (matrix[curRow][col] % matrix[row][col] == 0) {
                            int scalar2 = curRow / row;
                            int operation = matrix[curRow][col] - (scalar2 * matrix[row][col]) == 0 ? -1 : 1;
                            matrix[row] = reduceRow(matrix, curRow, row, 1, curRow / row, operation);
                            markZeroes[row][0] = true;
                        } else if (matrix[row][col] % matrix[curRow][col] == 0) {
                            int scalar1 = row / curRow;
                            int operation = (scalar1 * matrix[curRow][col]) - matrix[row][col] == 0 ? -1 : 1;
                            matrix[row] = reduceRow(matrix, curRow, row, 1, curRow / row, operation);
                        } else {
                            int scalar1 = matrix[row][col];
                            int scalar2 = matrix[curRow][col];
                            int operation = (scalar1 * matrix[curRow][0]) - (scalar2 * matrix[row][0]) == 0 ? -1 : 1;
                            matrix[row] = reduceRow(matrix, curRow, row, scalar1, scalar2, operation);
                        }
                    }
                }
                markZeroes[row][0] = true;
                row--;
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
