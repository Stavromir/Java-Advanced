package P09_StreamsFilesDirectories.EXERCISE;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class P07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String inputPath1 = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/inputOne.txt";
        String inputPath2 = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/inputTwo.txt";
        String outputPath = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/output.txt";

        Scanner scanner = new Scanner(Files.newBufferedReader(Path.of(inputPath1)));
        BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath));

        while (scanner.hasNext()) {
            writer.write(scanner.next());
            writer.newLine();
        }
        scanner = new Scanner(Files.newBufferedReader(Path.of(inputPath2)));
        while (scanner.hasNext()) {
            writer.write(scanner.next());
            writer.newLine();
        }

        writer.close();
    }
}
