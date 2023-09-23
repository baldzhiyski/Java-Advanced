import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt");

        int oneByte = inputStream.read();
        while (oneByte!=-1){
            char symbol = (char) oneByte;
            if(symbol==32) {
                outputStream.write(' ');
            }else if(symbol==10){
                outputStream.write('\n');
            }else {
               String word = String.valueOf(oneByte);
                for (int i = 0; i < word.length(); i++) {
                    outputStream.write(word.charAt(i));
                }
            }
            oneByte=inputStream.read();
        }
        outputStream.close();
    }
}
