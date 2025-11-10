import java.util.Scanner;

public class TicTacToe {
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
                int row = SafeInput.getRangedInt(in, "Player " + currentPlayer + ", enter row (1-3): ", 1, 3) - 1;
                int col = SafeInput.getRangedInt(in, "Player " + currentPlayer + ", enter col (1-3): ", 1, 3) - 1;

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
                        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                    }
                } else {
                    System.out.println("invalid move. That space is already taken.");
                }
            }

            playAgain = SafeInput.getYNconfirm(in, "Would you like to play again?");
        } while (playAgain);
    }

    private static void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = " ";
            }
        }
    }
    private static void displayBoard() {
        System.out.println("\nCurrent Board:");
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(" " + board[row][col] + " ");
                if (col < COLS - 1) System.out.print("|");
            }
                System.out.println(); // end of row
                if (row < ROWS - 1) System.out.print("---+---+---"); // add new line here
                System.out.println();
        }
    }
    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }
    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }
    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].equals(player) &&
                    board[row][1].equals(player) &&
                            board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col].equals(player) &&
                    board[1][col].equals(player) &&
                            board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player)) ||
                (board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player));
    }
    private static boolean isTie() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}