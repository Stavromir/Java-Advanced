package P09_StreamsFilesDirectories.EXERCISE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P03_AllCAPITALS {
    public static void main(String[] args) throws IOException {
        String inputPath = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/input.txt";
        String outputPath = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/output.txt";

        BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
        BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath));

        String line = reader.readLine();

        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();
            line = reader.readLine();
        }

        reader.close();
        writer.close();
    }
}
