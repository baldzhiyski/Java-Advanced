package Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;

public class LineNumbers {
    public static void main(String[] args) {
        String input = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String output = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        int num = 1;

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(input));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(output))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                bufferedWriter.write(num + ". ");
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                num++;
                line = bufferedReader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
