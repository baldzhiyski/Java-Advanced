package Exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\serializableList.ser"));
       ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\serializableList.ser"));

        List<Double> serializableList = new ArrayList<>();
        serializableList.add(22.5);
        serializableList.add(78.45);
        serializableList.add(98.12);

        objectOutputStream.writeObject(serializableList);

        List<Double> newSerializableList = (List<Double>) objectInputStream.readObject();
        newSerializableList.forEach(System.out::println);
    }
}
