package Structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum MoveDirectionEnum {
    RIGHT('R', 0, 1),
    LEFT('L', 0, -1),
    DOWN('D', 1, 0),
    UP('U', -1, 0);

    private char letter;
    private int x;
    private int y;

    MoveDirectionEnum(char letter, int x, int y) {
        this.letter = letter;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getLetter() {
        return letter;
    }

    public static MoveDirectionEnum getMoveDirectionByLetter(char letter) {
        for (MoveDirectionEnum move : MoveDirectionEnum.values()) {
            if (move.getLetter() == letter) {
                return move;
            }
        }
        return null;
    }

    public static MoveDirectionEnum getRandomMove() {
        int pick = new Random().nextInt(MoveDirectionEnum.values().length);
        return MoveDirectionEnum.values()[pick];
    }

    public static List<MoveDirectionEnum> getAllMoves(char[] movesOrder) {
        List<MoveDirectionEnum> moves = new ArrayList<MoveDirectionEnum>(4);
        for (char c : movesOrder) {
            moves.add(getMoveDirectionByLetter(c));
        }
        return moves;
    }

    public static List<MoveDirectionEnum> getAllMoves() {
        return Arrays.asList(MoveDirectionEnum.values());
    }

    public static MoveDirectionEnum getOppositeMove(MoveDirectionEnum moveDirection) {
        switch (moveDirection) {
            case UP: {
                return MoveDirectionEnum.DOWN;
            }
            case DOWN: {
                return MoveDirectionEnum.UP;
            }
            case LEFT: {
                return MoveDirectionEnum.RIGHT;
            }
            case RIGHT: {
                return MoveDirectionEnum.LEFT;
            }
        }
        return null;
    }

}
