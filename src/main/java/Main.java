import DAO.FilePuzzleDao;
import DAO.FileWriter;
import Solver.*;
import Structure.Puzzle;

public class Main {

    public static void main(String[] args) {
        try {
            FilePuzzleDao dao = new FilePuzzleDao("pliki/3.txt");
            Puzzle puzzle = dao.read();
            puzzle.print();

            //parametry
            SolverEnum solution = SolverEnum.ASTR;
            ASolver solver;
            if (SolverEnum.ASTR.equals(solution)) {
                //set heuristic
                HeuristicEnum heuristic = HeuristicEnum.MANHATTAN;
                solver = new ASTAR(puzzle, heuristic);
            } else {
                //set move order
                char[] moveOrder = {'U', 'R', 'L', 'D'};

                if (SolverEnum.BFS.equals(solution)) {
                    solver = new BFS(puzzle, moveOrder);
                } else {
                    solver = new DFS(puzzle, moveOrder);
                }
            }

            solver.run();


            System.out.print(solver.getSolutionToString());
            FileWriter.write("pliki/solution.txt", solver.getSolutionStatistics());


        } catch (Exception e) {
            System.out.print(e.getStackTrace().toString());
        }


    }
}
