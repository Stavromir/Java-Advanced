package P09_StreamsFilesDirectories.EXERCISE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class P06_WordCount {
    public static void main(String[] args) throws IOException {

        String inputPath = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/words.txt";
        String searchPath = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/text.txt";
        String outputPath = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/results.txt";

        Scanner scanner = new Scanner(Files.newBufferedReader(Path.of(inputPath)));
        BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath));

        Set<String> words = new HashSet<>();
        Map<String, Integer> wordsOutput = new HashMap<>();

        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        for (String word : words) {
            scanner = new Scanner(Files.newBufferedReader(Path.of(searchPath)));
            int count = 0;

            while (scanner.hasNext()) {
                String currentWord = scanner.next();
                if (word.equals(currentWord)) {
                    count ++;
                }
            }
            wordsOutput.put(word, count);
        }

        wordsOutput.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> {
                    try {
                        writer.write(String.format("%s - %d%n",entry.getKey(), entry.getValue()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        writer.close();
    }
}
