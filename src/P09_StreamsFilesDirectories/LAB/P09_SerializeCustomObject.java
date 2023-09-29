package P09_StreamsFilesDirectories.LAB;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P09_SerializeCustomObject {
    static class Cube implements Serializable {
        String color;
        double wide;
        double height;
        double depth;

        public Cube(String color, double wide, double height, double depth) {
            this.color = color;
            this.wide = wide;
            this.height = height;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cube cube = new Cube("black", 12.34,35.32,18.1223);

        String path = "09_Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/cube-data.sere";

        FileOutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(cube);
        objectOutputStream.close();


        FileInputStream inputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Cube cube2 = (Cube) objectInputStream.readObject();

        System.out.println(cube2.color);
        System.out.println(cube2.depth);
        System.out.println(cube2.height);
        System.out.println(cube2.wide);
    }
}
