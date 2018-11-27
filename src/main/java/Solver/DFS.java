package Solver;

import Structure.MoveDirectionEnum;
import Structure.Puzzle;

import java.util.ArrayList;
import java.util.List;

public class DFS extends ASolver {
    private int givenDepthValue = 24;
    private List<MoveDirectionEnum> movesOrder;

//    private Stack<State> statesStack;
//    private List<State> visitedStates;
    private State stateToSolve;

    public DFS(Puzzle puzzle, char[] movesOrder) {
        this.movesOrder = MoveDirectionEnum.getAllMoves(movesOrder);
        this.stateToSolve = new State(puzzle, "");

//        this.visitedStates = new ArrayList<State>();

        this.processedStatesNumber = 0;
        this.maxDepth = 0;
        this.visitedStatesNumber = 0;
        this.movesOfSolution = new String();
    }

    public void run() {
        Long startTime = System.nanoTime();
        isSolved = DFS(stateToSolve);
        time = (int) ((System.nanoTime() - startTime) / 1000000);

    }

    private boolean DFS(State currentState) {
        visitedStatesNumber++;
        boolean tmp;
        if (currentState.isGoalState()) {
            maxDepth = currentState.getDepth();
            movesOfSolution = currentState.getDoneMoves();
            return true;
        } else if (currentState.getDepth() == givenDepthValue) {
            return false;
        }
        for (State state : getStateChildren(currentState)) {
            tmp = DFS(state);
            if (tmp) {
                return true;
            }
        }
        return false;
    }

    private List<State> getStateChildren(State currentState) {
        List<State> stateChildren = new ArrayList<State>();
        List<MoveDirectionEnum> possibleMoves = currentState.getPossibleMoves(movesOrder);
        for (MoveDirectionEnum move : possibleMoves) {
            processedStatesNumber++;
            State state = currentState.copyState();
            state.setParentMove(move);
            state.setDepth(currentState.getDepth() + 1);
            state.move(move);
            //if (!previousPuzzles.contains(state.getPuzzle())) {
            //    statesToVisit.add(state);
            //}
            stateChildren.add(state);
        }
        return stateChildren;
    }
}
