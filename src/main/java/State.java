import Puzzle.Puzzle;
import Puzzle.MoveDirectionEnum;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class State {
    private MoveDirectionEnum parentMove;
    private int depth;
    private Puzzle puzzle;
    private String moves;

    public State(Puzzle puzzle, String moves) {
        this.puzzle = puzzle;
        this.moves = moves;
        this.depth=0;
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

    public List<MoveDirectionEnum> getPossibleMoves() {
        List<MoveDirectionEnum> moves = puzzle.getPossibleMoves();
        if (parentMove != null) {
            moves.remove(MoveDirectionEnum.getOppositeMove(parentMove));
        }
        return moves;
    }

    public void move(MoveDirectionEnum move) {
        puzzle.move(move);
        moves = moves + move.getLetter();
    }

}
