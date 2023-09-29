package P09_StreamsFilesDirectories.LAB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04_ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String dir = System.getProperty("user.dir");
        String path = dir + "/09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String newPath = dir + "/09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/04.ExtractIntegersOutput.txt";


        Scanner scanner = new Scanner(new FileInputStream(path));
        PrintWriter printer = new PrintWriter(new FileOutputStream(newPath));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printer.println(scanner.next());
            }
                scanner.next();
        }
        printer.close();
    }
}
