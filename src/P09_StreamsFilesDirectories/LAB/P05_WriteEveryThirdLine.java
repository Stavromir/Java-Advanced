package P09_StreamsFilesDirectories.LAB;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class P05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir");
        String path = dir + "/09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String newPath = dir + "/09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/05.WriteEveryThirdLineOutput.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
//        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();

        int count = 1;

        List<String> lines = new ArrayList<>();

        while (line != null) {
            if (count % 3 == 0) {
                lines.add(line);
            }
            count++;
            line = reader.readLine();
        }

        Path pathObj = Paths.get(newPath);

        Files.write(pathObj, lines);
    }
}
