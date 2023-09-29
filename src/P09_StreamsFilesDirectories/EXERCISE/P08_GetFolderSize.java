package P09_StreamsFilesDirectories.EXERCISE;

import java.io.File;

public class P08_GetFolderSize {
    public static void main(String[] args) {

        String path = "src/P09_StreamsFilesDirectories/EXERCISE/Exercises-Resources/Exercises Resources";
        File file = new File(path);

        long size = 0L;

            File[] files = file.listFiles();
            if (files != null) {
                for (File current : files) {
                    size += current.length();
                }
            }

        System.out.printf("Folder size: %d%n", size);
    }
}
