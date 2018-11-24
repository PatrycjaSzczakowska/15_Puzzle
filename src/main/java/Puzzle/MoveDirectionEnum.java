package Puzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public enum MoveDirectionEnum implements Comparator<MoveDirectionEnum> {
    LEFT('L',1),
    RIGHT('R',2),
    DOWN('D',3),
    UP('U',4);

    private char letter;
    private int order;

    MoveDirectionEnum(char letter, int order) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public int getOrder() {
        return order;
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

    public int compare(MoveDirectionEnum o1, MoveDirectionEnum o2) {
        if(o1.getOrder()<o2.getOrder()){
            return 1;
        }else{
            return 0;
        }
    }
}
