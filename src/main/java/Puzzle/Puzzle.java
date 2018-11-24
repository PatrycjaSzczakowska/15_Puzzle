package Puzzle;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Arrays;

public class Puzzle {
    private int[][] board;
    private MovableElementPosition movableElementPosition;
    private int gameSize;
    private int sideLength;

    public Puzzle(int sideLength) {
        this.sideLength = sideLength;
        this.board = new int[sideLength][sideLength];
        this.gameSize = (int) (Math.pow(sideLength, 2) - 1);

        fillCorrectly();
    }

    public int getSideLength() {
        return sideLength;
    }

    public MovableElementPosition getMovableElementPosition() {
        return movableElementPosition;
    }

    public void setMovableElementPosition(MovableElementPosition movableElementPosition) {
        this.movableElementPosition = movableElementPosition;
    }

    public void setMovableElementPosition(int x, int y) {
        movableElementPosition.setX(x);
        movableElementPosition.setY(y);
    }

    public int getXYElement(int x, int y) {
        return board[x][y];
    }

    public boolean setXYElement(int x, int y, int value) {
        if (x > board[0].length || x < 0 ||
                y > board.length || y < 0 ||
                value < 0 || value > gameSize) {
            return false;
        }
        board[x][y] = value;
        return true;
    }

    protected void fillCorrectly() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board.length * i + j + 1;
            }
        }

        board[board.length - 1][board[0].length - 1] = 0;
        movableElementPosition = new MovableElementPosition(board.length - 1, board[0].length - 1);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Puzzle.Puzzle{");
        sb.append("board=\n").append(Arrays.deepToString(board));
        sb.append("\n}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Puzzle)) return false;

        Puzzle puzzle = (Puzzle) o;

        return new EqualsBuilder()
                .append(board, puzzle.board)
                .append(getMovableElementPosition(), puzzle.getMovableElementPosition())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(board)
                .append(getMovableElementPosition())
                .toHashCode();
    }

    public class MovableElementPosition {
        private int x;
        private int y;

        public MovableElementPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            MovableElementPosition that = (MovableElementPosition) o;

            return new EqualsBuilder()
                    .append(getX(), that.getX())
                    .append(getY(), that.getY())
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(getX())
                    .append(getY())
                    .toHashCode();
        }
    }
}
