package Exercise;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File directory = new File(path);

        int sum = 0;
        if (directory.isDirectory()){
            File[] files = directory.listFiles();
            for (File file : files) {
                if(!file.isDirectory()){
                    sum+=file.length();
                }
            }
            System.out.println("Folder size: " +sum);
        }

    }
}
