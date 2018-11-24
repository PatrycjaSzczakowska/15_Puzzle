import Puzzle.Puzzle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Puzzle.MoveDirectionEnum;

public class BFS {

    private Queue<State> statesToVisit;
    private List<State> previousStates;
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
        this.previousStates = new ArrayList<State>();
        this.movesOfSolution = new String();
    }

    public void run() {
        Long startTime = System.nanoTime();

        statesToVisit.add(stateToSolve);

        while (!statesToVisit.isEmpty()) {
            State currentState = statesToVisit.remove();
            visitedStates++;
            if (currentState.isGoalState()) {
                movesOfSolution = currentState.getDoneMoves();
                maxDepth=currentState.getDepth();
                return;
            }
            exploreState(currentState);
        }
        time = (int) ((System.nanoTime() - startTime) / 1000000);
    }

    private void exploreState(State currentState) {
        for (MoveDirectionEnum move : currentState.getPossibleMoves()) {
            State state = currentState.copyState();
            state.setParentMove(move);
            state.setDepth(currentState.getDepth()+1);
            state.move(move);
            statesToVisit.add(state);
        }
    }

    public String getSolutionToString(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Moves: "+ movesOfSolution+"\n");
        stringBuilder.append("Time in miliseconds "+time+"\n");
        stringBuilder.append("Visited states: "+ visitedStates+ "\n");
        stringBuilder.append("Max depth: "+ maxDepth + "\n");
        return stringBuilder.toString();
    }


}
