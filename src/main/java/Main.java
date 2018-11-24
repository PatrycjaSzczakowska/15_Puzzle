import Puzzle.Puzzle;
import Puzzle.PuzzleController;
import Puzzle.MoveDirectionEnum;

public class Main {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle(3);

        PuzzleController controller = new PuzzleController(puzzle);
        controller.shuffle(1000);

        System.out.println(puzzle.toString());
        System.out.println("down: " + controller.validateMove(MoveDirectionEnum.DOWN));
        System.out.println("up: " + controller.validateMove(MoveDirectionEnum.UP));
        System.out.println("right: " + controller.validateMove(MoveDirectionEnum.RIGHT));
        System.out.println("left: " + controller.validateMove(MoveDirectionEnum.LEFT));

    }
}
