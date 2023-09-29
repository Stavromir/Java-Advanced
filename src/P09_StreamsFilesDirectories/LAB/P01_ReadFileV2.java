package P09_StreamsFilesDirectories.LAB;

import java.io.FileInputStream;
import java.io.IOException;

public class P01_ReadFileV2 {
    public static void main(String[] args) throws IOException {

        String path = "F:\\MEGA\\JAVA\\03_Advanced\\Intelij_Programs\\All_Advanced\\All_Advanced" +
                "\\09_Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        FileInputStream inputStream = new FileInputStream(path);

        int oneByte = inputStream.read();

        while (oneByte != -1) {
            System.out.print(Integer.toBinaryString(oneByte) + " ");
            oneByte = inputStream.read();
        }
    }
}
