package Solver;

import Structure.Puzzle;

public class StateA extends State {
    private HeuristicEnum heuristic;
    private int functionValue;

    public StateA(Puzzle puzzle, String moves, HeuristicEnum heuristic) {
        super(puzzle, moves);
        this.heuristic = heuristic;
    }

    public StateA copyState() {
        return new StateA(getPuzzle().getCopy(), new String(getDoneMoves()), heuristic);
    }

    public void calculateFunctionValue() {
        if (HeuristicEnum.MANHATTAN.equals(heuristic)) {
            functionValue = getPuzzle().getManhattanDistance() + getDepth();

        } else if (HeuristicEnum.MANHATTANWITHLINEARCONFLICTS.equals(heuristic)) {
            functionValue = getPuzzle().getManhattanDistanceWithLinearConflicts() + getDepth();
        } else {
            functionValue = getPuzzle().getHammingDistance() + getDepth();
        }
    }

    public int getFunctionValue() {
        return this.functionValue;
    }


}
