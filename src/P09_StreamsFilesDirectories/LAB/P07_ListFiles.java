package P09_StreamsFilesDirectories.LAB;

import java.io.File;

public class P07_ListFiles {
    public static void main(String[] args) {

        String path = "09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";

        File file = new File(path);

        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files != null) {
                for (File current : files) {
                    if (!current.isDirectory()) {
                        String fileName = current.getName();
                        Long fileSize = current.length();
                        System.out.printf("%s: [%d]%n", fileName, fileSize);
                    }
                }
            }
        }
    }
}
