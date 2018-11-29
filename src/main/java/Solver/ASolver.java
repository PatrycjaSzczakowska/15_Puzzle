package Solver;

public abstract class ASolver implements ISolver {
    protected int processedStatesNumber;
    protected int maxDepth;
    protected int visitedStatesNumber;
    protected int time;
    protected String movesOfSolution;
    protected boolean isSolved;

    public abstract void run();

    public String getSolutionStatistics() {
        StringBuilder builder = new StringBuilder();
        if (!isSolved) {
            builder.append(-1);
        } else {
            builder.append(movesOfSolution.length());
        }
        builder.append('\n');
        builder.append(visitedStatesNumber);
        builder.append('\n');
        builder.append(processedStatesNumber);
        builder.append('\n');
        builder.append(maxDepth);
        builder.append('\n');
        builder.append(Math.round((time / 1000.0) * 1000) / 1000.00);
        builder.append('\n');

        return builder.toString();
    }

    public String getMovesOfSolution() {
        return movesOfSolution;
    }

    public boolean isSolved() {
        return isSolved;
    }
}
