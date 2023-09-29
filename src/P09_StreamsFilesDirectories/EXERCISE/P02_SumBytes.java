package P09_StreamsFilesDirectories.EXERCISE;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P02_SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/input.txt";

//        BufferedReader bf = Files.newBufferedReader(Paths.get(path));
        BufferedReader bf = Files.newBufferedReader(Path.of(path));

        String line = bf.readLine();

        int asciiSum = 0;
        while (line != null) {
            for (char c : line.toCharArray()) {
                asciiSum += c;
            }
            line = bf.readLine();
        }
        System.out.println(asciiSum);
    }
}
