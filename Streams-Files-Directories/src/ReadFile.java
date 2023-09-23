import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try (FileInputStream inputStream = new FileInputStream(path)) {
            int oneByte = inputStream.read();
            while (oneByte!=-1){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte=inputStream.read();
            }
        }catch (IOException e){
            System.out.println("File with path "+ path + "was not found!");
        }

    }
}