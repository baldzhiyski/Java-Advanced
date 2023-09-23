import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCustomObject {
    static  class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;

        Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        Cube cube = new Cube("white", 15.7, 16.4, 12.5);

        FileOutputStream outputStream = new FileOutputStream("cube-data.ser");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(cube);

        objectOutputStream.close();
    }
}
