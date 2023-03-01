import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Setting up players for game and posting instructions---------------------------------------------------------
        System.out.println();
        System.out.println("TIC TAC TOE!");
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        // Player One name
        Choice.player1();

        // Player Two name
        Choice.player2();

        // Printing goodies and HowTo
        System.out.println("GAME ON!");
        System.out.println("---------------------------------------------");
        System.out.println("Player One: X");
        System.out.println("Player Two: O");
        System.out.println();
        System.out.println("HOW TO: Choose your coordinates and type them in. Examples: A1, C2, B3.... ");
        System.out.println();
        //--------------------------------------------------------------------------------------------------------------

        // Game loop starts here
        Choice.game();
        while (true) {
            Scanner playAgain = new Scanner(System.in);
            System.out.println();
            System.out.println("Play again? ('yes'/'no')");
            String again = playAgain.nextLine();
            if (again.equals("yes".toLowerCase()) || again.equals("yes".toUpperCase())) {
                System.out.println();
                Choice.restartGame();
                Choice.game();
            } else {
                System.out.println();
                System.out.println("Thank you for playing, good bye!");
                break;
            }
        }
    }
}