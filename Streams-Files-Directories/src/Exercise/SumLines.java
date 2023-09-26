package Exercise;

import java.io.*;

public class SumLines {
    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line = bufferedReader.readLine();
            while (line!=null){
                long sum = 0;
                for (char symbol : line.toCharArray()) {
                    sum+=symbol;
                }
                System.out.println(sum);
                line = bufferedReader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
