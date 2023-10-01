package BankAccount;

public class Account {
    private final int id;
    private static int counter=1;
    private double balance;
    private static double interestRate = 0.02;

    public Account() {
        this.id=counter;
        counter++;
    }
    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public void deposit(double amount) {
        this.balance +=amount;
    }
    public double getInterest(int years){
        return  interestRate*years*balance;
    }
    public int getId() {
        return id;
    }
}
