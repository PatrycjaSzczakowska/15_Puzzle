public class Main {

    public static void main(String[] args) {

        AutomatizedReportGenerator reportGenerator = new AutomatizedReportGenerator();
        reportGenerator.generate();

//        Puzzle testPuzzle = new Puzzle(4);
//        testPuzzle.fillCorrectly();
//        testPuzzle.shuffle(100);
//        FilePuzzleDao puzzleDao = new FilePuzzleDao("pliki/test.txt");
//        puzzleDao.write(testPuzzle);
//
//        String[] cmdArgs = new String[5];
//        cmdArgs[0]="astr";
//        cmdArgs[1]="hamm";
//        cmdArgs[2]="pliki/test.txt";
//        cmdArgs[3]="pliki/solution.txt";
//        cmdArgs[4]="pliki/stats.txt";
//
//
//
//        CmdMain cmdMain = new CmdMain();
//        cmdMain.main(cmdArgs);


//        try {
//            FilePuzzleDao dao = new FilePuzzleDao("pliki/3.txt");
//            Puzzle puzzle = dao.read();
//            puzzle.print();
//
//            //parametry
//            SolverEnum solution = SolverEnum.ASTR;
//            ASolver solver;
//            if (SolverEnum.ASTR.equals(solution)) {
//                //set heuristic
//                HeuristicEnum heuristic = HeuristicEnum.MANHATTAN;
//                solver = new ASTAR(puzzle, heuristic);
//            } else {
//                //set move order
//                char[] moveOrder = {'U', 'R', 'L', 'D'};
//
//                if (SolverEnum.BFS.equals(solution)) {
//                    solver = new BFS(puzzle, moveOrder);
//                } else {
//                    solver = new DFS(puzzle, moveOrder);
//                }
//            }
//
//            solver.generate();
//
//
//            System.out.print(solver.getSolutionToString());
//            FileWriter.write("pliki/solution.txt", solver.getSolutionStatistics());
//
//
//        } catch (Exception e) {
//            System.out.print(e.getStackTrace().toString());
//        }


    }
}
