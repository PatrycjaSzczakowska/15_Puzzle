package Solver;

import Structure.Puzzle;
import Structure.MoveDirectionEnum;

import java.util.List;

public class State {
    private MoveDirectionEnum parentMove;
    private int depth;
    private Puzzle puzzle;
    private String moves;

    public State(Puzzle puzzle, String moves) {
        this.puzzle = puzzle;
        this.moves = moves;
        this.depth = 0;
    }

    public boolean isGoalState() {
        return puzzle.isGoalState();
    }

    public State copyState() {
        return new State(puzzle.getCopy(), new String(moves));
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getDoneMoves() {
        return moves;
    }

    public void setParentMove(MoveDirectionEnum parentMove) {
        this.parentMove = parentMove;
    }

    public List<MoveDirectionEnum> getPossibleMoves(List<MoveDirectionEnum> movesOrder) {
        List<MoveDirectionEnum> moves = puzzle.getPossibleMoves(movesOrder);
        if (parentMove != null) {
            moves.remove(MoveDirectionEnum.getOppositeMove(parentMove));
        }
        return moves;
    }

    public void move(MoveDirectionEnum move) {
        puzzle.move(move);
        moves = moves + move.getLetter();
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }
}
