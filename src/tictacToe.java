import java.util.Scanner;

public class tictacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playAgain;

        do {
            clearBoard();
            currentPlayer = "X";
            int moveCount = 0;
            boolean done = false;

            while (!done) {
                displayBoard();
                int row = SafeInput.getRangedInt(in, "Player" + currentPlayer + ", enter row (1-3),", 1, 3) - 1;
                int col = SafeInput.getRangedInt(in, "Player" + currentPlayer + ", enter col (1-3),", 1, 3) - 1;

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    moveCount++;

                    if (moveCount >= 5 && isWin(currentPlayer)) {
                        displayBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                        done = true;
                    } else if (moveCount == 9 && isTie()) {
                        displayBoard();
                        System.out.println("its a tie!");
                        done = true;
                    } else {
                        currentPlayer.equals("X") ? "O" : "X";
                    }
                } else {
                    System.out.println("invalid move. That space is already taken.");
                }
            }
        }

    }

    private static void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = " ";
            }
        }
    }
    private static void displayBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print("|");
                }
            }
            // move to a new line after each row
            System.out.println();
            if (row < 2) {
                System.out.println("-----");
            }
        }
    }
    private static boolean isValidMove(int row, int col) {
        if (board[row][col].equals(" ")) {
            return true;
        }
        return false;
    }
}