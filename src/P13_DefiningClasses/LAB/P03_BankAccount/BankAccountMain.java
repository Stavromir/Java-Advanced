package P13_DefiningClasses.LAB.P03_BankAccount;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bank = new HashMap<>();

        while (!input.equals("End")) {

            String command = input.split("\\s+")[0];

            if (command.equals("Create")){

                BankAccount account = new BankAccount();
                int accountId = account.getId();
                bank.putIfAbsent(accountId, account);
                System.out.printf("Account ID%d created%n", accountId);

            } else if (command.equals("Deposit")) {
                int depositId = Integer.parseInt(input.split("\\s+")[1]);
                double amountToDeposit = Double.parseDouble(input.split("\\s+")[2]);

                if (bank.containsKey(depositId)) {
                    bank.get(depositId).setBalance(amountToDeposit);
                    System.out.printf("Deposited %.0f to ID%d%n", amountToDeposit, depositId);
                } else {
                    System.out.println("Account does not exist");
                }

            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(input.split("\\s+")[1]);
                BankAccount.setInterestRate(interest);
                
            } else {
                int depositId = Integer.parseInt(input.split("\\s+")[1]);
                int years = Integer.parseInt(input.split("\\s+")[2]);

                if (bank.containsKey(depositId)) {
                    double interest = bank.get(depositId).getInterest(years);
                    System.out.printf("%.2f%n", interest);
                } else {
                    System.out.println("Account does not exist");
                }
            }
            input = scanner.nextLine();
        }
    }
}
