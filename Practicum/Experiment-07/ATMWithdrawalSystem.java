import java.util.InputMismatchException;
import java.util.Scanner;
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Account {
    String accountHolderName;
    double accountBalance;
    public Account(String accountHolderName, double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }
    public void withdraw(double withdrawalAmount) throws InsufficientBalanceException {
        if (withdrawalAmount < 0) {
            throw new IllegalArgumentException("Error: Withdrawal amount cannot be negative."); 
        }
        if (withdrawalAmount == 0) {
            throw new IllegalArgumentException("Error: Withdrawal amount must be greater than zero.");
        }
        if (withdrawalAmount > accountBalance) {
            throw new InsufficientBalanceException("Error: Insufficient funds. Your available balance is ₹" + accountBalance);
        } 
        accountBalance -= withdrawalAmount;
        System.out.println("Withdrawal successful! Amount deducted: ₹" + withdrawalAmount);
    }
    public void displayDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: ₹" + accountBalance);
    }
}

public class ATMWithdrawalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account("Rahul", 15000.00); 
        account.displayDetails();
        
        System.out.println("\n--- Interactive ATM Withdrawal ---");
        System.out.print("Enter withdrawal amount: ₹");
        try {
            double amount = scanner.nextDouble(); 
            account.withdraw(amount);

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type. Please enter a valid numerical amount.");
            
        } catch (NullPointerException e) {
            System.out.println("Error: Account object is null. Cannot process transaction.");
            
        } finally {
            if (account != null) {
                System.out.println("Remaining Balance: ₹" + account.accountBalance);
            }
        }
        
        scanner.close();
    }
}