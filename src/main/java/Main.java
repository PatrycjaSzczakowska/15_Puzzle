import DAO.FilePuzzleDao;
import Solver.*;
import Structure.Puzzle;

public class Main {

    public static void main(String[] args) {
        try {
            FilePuzzleDao dao = new FilePuzzleDao("pliki/1.txt");
            Puzzle puzzle = dao.read();
            puzzle.print();

            //parametry
            SolverEnum solution = SolverEnum.DFS;
            ASolver solver;
            if (SolverEnum.ASTAR.equals(solution)) {
                //set heuristic
                HeuristicEnum heuristic = HeuristicEnum.HAMMING;

                solver = new ASTAR(puzzle, heuristic);
            } else {
                //set move order
                char[] moveOrder = {'R', 'L', 'U', 'D'};

                if (SolverEnum.BFS.equals(solution)) {
                    solver = new BFS(puzzle, moveOrder);
                } else {
                    solver = new DFS(puzzle, moveOrder);
                }
            }

            solver.run();
            System.out.print(solver.getSolutionToString());

        } catch (Exception e) {
            System.out.print(e.getStackTrace().toString());
        }


    }
}
