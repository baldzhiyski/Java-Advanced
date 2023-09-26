package Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) {
        Set<Character> vowels = Set.of('a','e','o','u','i');
        Set<Character> punctuations = Set.of('!','.',',','?');
        int vowelsCount = 0;
        int punctuationsCount = 0;
        int others = 0;

        String input = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String output = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        try(BufferedReader reader= new BufferedReader(new FileReader(input));
            BufferedWriter writer = Files.newBufferedWriter(Path.of(output))){

            String line = reader.readLine();
            while (line!=null){
                for (char symbol : line.toCharArray()) {
                    if(vowels.contains(symbol)){
                        vowelsCount++;
                    }else if(punctuations.contains(symbol)){
                        punctuationsCount++;
                    }else if(symbol!=' '){
                        others++;
                    }
                }
                line=reader.readLine();
            }
            writer.write(String.format("Vowels: %d\n",vowelsCount));
            writer.write(String.format("Other symbols: %d\n",others));
            writer.write(String.format("Punctuation: %d",punctuationsCount));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
