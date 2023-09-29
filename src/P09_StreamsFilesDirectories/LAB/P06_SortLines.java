package P09_StreamsFilesDirectories.LAB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class P06_SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");

        List<String> lines = Files.readAllLines(path).stream()
                .sorted()
                .collect(Collectors.toList());

        Path newPath = Paths.get("09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/06.SortLinesOutput.txt");

        Files.write(newPath, lines);
    }
}
