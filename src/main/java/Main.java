import Puzzle.Puzzle;
import Puzzle.PuzzleController;

public class Main {
    public static void main(String[] args){
        Puzzle puzzle = new Puzzle(3);
        Puzzle puzzle2 = new Puzzle(3);

        PuzzleController controller = new PuzzleController(puzzle);
        System.out.println("equals: "+controller.checkCorrectness());
        controller.shuffle(1000);
        System.out.println("equals: "+controller.checkCorrectness());
        controller.fillCorrectly();
        System.out.println("equals: "+controller.checkCorrectness());

    }
}
