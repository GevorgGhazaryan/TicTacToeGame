package Game;

import java.util.Scanner;

public class Input {
    private static String player1, player2;
    private static String boardSize;
    private static int condition;
    private static int[] cordinats = new int[2];
    private static int coordinateOfRow, coordinateOfColumn;
    Scanner scanner = new Scanner(System.in);

    Input(){
        setPlayer1();
        setPlayer2();
        setBoardSize();
        setCondition();
    }

    private void setPlayer1() {
        System.out.println("Please enter the first player's name");
        this.player1 = scanner.nextLine();
    }

    private void setPlayer2() {
        System.out.println("Please enter the second player's name");
        this.player2 = scanner.nextLine();
    }

    private void setBoardSize() {
        System.out.println("Enter the Board's size(axb)");
        this.boardSize = scanner.nextLine();
    }

    private void setCondition() {
        System.out.println("Enter the Condition");
        this.condition = scanner.nextInt();
    }

    public static String getPlayer1() {
        return player1;
    }

    public static String getPlayer2() {
        return player2;
    }

    public static String getBoardSize() {
        return boardSize;
    }

    public static int getCondition() {
        return condition;
    }

    public void setCoordinates() {
        System.out.print("Dear " + GameProcess.currentPlayer + " enter the coordinats(a,b)");
        String currentPlayerCordinats = scanner.next();
        getCordinats(currentPlayerCordinats);
        coordinateOfRow = cordinats[0];
        coordinateOfColumn = cordinats[1];
    }

    public int[] getCordinats(String cord) {
        cordinats[0] = Integer.parseInt(cord.substring(0, cord.indexOf(",")));
        cordinats[1] = Integer.parseInt(cord.substring(cord.indexOf(",") + 1, cord.length()));

        return cordinats;
    }

    public static int getCoordinateOfRow() { return coordinateOfRow; }

    public static int getCoordinateOfColumn() { return coordinateOfColumn; }
}
