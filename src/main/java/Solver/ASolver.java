package Solver;

import java.text.DecimalFormat;

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
            stringBuilder.append("Wasn't solved");
        } else {
            stringBuilder.append("Moves: " + movesOfSolution + "\n");
            stringBuilder.append("Time in miliseconds " + time + "\n");
            stringBuilder.append("Visited states: " + visitedStatesNumber + "\n");
            stringBuilder.append("Max depth: " + maxDepth + "\n");
        }
        return stringBuilder.toString();
    }

    public String getSolutionStatistics(){
        StringBuilder builder = new StringBuilder();
        if(!isSolved){
            builder.append(-1);
        }else{
            builder.append(movesOfSolution.length());
            builder.append('\n');
            builder.append(visitedStatesNumber);
            builder.append('\n');
            builder.append(processedStatesNumber);
            builder.append('\n');
            builder.append(maxDepth);
            builder.append('\n');
            builder.append(Math.round((time/1000.0)*1000)/1000.00);
            builder.append('\n');
        }

        return builder.toString();
    }

    public String getMovesOfSolution() {
        return movesOfSolution;
    }
}
