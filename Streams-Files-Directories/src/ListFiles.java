import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File current : files) {
                if(!current.isDirectory()) {
                    System.out.printf("%s: [%s]\n", current.getName(), current.length());
                }
            }
        }
    }
}
