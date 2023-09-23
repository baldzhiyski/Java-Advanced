import java.io.*;


public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String inputPath="C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        BufferedReader in = new BufferedReader(new FileReader(inputPath));
        PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\user\\Downloads\\Java Advanced\\Streams-Files-Directories\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt"));

        String line = in.readLine();
        int counter = 1;
        while (line!=null){
            if(counter%3==0){
                out.println(line);
            }
            counter++;
            line=in.readLine();
        }
        out.close();
    }

}
