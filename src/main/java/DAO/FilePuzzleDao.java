package DAO;

import Structure.Puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilePuzzleDao {
    private String fileName;

    public FilePuzzleDao(final String fileName) {
        this.fileName = fileName;
    }

    public Puzzle read() throws DaoException {

        int sideLength;

        Puzzle puzzle;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            sideLength = scanner.nextInt();

            int values[][] = new int[sideLength][sideLength];
            int i = 0;

            while (scanner.hasNextInt()) {
                values[(int) i / sideLength][i % sideLength] = scanner.nextInt();
                i++;
            }

            puzzle = new Puzzle(sideLength);
            puzzle.fill(values);
            scanner.close();

        } catch (FileNotFoundException e) {
            throw new DaoException("", e);
        }

        return puzzle;
    }

    public void write(Puzzle puzzle){
        File file = new File(fileName);
        try(PrintWriter writer = new PrintWriter(file)){
            writer.write(Integer.toString(puzzle.getSideLength()));
            writer.write('\n');
            for (int i = 0; i < puzzle.getSideLength(); i++) {
                for (int j = 0; j < puzzle.getSideLength(); j++) {
                    writer.write(Integer.toString(puzzle.getBoard()[i][j]));
                    writer.write(" ");
                }
                writer.write('\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
