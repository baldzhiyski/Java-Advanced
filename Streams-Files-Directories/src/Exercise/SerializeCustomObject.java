package Exercise;

import java.io.*;

public class SerializeCustomObject {
    static class Course implements Serializable {
        private  String name;
        private  int studentsCount;


        public Course(String name, int studentsCount) {
            this.name = name;
            this.studentsCount = studentsCount;
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course = new Course("Java-Advanced",1000);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\serializableObject.ser"));
        outputStream.writeObject(course);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\serializableObject.ser"));
        Course course1 = (Course) inputStream.readObject();
        System.out.println(course1.name + " -> " + course1.studentsCount);
    }
}
