package JavaProgramming;

import java.util.Scanner;

public class TicTacGame {
	
    private char[][] board;
    private char currentPlayer;
    
    public TicTacGame() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    public void playGame() {
        boolean gameOver = false;
        int moves = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Let's play Tic-Tac-Toe!");
        System.out.println("Player 1: X");
        System.out.println("Player 2: O");
        System.out.println("Enter row and column numbers (0-2) to make your move.");
        System.out.println();
        
        while (!gameOver) {
            displayBoard();
            System.out.print("Player " + currentPlayer + ", enter your move: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            if (isValidMove(row, col)) {
                makeMove(row, col);
                moves++;
                
                if (checkWin(row, col)) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (moves == 9) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        
        scanner.close();
        System.out.println("Game Over");
    }
    
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }
    
    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }
    
    private boolean checkWin(int row, int col) {
        // Check row
        if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
            return true;
        }
        
        // Check column
        if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
            return true;
        }
        
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        
        return false;
    }
    
    private void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
    	TicTacGame game = new TicTacGame();
        game.playGame();
    }
}
