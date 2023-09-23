import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;


public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path ="C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Set<Character> punctuations = Set.of(',','.','!','?');
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt");

        int oneByte = inputStream.read();
        while (oneByte!=-1){
            if(!punctuations.contains((char)oneByte)){
                outputStream.write(oneByte);
            }
            oneByte=inputStream.read();
        }
        outputStream.close();
    }
}
