package Game;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        int noOfTimesPlayed = 0;
        int currentValue = 1;
        while (noOfTimesPlayed <= 8) {
            game.printBoard();
            System.out.println("Enter Position: ");
            int position = scanner.nextInt();
            while (!game.put(position, currentValue)) {
                System.out.println("Enter Valid Position: ");
                position = scanner.nextInt();
            }
            if (noOfTimesPlayed > 4 && game.isWin(currentValue)) {
                char winner = (currentValue == 1) ? 'X' : 'O';
                game.printBoard();
                System.out.println("Player " + winner + " has won the game.");
                break;
            }
            noOfTimesPlayed++;
            currentValue *= -1;
        }
        if (!game.isWin(currentValue)) {
            System.out.println("Game is draw...");
        }
    }
}
