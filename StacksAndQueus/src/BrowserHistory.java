import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> historyOfPreviousUrls = new ArrayDeque<>();
        String navigation = scan.nextLine();
        String currentURL = "";
        while (!navigation.equals("Home")){
            if(navigation.equals("back")){
                if(!historyOfPreviousUrls.isEmpty()){
                    currentURL= historyOfPreviousUrls.pop();
                }else{
                    System.out.println("no previous URLs");
                    navigation = scan.nextLine();
                    continue;
                }
            }else{
                if(!currentURL.isEmpty()){
                    // We should check if we have an existing one from the stack
                    historyOfPreviousUrls.push(currentURL);
                }
                // If we do not have , we should create one
                currentURL=navigation;
            }
            System.out.println(currentURL);
            navigation=scan.nextLine();
        }
    }
}
