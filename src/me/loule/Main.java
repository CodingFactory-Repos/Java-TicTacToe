package me.loule;

// Import Scanner
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Clear Console
        System.out.print("\033[H\033[2J");

        // Initialize Scanner
        Scanner scanner = new Scanner(System.in);

        // Print Welcome Message
        System.out.println("Bienvenue dans le TicTacToe !");
        System.out.println("-- ---- --");

        //////////////////////////////
        // Creation of a TicTacToe //
        /////////////////////////////

        //  Prompt player names
        System.out.print("👨‍💻 Enter first player name: ");
        String player1[] = {scanner.nextLine(), "X"};
        System.out.print("👩‍💻 Enter second player name: ");
        String player2[] = {scanner.nextLine(), "O"};

        // Clear Console
        System.out.print("\033[H\033[2J");

        // Print Welcome Message with players names
        System.out.println("💁‍ Bienvenue " + player1[0] + " et " + player2[0] + " dans le TicTacToe !");
        System.out.println("💁 " + player1[0] + " tu seras le " + player1[1]);
        System.out.println("💁 " + player2[0] + " tu seras le " + player2[1]);
        System.out.println("💁 Préparation du jeu...");

        // Game Options
        String board[] = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        int turn = 1;


        System.out.println("💁 Je pense que le jeu peux maintenant commencer...");

        displayBoard(board, player1, player2);

        // Game Start
        while (turn < board.length) {
            // Player 1 turn
            if (turn % 2 == 1) {
                System.out.println("💁 " + player1[0] + " c'est à toi de jouer !");
                System.out.print("💁 Choisis une case: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (board[choice - 1].equals(" ")) {
                    board[choice - 1] = player1[1];
                    turn++;
                } else {
                    System.out.println("💁 La case est déjà prise !");
                }
            } else {
                // Player 2 turn
                System.out.println("💁 " + player2[0] + " c'est à toi de jouer !");
                System.out.print("💁 Choisis une case: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (board[choice - 1].equals(" ")) {
                    board[choice - 1] = player2[1];
                    turn++;
                } else {
                    System.out.println("💁 La case est déjà prise !");
                }
            }
            // Clear console
            System.out.print("\033[H\033[2J");

            // Display Board
            displayBoard(board, player1, player2);

            if (checkWin(board, player1) || checkWin(board, player2)) {
                break;
            } else if(turn >= board.length) {
                // Clear Console
                System.out.print("\033[H\033[2J");
                System.out.println("💁 Aucun joueurs ne gagnent cette manche");
            }
        }
    }

    // Display the board
    public static void displayBoard(String[] board, String[] player1, String[] player2) {
        System.out.println("---- ---- ---");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("---- ---- ---");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("---- ---- ---");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("---- ---- ---");
        System.out.println("");
        System.out.println("👨‍💻 " + player1[0] + " : " + player1[1] + " | 👩‍💻 " + player2[0] + " : " + player2[1]);
    }

    // Check if player win
    public static boolean checkWin(String[] board, String[] player) {
        for(int i = 0; i < board.length; i++) {
            if (board[i].equals(player[1])) {
                if (i == 0 || i == 3 || i == 6) {
                    if (board[i].equals(board[i + 1]) && board[i].equals(board[i + 2])) {
                        System.out.println("💁 " + player[0] + " a gagné !");
                        return true;
                    }
                }
                if (i == 0 || i == 1 || i == 2) {
                    if (board[i].equals(board[i + 3]) && board[i].equals(board[i + 6])) {
                        System.out.println("💁 " + player[0] + " a gagné !");
                        return true;
                    }
                }
                if (i == 0 || i == 4 || i == 8) {
                    if (board[i].equals(board[i + 4]) && board[i].equals(board[i + 8])) {
                        System.out.println("💁 " + player[0] + " a gagné !");
                        return true;
                    }
                }
                if (i == 2 || i == 4 || i == 6) {
                    if (board[i].equals(board[i + 2]) && board[i].equals(board[i + 4])) {
                        System.out.println("💁 " + player[0] + " a gagné !");
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
