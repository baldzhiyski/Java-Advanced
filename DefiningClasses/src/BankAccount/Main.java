package BankAccount;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        Map<Integer,Account> accountMap = new LinkedHashMap<>();
        while (!command.equals("End")){
            String[] arr = command.split("\\s+");
            String first = arr[0];
            if(first.equals("Create")){
                create(accountMap);
            }else if(first.equals("Deposit")){
                int iD = Integer.parseInt(arr[1]);
                int balanceToDeposit = Integer.parseInt(arr[2]);
                deposit(accountMap,iD,balanceToDeposit);
            }else if(first.equals("SetInterest")){
                setInterest(Double.parseDouble(arr[1]));
            }else{
                getInterest(arr,accountMap);
            }

            command=scan.nextLine();
        }
    }

    private static void getInterest(String[] arr, Map<Integer, Account> accountMap) {
        int id = Integer.parseInt(arr[1]);
        int years = Integer.parseInt(arr[2]);
        if(checkMethod(accountMap,id)){
            double interest = accountMap.get(id).getInterest(years);
            System.out.printf("%.2f\n",interest);
        }else{
            System.out.println("Account does not exist");
        }
    }

    private static void setInterest(double parseDouble) {
        Account.setInterestRate(parseDouble);
    }

    private static void deposit(Map<Integer, Account> accountMap, int iD, int balanceToDeposit) {
        if(!checkMethod(accountMap,iD)){
            System.out.println("Account does not exist");
            return;
        }
        accountMap.get(iD).deposit(balanceToDeposit);
        System.out.printf("Deposited %d to ID%d\n",balanceToDeposit,iD);
    }

    private static void create(Map<Integer, Account> accountMap) {
        Account account = new Account();
        accountMap.put(account.getId(),account);
        System.out.printf("Account ID%d created\n",account.getId());
    }
    private static boolean checkMethod(Map<Integer,Account> accountMap, int id){
        return accountMap.containsKey(id);
    }
}
