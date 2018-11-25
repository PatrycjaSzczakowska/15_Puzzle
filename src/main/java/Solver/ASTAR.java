package Solver;

import Structure.MoveDirectionEnum;
import Structure.Puzzle;

import java.util.*;

public class ASTAR extends ASolver {
    private List<MoveDirectionEnum> movesOrder;

    private StateA stateToSolve;
    private TreeSet<StateA> statesToVisit;
    private List<Puzzle> previousPuzzles;

    public ASTAR(Puzzle puzzle, HeuristicEnum heuristic) {
        this.movesOrder = MoveDirectionEnum.getAllMoves();

        this.stateToSolve = new StateA(puzzle, "",heuristic);

        this.statesToVisit = new TreeSet<StateA>(new Comparator<StateA>() {
            public int compare(StateA o1, StateA o2) {
                if(o1.getFunctionValue()==o2.getFunctionValue()){
                    return o1.getDoneMoves().compareTo(o2.getDoneMoves());
                }
                return o1.getFunctionValue() - o2.getFunctionValue();
            }
        });

        this.previousPuzzles = new ArrayList<Puzzle>();
        this.maxDepth = 0;
        this.visitedStatesNumber = 0;
        this.processedStatesNumber = 0;
        this.movesOfSolution = new String();
    }

    public void run() {
        Long startTime = System.nanoTime();

        statesToVisit.add(stateToSolve);

        while (!statesToVisit.isEmpty()) {
            StateA currentState = statesToVisit.first();
            visitedStatesNumber++;
            if (currentState.isGoalState()) {
                time = (int) ((System.nanoTime() - startTime) / 1000000);
                movesOfSolution = currentState.getDoneMoves();
                maxDepth = currentState.getDepth();
                isSolved=true;
                return;
            }
            statesToVisit.remove(currentState);
            previousPuzzles.add(currentState.getPuzzle());
            exploreState(currentState);
        }
        time = (int) ((System.nanoTime() - startTime) / 1000000);
    }

    private void exploreState(StateA currentState) {
        List<MoveDirectionEnum> possibleMoves = currentState.getPossibleMoves(movesOrder);
        Collections.sort(possibleMoves);
        for (MoveDirectionEnum move : possibleMoves) {
            StateA state = currentState.copyState();
            state.setParentMove(move);
            state.setDepth(currentState.getDepth() + 1);
            state.move(move);
            state.calculateFunctionValue();
            if (!previousPuzzles.contains(state.getPuzzle())) {
                statesToVisit.add(state);
            }
        }
    }
}
