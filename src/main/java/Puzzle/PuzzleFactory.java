package Puzzle;

import Puzzle.Puzzle;

public class PuzzleFactory {
    public Puzzle createShuffledPuzzle(int sideLength){
        Puzzle puzzle = new Puzzle(sideLength);
        PuzzleController controller = new PuzzleController(puzzle);
        controller.shuffle(1000);
        return puzzle;
    }
}
