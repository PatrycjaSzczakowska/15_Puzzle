package Structure;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {
    private int[][] board;
    private Position emptyElementPosition;
    private int gameSize;
    private int sideLength;

    public Puzzle(int sideLength) {
        this.sideLength = sideLength;
        this.board = new int[sideLength][sideLength];
        this.gameSize = (int) (Math.pow(sideLength, 2) - 1);
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

    public void setEmptyElementPosition(Position position) {
        emptyElementPosition = position;
    }

    public void swap(int x1, int y1, int x2, int y2) {
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

    public void set(int x, int y, int value) {
        board[x][y] = value;
    }

    public boolean validateMove(MoveDirectionEnum moveDirection) {
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
        switch (moveDirection) {
            case UP: {
                swap(emptyElementPosition.getX(), emptyElementPosition.getY(),
                        emptyElementPosition.getX() - 1, emptyElementPosition.getY());
                break;
            }
            case DOWN: {
                swap(emptyElementPosition.getX(), emptyElementPosition.getY(),
                        emptyElementPosition.getX() + 1, emptyElementPosition.getY());
                break;

            }
            case LEFT: {
                swap(emptyElementPosition.getX(), emptyElementPosition.getY(),
                        emptyElementPosition.getX(), emptyElementPosition.getY() - 1);
                break;
            }
            case RIGHT: {
                swap(emptyElementPosition.getX(), emptyElementPosition.getY(),
                        emptyElementPosition.getX(), emptyElementPosition.getY() + 1);
                break;
            }
        }
    }

    public List<MoveDirectionEnum> getPossibleMoves(List<MoveDirectionEnum> moves) {
        List<MoveDirectionEnum> possibleMoves= new ArrayList<MoveDirectionEnum>();
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
                if (board[i][j] != board.length * i + j + 1) {
                    if (!(i == sideLength - 1 && j == sideLength - 1)) {
                        return false;
                    }
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
}
