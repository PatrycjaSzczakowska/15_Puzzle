package Structure;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {
    private int[][] board;
    private Position emptyElementPosition;
    private int sideLength;

    public Puzzle(int sideLength) {
        this.sideLength = sideLength;
        this.board = new int[sideLength][sideLength];
    }

    public void fill(int [][] values) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = values[i][j];
                if(board[i][j]==0){
                    this.emptyElementPosition = new Position(i, j);
                }
            }
        }
    }



    public void fillCorrectly() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board.length * i + j + 1;
            }
        }
        board[board.length - 1][board[0].length - 1] = 0;
        this.emptyElementPosition = new Position(board.length - 1, board[0].length - 1);
    }

    public void shuffle(int numberOfIterations) {
        MoveDirectionEnum moveDirection;
        for (int i = 0; i < numberOfIterations; i++) {
            moveDirection = MoveDirectionEnum.getRandomMove();
            if (validateMove(moveDirection)) {
                move(moveDirection);
            }
        }
    }

    public void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void setEmptyElementPosition(Position position) {
        emptyElementPosition = position;
    }

    private void swap(int x1, int y1, int x2, int y2) {
        int tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;

        if (board[x1][y1] == 0) {
            emptyElementPosition.setX(x1);
            emptyElementPosition.setY(y1);
        } else if (board[x2][y2] == 0) {
            emptyElementPosition.setX(x2);
            emptyElementPosition.setY(y2);
        }
    }

    private void set(int x, int y, int value) {
        board[x][y] = value;
    }

    private boolean validateMove(MoveDirectionEnum moveDirection) {
        switch (moveDirection) {
            case UP:
                if (emptyElementPosition.getX() == 0) return false;
                else return true;
            case DOWN:
                if (emptyElementPosition.getX() == (sideLength - 1)) return false;
                else return true;
            case LEFT:
                if (emptyElementPosition.getY() == 0) return false;
                else return true;
            case RIGHT:
                if (emptyElementPosition.getY() == (sideLength - 1)) return false;
                else return true;
        }
        return true;
    }

    public void move(MoveDirectionEnum moveDirection) {

        swap(emptyElementPosition.getX(), emptyElementPosition.getY(),
                emptyElementPosition.getX() + moveDirection.getX(), emptyElementPosition.getY() + moveDirection.getY());

    }

    public List<MoveDirectionEnum> getPossibleMoves(List<MoveDirectionEnum> moves) {
        List<MoveDirectionEnum> possibleMoves = new ArrayList<>();
        for (MoveDirectionEnum move : moves) {
            if (validateMove(move)) {
                possibleMoves.add(move);
            }
        }
        return possibleMoves;
    }

    public boolean isGoalState() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!checkFieldCorrectness(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Puzzle getCopy() {
        Puzzle newPuzzle = new Puzzle(sideLength);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    Position emptyElementPositionTmp = new Position(i, j);
                    newPuzzle.setEmptyElementPosition(emptyElementPositionTmp);
                }
                newPuzzle.set(i, j, board[i][j]);
            }
        }

        return newPuzzle;
    }

    private boolean checkFieldCorrectness(int x, int y) {
        if (board[x][y] == x * sideLength + y + 1) {
            return true;
        } else if (y == sideLength - 1 && x == sideLength - 1 && board[x][y] == 0) {
            return true;
        }
        return false;
    }

    private int getManhattanDistanceForField(int x, int y) {
        //Returning distance for element '0'
        if(board[x][y] == 0){
            return Math.abs(board.length-x-1)+Math.abs(board[0].length-y-1);
        }


        int correctX=(board[x][y]-1)/sideLength;
        int correctY = (board[x][y]-1)%sideLength;


        if(correctY==-1){
            correctY=sideLength-1;
        }
        return Math.abs(correctX-x)+Math.abs(correctY-y);
    }

    public int getManhattanDistance() {
        int manhattanDistance=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                manhattanDistance+= getManhattanDistanceForField(i,j);

            }
        }
        return manhattanDistance;
    }

    public int getHammingDistance() {
        int hammingDistance = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!checkFieldCorrectness(i, j)&&board[i][j]!=0) {
                    hammingDistance++;
                }
            }
        }
        return hammingDistance;
    }

    public int[][] getBoard() {
        return board.clone();
    }

    public int getSideLength() {
        return sideLength;
    }
}
