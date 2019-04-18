package Game;

public class GameProcess {
    public static String currentPlayer;

    void start() {
        Input input = new Input();
        Board myboard = new Board();
        System.out.println("START");
        currentPlayer = Input.getPlayer2();
        while (!myboard.finish(myboard.board)) {
            changePlayer();
            System.out.println("It's " + currentPlayer + "'s turn");
            input.setCoordinates();
            myboard.move(currentPlayer, Input.getCoordinateOfRow(), Input.getCoordinateOfColumn());
        }
        if (myboard.finish(myboard.board)) {
            System.out.println("Congrats to " + currentPlayer);
        }
        else {
            System.out.println("Sorry no one has won");
        }
    }

    private void changePlayer() {
        if (currentPlayer.equals(Input.getPlayer1()))
            currentPlayer = Input.getPlayer2();
        else
            currentPlayer = Input.getPlayer1();
    }

}
