package Game;

public class TicTacToe {

    private int[] board;

    public TicTacToe () {
        board = new int[9];
    }

    public boolean put (int position, int currentValue) {
        int currentPosition = position - 1;
        if(board[currentPosition] == 0) {
            board[currentPosition] = currentValue;
            return true;
        }
        return false;
    }

    public boolean match (int end1, int end2, int outerAdder, int innerAdder, int currentValue) {
        for (int position = 0; position < end1; position += outerAdder) {
            int noOfValues = 0;
            for (int curPosition = position; curPosition < position + end2; curPosition += innerAdder) {
                if (board[curPosition] == currentValue) {
                    noOfValues++;
                }
            }
            if (noOfValues == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isWin (int currentValue) {
        if (board[0] == currentValue && board[4] == currentValue && board[8] == currentValue) {
            return true;
        }
        if (board[2] == currentValue && board[4] == currentValue && board[6] == currentValue) {
            return true;
        }
        return match( 3, 9, 1, 3, currentValue) || match( 9, 3, 3, 1, currentValue);
    }

    public void printBoard () {
        System.out.println(("- ").repeat(6));
        System.out.print("|");
        for (int i = 0; i < 9; i++) {
            if (board[i] == 0) {
                System.out.print(" " + (i + 1) + " ");
            } else {
                System.out.print(" " + (board[i] == 1 ? "X" : "O") + " ");
            }
            if ((i + 1) % 3 == 0 && i != 8) {
                System.out.println(" |");
                System.out.print("|");
            }
        }
        System.out.println(" |");
        System.out.println(("- ").repeat(6));
    }

}
