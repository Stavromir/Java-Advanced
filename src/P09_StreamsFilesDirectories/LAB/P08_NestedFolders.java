package P09_StreamsFilesDirectories.LAB;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class P08_NestedFolders {
    public static void main(String[] args) {

        String path = "09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";

        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();

        dirs.offer(root);
        int count = 0;

        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            count++;
            System.out.println(current.getName());
            File[] files = current.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        dirs.offer(file);
                    }
                }
            }
        }
        System.out.printf("%d folders", count);
    }
}
