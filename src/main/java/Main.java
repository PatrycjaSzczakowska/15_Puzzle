import Structure.MoveDirectionEnum;
import Structure.Puzzle;
import Solver.DFS;

public class Main {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle(4);
        puzzle.fillCorrectly();

        puzzle.shuffle(12);

        puzzle.print();
        char [] moveOrder = {'R','L','U','D'};
        DFS dfs = new DFS(puzzle, moveOrder);
        dfs.run();
        System.out.print(dfs.getSolutionToString());

    }
}
