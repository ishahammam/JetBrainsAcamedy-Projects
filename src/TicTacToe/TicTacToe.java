package src.TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    // Game board
    public static String[][] board = new String[3][3];
    public static Scanner scanner = new Scanner(System.in);
    public static String scoreBoard = Arrays.toString(board);

    // Player coordinates
    public static int firstCoordinate;
    public static int secondCoordinate;

    // Game state analysis variables
    public static boolean xWins = false;
    public static boolean oWins = false;
    public static boolean draw = false;
    public static boolean impossible = false;
    public static boolean notFinished = false;

    /* --------------------- RUN THE GAME --------------------- */
    public static void main(String[] args) {
        gameBoardInitialization();
        displayGameBoard();
        gameManager();
    }

    /* --------------------- INITIALIZING GAME BOARD --------------------- */
    public static void gameBoardInitialization() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[1].length; j++) {
                board[i][j] = " ";
            }
        }
    }

    /* --------------------- DISPLAYING THE GAME BOARD --------------------- */
    public static void displayGameBoard() {
        System.out.println("---------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[1].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    /* --------------------- PROCESSING PLAYER MOVEMENTS --------------------- */
    public static void promptingInputFromPlayers() {
        Scanner scanner2 = new Scanner(System.in);
        while (true) {
            try {
                firstCoordinate = Integer.parseInt(scanner2.next());
                secondCoordinate = Integer.parseInt(scanner2.next());
                processingInput(firstCoordinate, secondCoordinate);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    public static void processingInput(int firstCoordinate, int secondCoordinate) {
        if (firstCoordinate >= 1 && firstCoordinate <= 3 && secondCoordinate >= 1 && secondCoordinate <= 3) {
            String cellValue = board[firstCoordinate - 1][secondCoordinate - 1];
            if (cellValue.equalsIgnoreCase("X") || cellValue.equalsIgnoreCase("O")) {
                System.out.println("This cell is occupied! Choose another one!");
                promptingInputFromPlayers();
            } else {
                if (scoreBoard.charAt(scoreBoard.length() - 1) == 'X' || scoreBoard.charAt(scoreBoard.length() - 1) == ' ') {
                    board[firstCoordinate - 1][secondCoordinate - 1] = "O";
                    scoreBoard += "O";
                    displayGameBoard();
                } else {
                    board[firstCoordinate - 1][secondCoordinate - 1] = "X";
                    scoreBoard += "X";
                    displayGameBoard();
                }
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            promptingInputFromPlayers();
        }
    }

    /* --------------------- GAME STATES --------------------- */

    public static boolean isXWins() {
        // Checking all rows
        if (board[0][0].equalsIgnoreCase("X")) {
            if (board[0][1].equalsIgnoreCase("X")) {
                if (board[0][2].equalsIgnoreCase("X")) {
                    xWins = true;
                }
            }
        }

        if (board[1][0].equalsIgnoreCase("X")) {
            if (board[1][1].equalsIgnoreCase("X")) {
                if (board[1][2].equalsIgnoreCase("X")) {
                    xWins = true;
                }
            }
        }

        if (board[2][0].equalsIgnoreCase("X")) {
            if (board[2][1].equalsIgnoreCase("X")) {
                if (board[2][2].equalsIgnoreCase("X")) {
                    xWins = true;
                }
            }
        }

        // Checking all columns
        if (board[0][0].equalsIgnoreCase("X")) {
            if (board[1][0].equalsIgnoreCase("X")) {
                if (board[2][0].equalsIgnoreCase("X")) {
                    xWins = true;
                }
            }
        }

        if (board[0][1].equalsIgnoreCase("X")) {
            if (board[1][1].equalsIgnoreCase("X")) {
                if (board[2][1].equalsIgnoreCase("X")) {
                    xWins = true;
                }
            }
        }

        if (board[0][2].equalsIgnoreCase("X")) {
            if (board[1][2].equalsIgnoreCase("X")) {
                if (board[2][2].equalsIgnoreCase("X")) {
                    xWins = true;
                }
            }
        }

        // Checking diagonal values
        if (board[0][0].equalsIgnoreCase("X")) {
            if (board[1][1].equalsIgnoreCase("X")) {
                if (board[2][2].equalsIgnoreCase("X")) {
                    xWins = true;
                }
            }
        }

        if (board[0][2].equalsIgnoreCase("X")) {
            if (board[1][1].equalsIgnoreCase("X")) {
                if (board[2][0].equalsIgnoreCase("X")) {
                    xWins = true;
                }
            }
        }

        return xWins;
    }

    public static boolean isOWins() {
        // Checking all rows
        if (board[0][0].equalsIgnoreCase("O")) {
            if (board[0][1].equalsIgnoreCase("O")) {
                if (board[0][2].equalsIgnoreCase("O")) {
                    oWins = true;
                }
            }
        }

        if (board[1][0].equalsIgnoreCase("O")) {
            if (board[1][1].equalsIgnoreCase("O")) {
                if (board[1][2].equalsIgnoreCase("O")) {
                    oWins = true;
                }
            }
        }

        if (board[2][0].equalsIgnoreCase("O")) {
            if (board[2][1].equalsIgnoreCase("O")) {
                if (board[2][2].equalsIgnoreCase("O")) {
                    oWins = true;
                }
            }
        }

        // Checking all columns
        if (board[0][0].equalsIgnoreCase("O")) {
            if (board[1][0].equalsIgnoreCase("O")) {
                if (board[2][0].equalsIgnoreCase("O")) {
                    oWins = true;
                }
            }
        }

        if (board[0][1].equalsIgnoreCase("O")) {
            if (board[1][1].equalsIgnoreCase("O")) {
                if (board[2][1].equalsIgnoreCase("O")) {
                    oWins = true;
                }
            }
        }

        if (board[0][2].equalsIgnoreCase("O")) {
            if (board[1][2].equalsIgnoreCase("O")) {
                if (board[2][2].equalsIgnoreCase("O")) {
                    oWins = true;
                }
            }
        }

        // Checking diagonal values
        if (board[0][0].equalsIgnoreCase("O")) {
            if (board[1][1].equalsIgnoreCase("O")) {
                if (board[2][2].equalsIgnoreCase("O")) {
                    oWins = true;
                }
            }
        }

        if (board[0][2].equalsIgnoreCase("O")) {
            if (board[1][1].equalsIgnoreCase("O")) {
                if (board[2][0].equalsIgnoreCase("O")) {
                    oWins = true;
                }
            }
        }

        return oWins;
    }

    public static boolean isDraw() {
        if (!isXWins() && !isOWins() && !scoreBoard.contains(" ")) {
            draw = true;
        }
        return draw;
    }

    public static boolean isImpossible() {
        int xCount = 0;
        int oCount = 0;

        for (int i = 0; i < scoreBoard.length(); i++) {
            if (scoreBoard.charAt(i) == 'X') {
                xCount += 1;
            }
            if (scoreBoard.charAt(i) == 'O') {
                oCount += 1;
            }
        }

        if (xCount > oCount) {
            if (xCount - oCount >= 2) {
                impossible = true;
            }
        } else if (xCount < oCount) {
            if (oCount - xCount >= 2) {
                impossible = true;
            }
        }

        if (isXWins() && isOWins()) {
            impossible = true;
        }
        return impossible;
    }

    public static boolean isNotFinished() {
        if (scoreBoard.contains(" ") && !isImpossible() && !isXWins() && !isOWins()) {
            notFinished = true;
        }
        return notFinished;
    }

    /* --------------------- GAME MANAGER --------------------- */
    public static void gameManager() {

        while (true) {
            if (isXWins() && !isImpossible()) {
                System.out.println("X wins");
                break;
            } else if (isOWins() && !isImpossible()) {
                System.out.println("O wins");
                break;
            } else if (isDraw()) {
                System.out.println("Draw");
                break;
            } else if (isImpossible()) {
                System.out.println("Impossible");
                break;
            } else if (isNotFinished()) {
                promptingInputFromPlayers();
            }
        }
    }
}
