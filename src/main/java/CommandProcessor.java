import DAO.DaoException;
import DAO.FilePuzzleDao;
import DAO.FileWriter;
import Solver.*;
import Structure.Puzzle;

public class CommandProcessor {
    public void processArgs(String[] args){
        SolverEnum solverStrategy = SolverEnum.valueOf(args[0].toUpperCase());
        String solverMode = args[1];
        String puzzleFilename = args[2];
        String solutionFilename = args[3];
        String solutionStatisticsFilename = args[4];


        FilePuzzleDao dao = new FilePuzzleDao(puzzleFilename);

        Puzzle puzzle = null;
        try {
            puzzle = dao.read();
        } catch (DaoException e) {
            e.printStackTrace();
        }

        ASolver solver = null;

        //Mode for dfs/bfs is lrud, rldu, ...
        if(solverStrategy == SolverEnum.ASTR){
            HeuristicEnum heuristicEnum = null;
            if(solverMode == "manh")
                heuristicEnum = HeuristicEnum.MANHATTAN;
            else if(solverMode == "hamm")
                heuristicEnum = HeuristicEnum.HAMMING;

            solver = new ASTAR(puzzle, heuristicEnum);

        }else{
            char[] moveOrder = solverMode.toUpperCase().toCharArray();

            if(solverStrategy == SolverEnum.BFS){
                solver = new BFS(puzzle,moveOrder);
            }else if(solverStrategy == SolverEnum.DFS){
                solver = new DFS(puzzle, moveOrder);
            }
        }

        solver.run();

        FileWriter.write(solutionFilename, solver.getMovesOfSolution());
        FileWriter.write(solutionStatisticsFilename, solver.getSolutionStatistics());

    }
}
