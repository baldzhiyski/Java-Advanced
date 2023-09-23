import java.io.*;;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
    String path = "C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    Scanner  scanner = new Scanner(new FileInputStream(path));
    PrintWriter printer = new PrintWriter(new FileOutputStream("C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt"));
        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                printer.println(scanner.next());
            }
            scanner.next();
        }
        printer.close();
    }
}
