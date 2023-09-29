package P09_StreamsFilesDirectories.EXERCISE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class P04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String inputPath = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/input.txt";
        Path path = Path.of("src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/input.txt");
        String outputPath = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/output.txt";

        BufferedReader reader = Files.newBufferedReader(path);
        BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath));

        String line = reader.readLine();

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuationMarks = Set.of('!', ',', '.', '?');
        
        int vowelCount = 0;
        int marksCount = 0;
        int otherCount = 0;
        
        while (line != null) {
            for (char symbol : line.toCharArray()) {
                if (vowels.contains(symbol)) {
                    vowelCount++;
                } else if (punctuationMarks.contains(symbol)) {
                    marksCount++;
                } else if (symbol != ' ') {
                    otherCount++;
                }
            }
            line = reader.readLine();
        }
        writer.write(String.format("Vowels: %d%n", vowelCount));
        writer.write(String.format("Other symbols: %d%n", otherCount));
        writer.write(String.format("Punctuation: %d%n", marksCount));
        reader.close();
        writer.close();
    }
}
