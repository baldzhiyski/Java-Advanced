package Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllCapitals {
    public static void main(String[] args) {
        String input = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String output = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(input));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(output))) {
            String line = bufferedReader.readLine();
            while (line!=null ){
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
                line=bufferedReader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
