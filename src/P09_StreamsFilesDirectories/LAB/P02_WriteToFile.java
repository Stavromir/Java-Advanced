package P09_StreamsFilesDirectories.LAB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class P02_WriteToFile {
    public static void main(String[] args) throws IOException {

        String dir = System.getProperty("user.dir");

        String path = dir + "/09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String newPath = dir + "/09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/02.WriteToFileOutput.txt";
        File file = new File(newPath);

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream(file);

        Set<Character> symbols = Set.of(',','.','!','?');

        int oneByte = inputStream.read();

        while (oneByte != -1) {

            char symbol = (char) (oneByte);

            if (!symbols.contains(symbol)) {
                outputStream.write(symbol);
            }
            oneByte = inputStream.read();
        }
    }
}
