package P13_DefiningClasses.LAB.P03_BankAccount;

public class BankAccount {

    private static double interestRate = 0.02;
    private static int idCounter = 1;

    private int id;
    private double balance;


    public BankAccount() {
        this.id = idCounter;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return balance * interestRate * years;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }
}
