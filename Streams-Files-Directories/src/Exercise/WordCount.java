package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String input1 = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String input2 ="C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        Map<String,Integer> counter = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(input1));
        BufferedReader reader2 = new BufferedReader(new FileReader(input2))){
            String line = reader.readLine();
            while (line!=null){
                String[] words = line.split(" ");
                for (String word : words) {
                    counter.putIfAbsent(word,0);
                }
                line=reader.readLine();
            }
            line=reader2.readLine();
            while (line!=null){
                for (String word : line.split(" ")) {
                    if(counter.containsKey(word)){
                        counter.put(word,counter.get(word)+1);
                    }
                }
                line=reader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        counter.entrySet().forEach(word-> System.out.printf("%s - %s\n",word.getKey(),word.getValue()));
    }
}
