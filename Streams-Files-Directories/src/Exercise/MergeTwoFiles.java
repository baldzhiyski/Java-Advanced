package Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String input1 = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String input2 = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String output = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        Map<String,Integer> counter = new LinkedHashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(input1));
             BufferedReader reader2 = Files.newBufferedReader(Path.of(input2));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(output))){

            String line = reader.readLine();
            while (line!=null){
                writer.write(line);
                writer.newLine();
                line=reader.readLine();
            }
            line=reader2.readLine();
            while (line!=null){
                writer.write(line);
                writer.newLine();
                line=reader2.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
