import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            resetBoard();
            currentPlayer = 'X';
            boolean gameOn = true;

            while (gameOn) {
                printBoard();
                int row, col;

                while (true) {
                    System.out.println("Pemain " + currentPlayer + ", masukkan baris (1-3) dan kolom (1-3): ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Harap masukkan angka!");
                        scanner.next();
                        continue;
                    }
                    row = scanner.nextInt() - 1;

                    if (!scanner.hasNextInt()) {
                        System.out.println("Harap masukkan angka!");
                        scanner.next();
                        continue;
                    }
                    col = scanner.nextInt() - 1;

                    if (isValidMove(row, col)) {
                        break;
                    } else {
                        System.out.println("Posisi tidak valid! Coba lagi.");
                    }
                }

                board[row][col] = currentPlayer;

                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Selamat! Pemain " + currentPlayer + " menang!");
                    gameOn = false;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("Permainan seri!");
                    gameOn = false;
                } else {
                    switchPlayer();
                }
            }

            System.out.print("Ingin bermain lagi? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");

        } while (playAgain);

        System.out.println("Terima kasih sudah bermain!");
        scanner.close();
    }

    public static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Baris
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Kolom
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }
}
