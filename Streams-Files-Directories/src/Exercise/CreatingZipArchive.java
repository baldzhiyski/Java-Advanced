package Exercise;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreatingZipArchive {
    public static void main(String[] args) {
        String input1 = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String input2 = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String input3 = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String output = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";

        List<String> paths = List.of(input1,input2,input3);

        try (FileOutputStream fileOutputStream = new FileOutputStream(output);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)){

            for (String path : paths) {
                File file = new File(path);
                FileInputStream fileInputStream = new FileInputStream(file);
                ZipEntry zipEntry = new ZipEntry(file.getName());


                zipOutputStream.putNextEntry(zipEntry);
                int read = fileInputStream.read();
                while (read!=-1){
                    zipOutputStream.write(read);
                    read=fileInputStream.read();
                }
                fileInputStream.close();
            }



        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
