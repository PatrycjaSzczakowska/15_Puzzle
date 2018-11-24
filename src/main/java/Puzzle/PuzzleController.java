package Puzzle;

import Puzzle.Puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PuzzleController {
    private Puzzle puzzle;
    private Puzzle correctPuzzle;

    public PuzzleController(Puzzle puzzle) {
        this.puzzle = puzzle;
        correctPuzzle = new Puzzle(puzzle.getSideLength());
    }

    public void shuffle(int numberOfIterations) {
        Random random = new Random();
        for (int i = 0; i < numberOfIterations; i++) {
            move(MoveDirectionEnum.getRandomMove());
        }
    }

    public boolean move(MoveDirectionEnum moveDirection) {
        if (!validateMove(moveDirection)) {
            return false;
        }

        int movableElementX = puzzle.getMovableElementPosition().getX();
        int movableElementY = puzzle.getMovableElementPosition().getY();
        int movedElementX = movableElementX + moveDirection.getX();
        int movedElementY = movableElementY + moveDirection.getY();

        int tmp = puzzle.getXYElement(movedElementX, movedElementY);
        puzzle.setXYElement(movedElementX, movedElementY, 0);
        puzzle.setXYElement(movableElementX, movableElementY, tmp);

        puzzle.setMovableElementPosition(movedElementX, movedElementY);

        return true;

    }

    public boolean validateMove(MoveDirectionEnum moveDirection) {
        switch (moveDirection) {
            case UP:
                if (puzzle.getMovableElementPosition().getX() == 0) return false;
                else return true;
            case DOWN:
                if (puzzle.getMovableElementPosition().getX() == puzzle.getSideLength() - 1) return false;
                else return true;
            case LEFT:
                if (puzzle.getMovableElementPosition().getY() == 0) return false;
                else return true;
            case RIGHT:
                if (puzzle.getMovableElementPosition().getY() == puzzle.getSideLength() - 1) return false;
                else return true;
        }
        return true;
    }

    public List<MoveDirectionEnum> getPossibleMoves() {
        List<MoveDirectionEnum> moves = new ArrayList<MoveDirectionEnum>();
        for (MoveDirectionEnum move : MoveDirectionEnum.getAllMoves()) {
            if (validateMove(move)) {
                moves.add(move);
            }
        }
        return moves;
    }

    public void fillCorrectly() {
        puzzle.fillCorrectly();
    }

    public boolean checkFieldCorrectness(int x, int y) {
        if (puzzle.getXYElement(x, y) == correctPuzzle.getXYElement(x, y)) {
            return true;
        }
        return false;
    }

    public boolean checkCorrectness() {
        return puzzle.equals(correctPuzzle);
    }
}
