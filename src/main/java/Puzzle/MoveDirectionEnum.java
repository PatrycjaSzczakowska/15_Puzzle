package Puzzle;

import java.util.Random;

public enum MoveDirectionEnum {
    LEFT(0,-1),
    RIGHT(0,1),
    DOWN(1,0),
    UP(-1,0);

    private int x;
    private int y;

    MoveDirectionEnum(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static MoveDirectionEnum getRandomMove(){
        int pick=new Random().nextInt(MoveDirectionEnum.values().length);
        return MoveDirectionEnum.values()[pick];
    }
}
