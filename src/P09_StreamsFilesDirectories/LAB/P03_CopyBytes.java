package P09_StreamsFilesDirectories.LAB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03_CopyBytes {
    public static void main(String[] args) throws IOException {

        String dir = System.getProperty("user.dir");
        String path = dir + "/09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String newPath = dir + "/09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/03.CopyBytesOutput.txt";

        File file = new File(newPath);

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream(file);

        int oneByte = inputStream.read();

        while (oneByte != -1) {

            if (oneByte == 32) {
                outputStream.write(' ');
            } else if (oneByte == 13) {
                outputStream.write('\n');
            } else if (oneByte != 10) {

                String value = String.valueOf(oneByte);

                for (char c : value.toCharArray()) {
                    outputStream.write(c);
                }
            }
            oneByte = inputStream.read();
        }
    }
}
