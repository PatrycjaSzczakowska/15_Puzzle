package Solver;

public abstract class ASolver implements ISolver {
    protected int visitedStatesNumber;
    protected int maxDepth;
    protected int processedStatesNumber;
    protected int time;
    protected String movesOfSolution;
    protected boolean isSolved;

    public abstract void run();

    public String getSolutionToString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (!isSolved) {
            stringBuilder.append("Wasn't solved ");
        } else {
            stringBuilder.append("Moves: " + movesOfSolution + "\n");
            stringBuilder.append("Time in miliseconds " + time + "\n");
            stringBuilder.append("Visited states: " + visitedStatesNumber + "\n");
            stringBuilder.append("Max depth: " + maxDepth + "\n");
        }
        return stringBuilder.toString();
    }
}
