/*
 * Level 2- Task 1: Tic-Tac-Toe Game
 * 
 * Description: Implement a two-player tic-tac-toe game.
 *              Display the game board and prompt each player to enter their moves.
 *              Check for a winning condition or a draw after each move, and display the result accordingly.
 *              Allow the players to play multiple rounds if desired.
 * 
 * Skills: Arrays or matrices, loops, conditional statements.
 */

import java.util.*;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    private static int rounds = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            initialiseBoard();
            boolean gameInProg = true;

            while (gameInProg) {
                displayBoard();
                getPlayerMove(sc);

                if (checkWin()) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameInProg = false;
                } else if (checkDraw()) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    gameInProg = false;
                } else {
                    switchPlayer();
                }
            }

            System.out.print("Play again? (yes/no): ");
            String playAgainChoice = sc.next().toLowerCase();
            if (!playAgainChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }

    private static void initialiseBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        rounds++;
        currentPlayer = (rounds % 2 == 0) ? 'O' : 'X';
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static void getPlayerMove(Scanner sc) {
        boolean validMove = false;

        while (!validMove) {
            System.out.print("Player " + currentPlayer + ", enter your row (0, 1, or 2): ");
            int row = sc.nextInt();
            System.out.print("Player " + currentPlayer + ", enter your column (0, 1, or 2): ");
            int col = sc.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                validMove = true;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWin() {
        for (int i = 0; i < 3; i++){
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;

            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;

        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
