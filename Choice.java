import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Choice {
    static Player player1;
    static Player player2;
    public static String[] A = new String[]{"_", "_", "_"};
    public static String[] B = new String[]{"_", "_", "_"};
    public static String[] C = new String[]{" ", " ", " "};
    static ArrayList<String> movesAllowed = new ArrayList<>(Arrays.asList("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"));
    static int countp2 = 0;
    public static void player1(){
        // Player One name
        Scanner player1Scan = new Scanner(System.in);  //
        System.out.println("Player one, please enter username: ");
        String userName = player1Scan.nextLine();
        player1 = new Player(userName);
        System.out.println();
    }
    public static void player2(){
        // Player Two name

        String userName2 = "AI Miro";
        //Scanner player2Scan = new Scanner(System.in);
        //System.out.println("Player two, please enter username: ");
        //String userName2 = player2Scan.nextLine();
        player2 = new Player(userName2);
        System.out.println();
    }
    public static void board() {
        System.out.print(3 + "\t  ");
        for (int i = 0; i < 3; i++) {
            if (i < 2)
                System.out.print(A[i] + " | ");
            else
                System.out.println(A[i]);
        }
        System.out.print(2 + "\t  ");

        for (int i = 0; i < 3; i++) {
            if (i < 2)
                System.out.print(B[i] + " | ");
            else
                System.out.println(B[i]);
        }
        System.out.print(1 + "\t  ");

        for (int i = 0; i < 3; i++) {
            if (i < 2)
                System.out.print(C[i] + " | ");
            else
                System.out.println(C[i]);
        }
        System.out.println();
        System.out.println("\t  A   B   C");
        System.out.println();
    }
    public static void pOneInsert() {
        String pos = playerOneMove();
        switch (pos) {
            case "A3" -> A[0] = "X";
            case "B3" -> A[1] = "X";
            case "C3" -> A[2] = "X";
            case "A2" -> B[0] = "X";
            case "B2" -> B[1] = "X";
            case "C2" -> B[2] = "X";
            case "A1" -> C[0] = "X";
            case "B1" -> C[1] = "X";
            case "C1" -> C[2] = "X";
        }
    }
    public static void pTwoInsert() throws InterruptedException {
        String pos = playerTwoMove();
        switch (pos) {
            case "A3" -> A[0] = "O";
            case "B3" -> A[1] = "O";
            case "C3" -> A[2] = "O";
            case "A2" -> B[0] = "O";
            case "B2" -> B[1] = "O";
            case "C2" -> B[2] = "O";
            case "A1" -> C[0] = "O";
            case "B1" -> C[1] = "O";
            case "C1" -> C[2] = "O";
        }
    }
    public static String playerOneMove() {
        Scanner p1move = new Scanner(System.in);
        do {
            System.out.println(player1.getName() + ", it is your move!");
            String pos = p1move.nextLine();
            if (movesAllowed.contains(pos)) {
                movesAllowed.remove(pos);
                return pos;
            } else {
                System.out.println("Move not allowed! Please try again!");
            }
        } while (true);
    }
    public static String playerTwoMove() throws InterruptedException {
        Random r = new Random();
        Random e = new Random();
        long em = e.nextInt(3);
        System.out.println(player2.getName() + ", it is your move!");
        System.out.println();
        System.out.println("Thinking...");
        TimeUnit.SECONDS.sleep(em);
        do {
            if (A[0].equals("O") && A[1].equals("O") && A[2].equals("_")){
                String pos  = "C3";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[0].equals("O") && A[2].equals("O") && A[1].equals("_")){
                String pos  = "B3";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[1].equals("O") && A[2].equals("O") && A[0].equals("_")) {
                String pos = "A3";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[0].equals("O") && B[1].equals("O") && B[2].equals("_")){
                String pos  = "C2";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[0].equals("O") && B[2].equals("O")&& B[1].equals("_")){
                String pos  = "B2";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[1].equals("O") && B[2].equals("O")&& B[0].equals("_")) {
                String pos = "A2";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (C[0].equals("O") && C[1].equals("O") && C[2].equals(" ")){
                String pos  = "C1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (C[0].equals("O") && C[2].equals("O") && C[1].equals(" ")){
                String pos  = "B1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (C[1].equals("O") && C[2].equals("O") && C[0].equals(" ")) {
                String pos = "A1";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[0].equals("O") && B[0].equals("O") && C[0].equals(" ")){
                String pos  = "A1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[1].equals("O") && B[1].equals("O") && C[1].equals(" ")){
                String pos  = "B1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[2].equals("O") && B[2].equals("O") && C[2].equals(" ")) {
                String pos = "C1";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[0].equals("O") && C[0].equals("O") && B[0].equals("_")){
                String pos  = "A2";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[1].equals("O") && C[1].equals("O") && B[1].equals("_")){
                String pos  = "B2";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[2].equals("O") && C[2].equals("O") && B[2].equals("_")) {
                String pos = "C2";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[0].equals("O") && C[0].equals("O") && A[0].equals("_")){
                String pos  = "A3";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[1].equals("O") && C[1].equals("O") && A[1].equals("_")){
                String pos  = "B3";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[2].equals("O") && C[2].equals("O") && A[2].equals("_")) {
                String pos = "C3";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[0].equals("O") && B[1].equals("O") && C[2].equals(" ")){
                String pos  = "C1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[2].equals("O") && B[1].equals("O") && C[0].equals(" ")){
                String pos  = "A1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[0].equals("O") && C[2].equals("O") && B[1].equals("_")) {
                String pos = "B2";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[2].equals("O") && C[0].equals("O") && B[1].equals("_")){
                String pos  = "B2";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[1].equals("O") && C[2].equals("O") && A[0].equals("_")){
                String pos  = "A3";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[1].equals("O") && C[0].equals("O") && A[2].equals("_")) {
                String pos = "C3";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[0].equals("X") && A[1].equals("X") && A[2].equals("_")){
                String pos  = "C3";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[0].equals("X") && A[2].equals("X") && A[1].equals("_")){
                String pos  = "B3";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[1].equals("X") && A[2].equals("X") && A[0].equals("_")) {
                String pos = "A3";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[0].equals("X") && B[1].equals("X") && B[2].equals("_")){
                String pos  = "C2";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[0].equals("X") && B[2].equals("X") && B[1].equals("_")){
                String pos  = "B2";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[1].equals("X") && B[2].equals("X") && B[0].equals("_")) {
                String pos = "A2";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (C[0].equals("X") && C[1].equals("X") && C[2].equals(" ")){
                String pos  = "C1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (C[0].equals("X") && C[2].equals("X") && C[1].equals(" ")){
                String pos  = "B1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (C[1].equals("X") && C[2].equals("X") && C[0].equals(" ")) {
                String pos = "A1";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[0].equals("X") && B[0].equals("X") && C[0].equals(" ")){
                String pos  = "A1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[1].equals("X") && B[1].equals("X") && C[1].equals(" ")){
                String pos  = "B1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[2].equals("X") && B[2].equals("X") && C[2].equals(" ")) {
                String pos = "C1";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[0].equals("X") && C[0].equals("X") && B[0].equals("_")){
                String pos  = "A2";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[1].equals("X") && C[1].equals("X") && B[1].equals("_")){
                String pos  = "B2";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[2].equals("X") && C[2].equals("X") && B[2].equals("_")) {
                String pos = "C2";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[0].equals("X") && C[0].equals("X") && A[0].equals("_")){
                String pos  = "A3";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[1].equals("X") && C[1].equals("X") && A[1].equals("_")){
                String pos  = "B3";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[2].equals("X") && C[2].equals("X") && A[2].equals("_")) {
                String pos = "C3";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[0].equals("X") && B[1].equals("X") && C[2].equals(" ")){
                String pos  = "C1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[2].equals("X") && B[1].equals("X") && C[0].equals(" ")){
                String pos  = "A1";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[0].equals("X") && C[2].equals("X") && B[1].equals("_")) {
                String pos = "B2";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (A[2].equals("X") && C[0].equals("X") && B[1].equals("_")){
                String pos  = "B2";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[1].equals("X") && C[2].equals("X") && A[0].equals("_")){
                String pos  = "A3";
                if(movesAllowed.contains((pos))){
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (B[1].equals("X") && C[0].equals("X") && A[2].equals("_")) {
                String pos = "C3";
                if (movesAllowed.contains((pos))) {
                    movesAllowed.remove(pos);
                    return pos;
                }
            } else if (movesAllowed.size() == 8) {
                String[] posn = new String[]{"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3", "B2", "B2", "B2", "B1", "B2", "B2", "B2", "B2", "B2", "B2", "B2", "B2", "B2", "B2", "B2", "B2"};
                Random numposn = new Random();
                int nm= numposn.nextInt(24);
                String pos = posn[nm];
                if (movesAllowed.contains(pos)) {
                    movesAllowed.remove(pos);
                    return pos;
                } else {
                    String[] pos1 = new String[]{"A1", "A3", "C3", "C1"};
                    Random numb = new Random();
                    int numba = numb.nextInt(3);
                    pos = pos1[numba];
                    if (movesAllowed.contains(pos)){
                        movesAllowed.remove(pos);
                        return pos;
                    }
                }
            }
            if(movesAllowed.size() == 6){
                if (A[0].equals("X") && C[2].equals("X") || A[2].equals("X") && C[0].equals("X")){
                    String[] pos1 = new String[]{"A2", "B1", "B3", "C2", "A2", "B1", "B3", "C2", "A3", "C1", "A1", "C3"};
                    Random numb = new Random();
                    int numba = numb.nextInt(11);
                    String pos = pos1[numba];
                    if (movesAllowed.contains(pos)) {
                        movesAllowed.remove(pos);
                        return pos;
                    }
                }
            }
            int num = r.nextInt(movesAllowed.size());
            String pos = movesAllowed.get(num);
            if (movesAllowed.contains(pos)) {
                movesAllowed.remove(pos);
                return pos;
            } else {
                System.out.println("Move not allowed! Please try again!");
            }
        } while (true);
    }

    public static String playerTwoHuman(){
        Scanner p2move = new Scanner(System.in);
        do {
            System.out.println(player2.getName() + ", it is your move!");
            String pos = p2move.nextLine();
            if (movesAllowed.contains(pos)) {
                movesAllowed.remove(pos);
                return pos;
            } else {
                System.out.println("Move not allowed! Please try again!");
            }
        } while (true);
    }
    public static boolean pOneWinner() {
        boolean winner = false;
        if (A[0].equals("X") && A[1].equals("X") && A[2].equals("X")) {
            winner = true;
        } else if (B[0].equals("X") && B[1].equals("X") && B[2].equals("X")) {
            winner = true;
        } else if (C[0].equals("X") && C[1].equals("X") && C[2].equals("X")) {
            winner = true;
        } else if (A[0].equals("X") && B[0].equals("X") && C[0].equals("X")) {
            winner = true;
        } else if (A[1].equals("X") && B[1].equals("X") && C[1].equals("X")) {
            winner = true;
        } else if (A[2].equals("X") && B[2].equals("X") && C[2].equals("X")) {
            winner = true;
        } else if (A[0].equals("X") && B[1].equals("X") && C[2].equals("X")) {
            winner = true;
        } else if (A[2].equals("X") && B[1].equals("X") && C[0].equals("X")) {
            winner = true;
        }
        return winner;
    }
    public static boolean pTwoWinner() {
        boolean winner = false;
        if (A[0].equals("O") && A[1].equals("O") && A[2].equals("O")) {
            winner = true;
        } else if (B[0].equals("O") && B[1].equals("O") && B[2].equals("O")) {
            winner = true;
        } else if (C[0].equals("O") && C[1].equals("O") && C[2].equals("O")) {
            winner = true;
        } else if (A[0].equals("O") && B[0].equals("O") && C[0].equals("O")) {
            winner = true;
        } else if (A[1].equals("O") && B[1].equals("O") && C[1].equals("O")) {
            winner = true;
        } else if (A[2].equals("O") && B[2].equals("O") && C[2].equals("O")) {
            winner = true;
        } else if (A[0].equals("O") && B[1].equals("O") && C[2].equals("O")) {
            winner = true;
        } else if (A[2].equals("O") && B[1].equals("O") && C[0].equals("O")) {
            winner = true;
        }
        return winner;
    }
    public static void game() throws InterruptedException {
        while (true) {
            Choice.board();
            Choice.pOneInsert();
            System.out.println();
            if (Choice.pOneWinner()){
                System.out.println(player1.getName() + " wins!!!");
                System.out.println();
                Choice.board();
                System.out.println("Congratulations " + player1.getName() + "!");
                break;
            }
            if (movesAllowed.size() == 0) {
                System.out.println("Draw!");
                System.out.println("Good game!");
                break;
            }
            Choice.board();
            Choice.pTwoInsert();
            System.out.println();
            if (Choice.pTwoWinner()){
                System.out.println(player2.getName() + " wins!!!");
                System.out.println();
                Choice.board();
                System.out.println("Congratulations " + player2.getName() + "!");
                break;
            }
            if (movesAllowed.size() == 0){
                Choice.board();
                System.out.println("Good game!");
                break;
            }
            countp2 = countp2 + 1;
        }
    }
    public static void restartGame(){
        A = new String[]{"_", "_", "_"};
        B = new String[]{"_", "_", "_"};
        C = new String[]{" ", " ", " "};
        movesAllowed = new ArrayList<>(Arrays.asList("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"));
    }
}
