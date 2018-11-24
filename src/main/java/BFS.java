import Puzzle.Puzzle;

import java.util.*;

import Puzzle.MoveDirectionEnum;

public class BFS {

    private Queue<State> statesToVisit;
    private List<Puzzle> previousPuzzles;
    private State stateToSolve;
    private int visitedStates;
    private int maxDepth;
    private int processedStates;
    private int time;
    private String movesOfSolution;

    public BFS(Puzzle puzzle) {
        this.stateToSolve = new State(puzzle, "");
        this.statesToVisit = new LinkedList<State>();
        this.maxDepth = 0;
        this.visitedStates = 0;
        this.processedStates = 0;
        this.previousPuzzles = new ArrayList<Puzzle>();
        this.movesOfSolution = new String();
    }

    public void run() {
        Long startTime = System.nanoTime();

        statesToVisit.add(stateToSolve);

        while (!statesToVisit.isEmpty()) {
            State currentState = statesToVisit.remove();
            previousPuzzles.add(currentState.getPuzzle());
            visitedStates++;
            if (currentState.isGoalState()) {
                time = (int) ((System.nanoTime() - startTime) / 1000000);
                movesOfSolution = currentState.getDoneMoves();
                maxDepth = currentState.getDepth();
                return;
            }
            exploreState(currentState);
        }
        time = (int) ((System.nanoTime() - startTime) / 1000000);
    }

    private void exploreState(State currentState) {
        List<MoveDirectionEnum> possibleMoves = currentState.getPossibleMoves();
        Collections.sort(possibleMoves);
        for (MoveDirectionEnum move : possibleMoves) {
            State state = currentState.copyState();
            state.setParentMove(move);
            state.setDepth(currentState.getDepth() + 1);
            state.move(move);
            if (!previousPuzzles.contains(state.getPuzzle())) {
                statesToVisit.add(state);
            }
        }
    }

    public String getSolutionToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Moves: " + movesOfSolution + "\n");
        stringBuilder.append("Time in miliseconds " + time + "\n");
        stringBuilder.append("Visited states: " + visitedStates + "\n");
        stringBuilder.append("Max depth: " + maxDepth + "\n");
        return stringBuilder.toString();
    }


}
