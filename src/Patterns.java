import java.util.Scanner;

public class Patterns {
    private static void starPattern1 (int n) {
//         Star Pattern - 1
//         *   *   *
//          *   *
//          *
//          *
//          *   *
//          *   *   *
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.printf("%4s", "* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j <= n; j++) {
                System.out.printf("%4s", "* ");
            }
            System.out.println();
        }
    }

    private static void starPattern2 (int n) {
//         Star pattern - 2
//           *
//          * *
//         * * *
//        * * * *
//        * * * *
//         * * *
//          * *
//           *
        for (int i = 0; i < n; i++) {
            for (int space = 1; space <= (n / 2) + 1 - i; space++) {
                System.out.print(" ");
            }
            for (int j = n - i; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int space = n - i; space < n; space++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void starPattern3 (int n) {
//         Star pattern - 3
//                  *
//              *   *
//          *   *   *
//          *   *   *
//              *   *
//                  *
        for (int i = 0; i < n; i++) {
            for (int space = 1; space < n - i; space++) {
                System.out.printf("%4s", " ");
            }
            for (int j = n - i; j <= n; j++) {
                System.out.printf("%4s", "* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int space = n - i; space < n; space++) {
                System.out.printf("%4s", " ");
            }
            for (int j = 1; j <= n - i; j++) {
                System.out.printf("%4s", "* ");
            }
            System.out.println();
        }
    }

    private static void naturalNumberPattern (int n) {
        int sum = n * (n + 1) / 2;
        for (int row = n; row > 0; row--) {
            for (int space = 0; space < row * 2; space++) {
                System.out.print(" ");
            }
            int cnt = n - row + 1;
            int gap = row + 1;
            int start = sum - (row * (row - 1) / 2);
            while (cnt > 0) {
                if (cnt != n - row + 1) {
                    start -= gap;
                    System.out.print(start + " ");
                    gap++;
                } else {
                    System.out.print(start + " ");
                }
                cnt--;
            }
            System.out.println();
        }
    }

    private static void starPattern5 (int n) {
//         Star Pattern - 5
//         * * *
//         * *
//          *
//         * *
//        * * *
        for (int i = 0; i < n; i++) {
            for (int space = n - i; space < n; space++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 1; i < n; i++) {
            for (int space = 1; space <= (n / 2) + 1 - i; space++) {
                System.out.print(" ");
            }
            for (int j = n - i; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void numberPattern1 (int n) {
//         Number Pattern 1
//         1 2 3
//         6 5 4
//         7 8 9
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                for (int j = ((i - 1) * n) + 1; j <= ((i - 1) * n) + n; j++) {
                    System.out.printf("%4s", j + " ");
                }
            } else {
                for (int j = i * n; j > (i * n) - n; j--) {
                    System.out.printf("%4s", j + " ");
                }
            }
            System.out.println();
        }
    }

    private static void squarePattern (int n) {
        // Square Pattern
//        1    3    6   10
//        2    5    9   13
//        4    8   12   15
//        7   11   14   16
        int sum = n * (n + 1) / 2; // Total Sum
        for (int i = 0; i < n; i++) {
            int gap = i + 2; // Natural Gap
            for (int j = ((i * (i + 1)) / 2 )+ 1; j <= sum - i; j += gap++) {
                System.out.printf("%5s", j + " ");
            }
            gap = sum - i;
            for (int j = 1; j <= i; j++) {
                gap += (n + 1) - j;
                System.out.printf("%5s", gap + " ");
            }
            System.out.println();
        }
    }

    private static void starPatternX (int n) {
//         Star Pattern - X
//          *               *
//              *       *
//                  *
//              *       *
//          *               *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i || j == n - i + 1) {
                    System.out.printf("%4s", "* ");
                } else {
                    System.out.printf("%4s", " ");
                }
            }
            System.out.println();
        }
    }

    private static void starPatternXWithBorder (int n) {
//         Star Pattern - X
//          *               *
//          *   *       *   *
//          *       *       *
//          *   *       *   *
//          *               *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i || j == n || j == 1 || j == n - i + 1) {
                    System.out.printf("%4s", "* ");
                } else {
                    System.out.printf("%4s", " ");
                }
            }
            System.out.println();
        }
    }


    private static void starPatternXWithFullBorder (int n) {
//         Star Pattern - X
//          *   *   *   *   *
//          *   *       *   *
//          *       *       *
//          *   *       *   *
//          *   *   *   *   *
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i || j == n || j == 1 || j == n - i + 1 || i == 1 || i == n) {
                    System.out.printf("%4s", "* ");
                } else {
                    System.out.printf("%4s", " ");
                }
            }
            System.out.println();
        }
    }

    private static void numberPattern2 (int n) {
        // Number Pattern - 2
//        1   3   5   7
//        2   4   6   8
//        9  11  13  15
//        10  12  14  16
        for (int i = 1; i <= n; i++) {
            int start = (i % 2 == 1) ? (8 * (i / 2)) + 1 : (8 * ((i - 1) / 2)) + 2;
            for (int j = start; j < start + 8; j += 2) {
                System.out.printf("%4s", j + " ");
            }
            System.out.println();
        }
    }

    private static void numberPattern3 (int n) {
        // Number Pattern - 3
//        1  10  11  20  21
//        2   9  12  19  22
//        3   8  13  18  23
//        4   7  14  17  24
//        5   6  15  16  25
        int sum = -1;
        for (int i = 1; i <= n; i++) {
            int j = i;
            sum += 2;
            int cnt = 1;
            while (j <= n * n) {
                System.out.printf("%4s", j + " ");
                if (cnt % 2 == 1) {
                    j += (n * 2) - sum;
                } else {
                    j += sum;
                }
                cnt++;
            }
            System.out.println();
        }
    }

    private static void numberPattern4 (int n) {
        // Number Pattern - 4
//        1   5   9  13
//        2   6  10  14
//        3   7  11  15
//        4   8  12  16
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n * n; j += n) {
                System.out.printf("%4s", j + " ");
            }
            System.out.println();
        }
    }

    private static void spiralMatrix (int n) {
//        Spiral Matrix
//        1   2   3   4   5
//        16  17  18  19   6
//        15  24  25  20   7
//        14  23  22  21   8
//        13  12  11  10   9
        int[][] matrix = new int[n][n];
        int top = 0, left = 0, right = n - 1, bottom = n - 1;
        int num = 1;
        while (left <= right && top <= bottom) {
            for (int ind = left; ind <= right; ind++) {
                matrix[top][ind] = num++;
            }
            top++;
            for (int ind = top; ind <= bottom; ind++) {
                matrix[ind][right] = num++;
            }
            right--;
            if (bottom >= top) {
                for (int ind = right; ind >= left; ind--) {
                    matrix[bottom][ind] = num++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int ind = bottom; ind >= top; ind--) {
                    matrix[ind][left] = num++;
                }
                left++;
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.printf("%4s", matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void numberPattern6 (int n) {
        // Number Pattern - 6
//        5   5   5   5   5
//        5   4   4   4   5
//        5   4   3   4   5
//        5   4   4   4   5
//        5   5   5   5   5
        for (int i = 0; i <= n / 2; i++) {
            int start = n;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    System.out.printf("%4s", start + " ");
                } else if (j <= i && j != 0) {
                    start--;
                    System.out.printf("%4s", start + " ");
                } else if (j > n - i - 1) {
                    start++;
                    System.out.printf("%4s", start + " ");
                } else {
                    System.out.printf("%4s", start + " ");
                }
            }
            System.out.println();
        }

        for (int i = n - ((n / 2) + 1); i > 0; i--) {
            int start = n;
            for (int j = 0; j < n; j++) {
                if (j < i && j != 0) {
                    start--;
                    System.out.printf("%4s", start + " ");
                } else if (j > n - i) {
                    start++;
                    System.out.printf("%4s", start + " ");
                } else {
                    System.out.printf("%4s", start + " ");
                }
            }
            System.out.println();
        }
    }

    private static void numberPattern7 (int n) {
        // Number Pattern - 7
//        1   1   1   1   1
//        1   2   2   2   1
//        1   2   3   2   1
//        1   2   2   2   1
//        1   1   1   1   1
        for (int i = 0; i <= n / 2; i++) {
            int start = 1;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    System.out.printf("%4s", start + " ");
                } else if (j <= i && j != 0) {
                    start++;
                    System.out.printf("%4s", start + " ");
                } else if (j > n - i - 1) {
                    start--;
                    System.out.printf("%4s", start + " ");
                } else {
                    System.out.printf("%4s", start + " ");
                }
            }
            System.out.println();
        }

        for (int i = n - ((n / 2) + 1); i > 0; i--) {
            int start = 1;
            for (int j = 0; j < n; j++) {
                if (j < i && j != 0) {
                    start++;
                    System.out.printf("%4s", start + " ");
                } else if (j > n - i) {
                    start--;
                    System.out.printf("%4s", start + " ");
                } else {
                    System.out.printf("%4s", start + " ");
                }
            }
            System.out.println();
        }
    }

    private static void numberPattern8 (int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%5s", "(" + (i + j) % n + ", " + j +")" + " ");
            }
            System.out.println();
        }
    }

    private static void numberPattern9 (int n) {
        int num = 1;
        for (int i = 1; i <= (n / 2) + 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%4s", num++ + " ");
            }
            System.out.println();
        }
        for (int i = (n / 2) + 2; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.printf("%4s", num++ + " ");
            }
            System.out.println();
        }
    }

    private static void numberPattern10 (int n) {
        int num = 1;
        for (int i = 1; i <= (n / 2) + 1; i++) {
            int start = i;
            int gap = n - 1;
            for (int j = 1; j <= i; j++) {
                System.out.printf("%4s", start + " ");
                start += gap--;
            }
            System.out.println();
        }
        for (int i = (n / 2) + 2; i <= n; i++) {
            int start = i;
            int gap = n - 1;
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.printf("%4s", start + " ");
                start += gap--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of line: ");
        int n = scanner.nextInt();
        numberPattern8(n);
    }

}
