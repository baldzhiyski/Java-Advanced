import java.io.*;

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
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("white", 15.7, 16.4, 12.5);

        FileOutputStream outputStream = new FileOutputStream("cube-data.ser");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(cube);

        objectOutputStream.close();

        // we can also read :

        FileInputStream inputStream = new FileInputStream("cube-data.ser");

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Cube cube2 = (Cube) objectInputStream.readObject();

        System.out.println(cube2.color);
    }
}
