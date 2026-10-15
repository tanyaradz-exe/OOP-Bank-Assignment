import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-001", 1000.00, 100.00));
        accounts.add(new SavingsAccount("SAV-002", 150.00, 100.00));   // will hit the minimum
        accounts.add(new CurrentAccount("CUR-001", 200.00, 500.00));   // will go into overdraft
        accounts.add(new CurrentAccount("CUR-002", 50.00, 500.00));    // will exceed overdraft

        // One withdrawal amount per account, same order as the list
        double[] withdrawals = {300.00, 100.00, 600.00, 700.00};

        System.out.println("=== Opening balances ===");
        for (Account a : accounts) {
            System.out.printf("  [%s] %.2f%n", a.getAccountNumber(), a.getBalance());
        }

        System.out.println("\n=== Withdrawals (called via Account reference) ===");
        for (int i = 0; i < accounts.size(); i++) {
            accounts.get(i).withdraw(withdrawals[i]);
        }

        System.out.println("\n=== End of month (called via Account reference) ===");
        for (Account a : accounts) {
            a.endOfMonth();
        }

        System.out.println("\n=== Final balances ===");
        for (Account a : accounts) {
            System.out.printf("  [%s] %.2f%n", a.getAccountNumber(), a.getBalance());
        }
    }
}
