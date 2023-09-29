package P09_StreamsFilesDirectories.EXERCISE;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P01_SumLines {
    public static void main(String[] args) throws IOException {
        String path = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/input.txt";

        BufferedReader bf = new BufferedReader(new FileReader(path));

        String line = bf.readLine();


        while (line != null) {
            int asciiSum = 0;
            for (char c : line.toCharArray()) {
                asciiSum += c;
            }

            System.out.println(asciiSum);
            line = bf.readLine();
        }
    }
}
