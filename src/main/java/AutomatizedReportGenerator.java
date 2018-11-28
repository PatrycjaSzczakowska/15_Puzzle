import DAO.DaoException;
import DAO.FilePuzzleDao;
import Structure.Puzzle;

public class AutomatizedReportGenerator {
    public void generate() {
        Puzzle puzzle3x3 = new Puzzle(3);
        puzzle3x3.fillCorrectly();
        puzzle3x3.shuffle(50);
        String puzzle3x3Filename = "pliki/3x3.txt";
        FilePuzzleDao dao3 = new FilePuzzleDao(puzzle3x3Filename);
        dao3.write(puzzle3x3);

        runSample("astr", "hamm", puzzle3x3Filename);
        runSample("astr", "manh", puzzle3x3Filename);

        runSample("bfs", "rdul", puzzle3x3Filename);
        runSample("bfs", "rdlu", puzzle3x3Filename);
        runSample("bfs", "drul", puzzle3x3Filename);
        runSample("bfs", "drlu", puzzle3x3Filename);
        runSample("bfs", "ludr", puzzle3x3Filename);
        runSample("bfs", "lurd", puzzle3x3Filename);
        runSample("bfs", "uldr", puzzle3x3Filename);
        runSample("bfs", "ulrd", puzzle3x3Filename);

        runSample("dfs", "rdul", puzzle3x3Filename);
        runSample("dfs", "rdlu", puzzle3x3Filename);
        runSample("dfs", "drul", puzzle3x3Filename);
        runSample("dfs", "drlu", puzzle3x3Filename);
        runSample("dfs", "ludr", puzzle3x3Filename);
        runSample("dfs", "lurd", puzzle3x3Filename);
        runSample("dfs", "uldr", puzzle3x3Filename);
        runSample("dfs", "ulrd", puzzle3x3Filename);


        Puzzle puzzle4x4 = new Puzzle(4);
        puzzle4x4.fillCorrectly();
        puzzle4x4.shuffle(50);
        String puzzle4x4Filename = "pliki/4x4.txt";
        FilePuzzleDao dao4 = new FilePuzzleDao(puzzle4x4Filename);
        dao4.write(puzzle4x4);

        runSample("astr", "hamm", puzzle4x4Filename);
        runSample("astr", "manh", puzzle4x4Filename);

        runSample("bfs", "rdul", puzzle4x4Filename);
        runSample("bfs", "rdlu", puzzle4x4Filename);
        runSample("bfs", "drul", puzzle4x4Filename);
        runSample("bfs", "drlu", puzzle4x4Filename);
        runSample("bfs", "ludr", puzzle4x4Filename);
        runSample("bfs", "lurd", puzzle4x4Filename);
        runSample("bfs", "uldr", puzzle4x4Filename);
        runSample("bfs", "ulrd", puzzle4x4Filename);

        runSample("dfs", "rdul", puzzle4x4Filename);
        runSample("dfs", "rdlu", puzzle4x4Filename);
        runSample("dfs", "drul", puzzle4x4Filename);
        runSample("dfs", "drlu", puzzle4x4Filename);
        runSample("dfs", "ludr", puzzle4x4Filename);
        runSample("dfs", "lurd", puzzle4x4Filename);
        runSample("dfs", "uldr", puzzle4x4Filename);
        runSample("dfs", "ulrd", puzzle4x4Filename);

    }

    public void runSample(String solverStrategy, String solverMode, String puzzleFilename) {
        FilePuzzleDao dao = new FilePuzzleDao(puzzleFilename);
        Puzzle puzzle = null;
        try {
            puzzle = dao.read();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        String solutionFilename = "pliki/solution-" + puzzle.getSideLength() + "-" + solverStrategy + "-" + solverMode + ".txt";
        String solutionStatisticsFilename = "pliki/stats-" + puzzle.getSideLength() + "-" + solverStrategy + "-" + solverMode + ".txt";

        CommandProcessor commandProcessor = new CommandProcessor();
        commandProcessor.processArgs(new String[]{solverStrategy, solverMode, puzzleFilename, solutionFilename, solutionStatisticsFilename});
    }
}
