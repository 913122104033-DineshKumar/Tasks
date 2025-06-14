package antCrawlings;

import java.util.Arrays;

public class AntMovement {
    private int[][] grid;
    private final int rows;
    private final int columns;
    private final int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    private final int[] movement = { 3, 2, 0, 1, 2, 3, 1, 0 };
    private final String[] moveNames = { "Left", "Right", "Up", "Down" };

    public AntMovement (int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new int[rows][columns];
    }

    private boolean isBoundary (int row, int col) {
        return row < 0 || col < 0 || row > rows || col > columns;
    }

    public String[] toString (int direction, int row, int col) {
        return new String[]{ row + "", col + "", moveNames[direction], grid[row][col] + "" };
    }

    public String[] getLastMovement (int direction, int movements, int row, int col) {
        for (int move = 0; move < movements; move++) {
            int color = grid[row][col];
            int currentMove = movement[(4 * color) + direction];
            int nRow = row + directions[currentMove][0];
            int nCol = col + directions[currentMove][1];
            if (isBoundary(nRow, nCol)) {
                return toString(direction, row, col);
            }
            String[] ans = toString(direction, row, col);
            System.out.println("(" + ans[0] + ", " + ans[1] + "): " + "{ direction: " + ans[2] + ", " + "Color: " + ans[3] + " }");
            row = nRow;
            col = nCol;
            direction = currentMove;
            grid[row][col] = 1 - color;
        }
        return toString(direction, row, col);
    }
}
