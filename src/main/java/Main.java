import Puzzle.Puzzle;
import Puzzle.MoveDirectionEnum;

public class Main {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle(4);
        puzzle.fillCorrectly();

        puzzle.shuffle(10);
        puzzle.print();
        BFS bfs = new BFS(puzzle);
        bfs.run();
        System.out.print(bfs.getSolutionToString());

    }
}
