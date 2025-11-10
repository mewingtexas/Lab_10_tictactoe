import java.util.Scanner;

public class tictacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];
    private static String currentPlayer = "X";
    public static void main(String[] args) {
        clearBoard();
        Scanner in = new Scanner(System.in);
        int row, col;
        String rowPrompt, colPrompt;
        boolean done  = false;
        do {
            while(true) {
                rowPrompt = "Player " + currentPlayer + "enter row move ";
                colPrompt = "Player " + currentPlayer + "enter col move ";
                row = SafeInput.getRangedInt(in, rowPrompt, 1, 3) - 1;
                col = SafeInput.getRangedInt(in, colPrompt, 1, 3) - 1;
                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    break;

                } else {
                    System.out.println("Invalid move, make the right move");
                }
            }
            if (isWin(currentPlayer)) {
                done = true;
            }


        } while (!done);

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