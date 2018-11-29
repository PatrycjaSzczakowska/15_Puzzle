package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
    public static void write(String path, String solution) {
        File file = new File(path);

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(solution);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
