package Exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\Uni_St2.png";
        String outPut = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output-picture.png";


        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream writer = new FileOutputStream(outPut);

        int oneByte = inputStream.read();
        while (oneByte!=-1){
            writer.write(oneByte);
            oneByte=inputStream.read();
        }
        writer.close();
    }
}
