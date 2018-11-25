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

        int rows, columns;

        Puzzle puzzle = null;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            rows = scanner.nextInt();
            columns = scanner.nextInt();

            int values[][] = new int[rows][columns];
            int i = 0;

            while (scanner.hasNextInt()) {
                values[(int) i / rows][i % rows] = scanner.nextInt();
                i++;
            }

            puzzle = new Puzzle(rows);
            puzzle.fill(values);
            scanner.close();

        } catch (FileNotFoundException e) {
            throw new DaoException("", e);
        }

        return puzzle;
    }

//    public void write(final SudokuBoard obj) throws DaoException {
//        try {
//            File file = new File(fileName);
//
//            PrintWriter printWriter = new PrintWriter(file);
//
//            int tmp;
//
//            for (int i = 0; i < 81; i++) {
//                printWriter.print(obj.get((int) i / 9, i % 9));
//                if (i % 9 == 8) {
//                    printWriter.write("\r\n");
//                } else {
//                    printWriter.write(" ");
//                }
//            }
//            printWriter.write("\r\n");
//
//            for (int i = 0; i < 81; i++) {
//                printWriter.print(obj.getFieldPermanence((int) i / 9, i % 9));
//                if (i % 9 == 8) {
//                    printWriter.write("\r\n");
//                } else {
//                    printWriter.write(" ");
//                }
//            }
//
//
//            printWriter.close();
//
//        } catch (FileNotFoundException e) {
//            throw new DaoException("", e);
//        }
//    }
//
//    @Override
//    public void finalize() {
//    }
}
