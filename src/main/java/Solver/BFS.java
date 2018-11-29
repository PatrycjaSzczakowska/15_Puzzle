package Solver;

import Structure.MoveDirectionEnum;
import Structure.Puzzle;

import java.util.*;

public class BFS extends ASolver {
    private List<MoveDirectionEnum> movesOrder;

    private State stateToSolve;
    private Queue<State> statesToVisit;
    private List<Puzzle> previousPuzzles;

    public BFS(Puzzle puzzle, char[] movesOrder) {
        this.movesOrder = MoveDirectionEnum.getAllMoves(movesOrder);
        this.stateToSolve = new State(puzzle, "");

        this.statesToVisit = new LinkedList<State>();
        this.previousPuzzles = new ArrayList<Puzzle>();

        this.maxDepth = 0;
        this.processedStatesNumber = 0;
        this.visitedStatesNumber = 0;
        this.movesOfSolution = new String();
    }

    public void run() {
        Long startTime = System.nanoTime();

        statesToVisit.add(stateToSolve);

        while (!statesToVisit.isEmpty()) {
            State currentState = statesToVisit.remove();
            previousPuzzles.add(currentState.getPuzzle());
            visitedStatesNumber++;
            if (currentState.isGoalState()) {
                time = (int) ((System.nanoTime() - startTime) / 1000000);
                movesOfSolution = currentState.getDoneMoves();
                maxDepth = currentState.getDepth();
                processedStatesNumber = visitedStatesNumber + statesToVisit.size();
                isSolved = true;
                return;
            }
            exploreState(currentState);
        }
        time = (int) ((System.nanoTime() - startTime) / 1000000);
        processedStatesNumber = visitedStatesNumber + statesToVisit.size();
    }

    private void exploreState(State currentState) {
        List<MoveDirectionEnum> possibleMoves = currentState.getPossibleMoves(movesOrder);
        Collections.sort(possibleMoves);
        for (MoveDirectionEnum move : possibleMoves) {
            final State state = currentState.copyState();
            state.setParentMove(move);
            state.setDepth(currentState.getDepth() + 1);
            state.move(move);
            if (!previousPuzzles.stream().anyMatch(i -> i.getBoard() == state.getPuzzle().getBoard())) {
                statesToVisit.add(state);
            }
        }
    }
}
