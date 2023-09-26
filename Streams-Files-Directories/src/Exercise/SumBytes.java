package Exercise;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            while (line!=null){
                for (char symbol : line.toCharArray()) {
                    sum+=symbol;
                }
                line=bufferedReader.readLine();
            }
            System.out.println(sum);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
