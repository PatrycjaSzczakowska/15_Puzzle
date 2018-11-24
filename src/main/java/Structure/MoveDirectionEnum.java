package Structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public enum MoveDirectionEnum {
    RIGHT('R'),
    LEFT('L'),
    DOWN('D'),
    UP('U');

    private char letter;

    MoveDirectionEnum(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public static MoveDirectionEnum getMoveDirectionByLetter(char letter){
        for (MoveDirectionEnum move: MoveDirectionEnum.values()) {
            if(move.getLetter()==letter){
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
        for(char c : movesOrder){
            moves.add(getMoveDirectionByLetter(c));
        }
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
