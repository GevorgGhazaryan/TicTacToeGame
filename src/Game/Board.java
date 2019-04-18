package Game;

public class Board {
    private int row, column;
    private int countOfPlayer1, countOfPlayer2;
    private char XorO = '.';
    public char[][] board;

    Board() {
        board = boardMatrix(Input.getBoardSize());
    }

    private char[][] boardMatrix(String s) {
        row = Integer.parseInt(s.substring(0, s.indexOf("x")));
        column = Integer.parseInt(s.substring(s.indexOf("x") + 1, s.length()));
        char[][] board = new char[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    public void move(String player, int row, int column) {
        if (player.equals(Input.getPlayer1())) {
            board[row][column] = XorO =  'X';
            ++countOfPlayer1;
            player = Input.getPlayer2();
        } else {
            board[row][column] = XorO = 'O';
            ++countOfPlayer2;
            player = Input.getPlayer1();
        }
        print();
        System.out.println(Input.getPlayer1() + " : " + countOfPlayer1);
        System.out.println(Input.getPlayer2() + " : " + countOfPlayer2);

    }

    private void print() {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                System.out.print("|" + board[i][j] + "|");
            }
            System.out.println();
        }
    }

    boolean finish(char[][] checkBoard) {
        int counterOfRight = 1;
        int counterOfDown = 1;
        int counterOfDiogonal1 = 1;
        int counterOfDiogonal2 = 1;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column - 1; ++j) {
                if (checkBoard[i][j] == XorO && checkBoard[i][j + 1] ==XorO)
                    ++counterOfRight;
            }
        }

        for (int i = 0; i < row - 1; ++i) {
            for (int j = 0; j < column; ++j) {
                if (checkBoard[i][j] == XorO && checkBoard[i + 1][j] == XorO)
                    ++counterOfDown;
            }
        }

        for (int i = 0; i < row - 1; ++i) {
            for (int j = 0; j < column - 1; ++j) {
                if (checkBoard[i][j] == XorO && checkBoard[i + 1][j + 1] == XorO)
                    ++counterOfDiogonal1;
            }
        }

        for (int i = 0; i < row - 1; ++i) {
            for (int j = 1; j < column; ++j) {
                if (checkBoard[i][j] == XorO && checkBoard[i + 1][j - 1] == XorO)
                    ++counterOfDiogonal2;
            }
        }

        if (counterOfRight == Input.getCondition() ||
                counterOfDown == Input.getCondition() ||
                counterOfDiogonal1 == Input.getCondition() ||
                counterOfDiogonal2 == Input.getCondition())
            return true;
        else
            return false;
    }
}
