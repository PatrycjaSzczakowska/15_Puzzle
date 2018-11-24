package Puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum MoveDirectionEnum {
    LEFT('L'),
    RIGHT('R'),
    DOWN('D'),
    UP('U');

    private char letter;

    MoveDirectionEnum(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public static MoveDirectionEnum getRandomMove() {
        int pick = new Random().nextInt(MoveDirectionEnum.values().length);
        return MoveDirectionEnum.values()[pick];
    }

    public static List<MoveDirectionEnum> getAllMoves() {
        List<MoveDirectionEnum> moves = new ArrayList<MoveDirectionEnum>();
        moves.add(LEFT);
        moves.add(RIGHT);
        moves.add(UP);
        moves.add(DOWN);
        return moves;
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
