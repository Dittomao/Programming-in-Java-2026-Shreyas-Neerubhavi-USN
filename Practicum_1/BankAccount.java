import java.util.Scanner;

class BankAccount {
    String accountHolderName;
    long accountNumber;
    String accountType;
    double accountBalance;

    BankAccount(String name, long accNo, String type, double balance) {
        this.accountHolderName = name;
        this.accountNumber = accNo;
        this.accountType = type;
        this.accountBalance = balance;
    }

    void display() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: " + accountBalance); 
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount to deposit.");
        } else {
            accountBalance = accountBalance + amount;
            System.out.println("Amount Deposited: " + amount);
        }
    }

    void withdrawn(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else if (amount <= accountBalance) {
            accountBalance = accountBalance - amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    void balanceEnquiry() {
        System.out.println("Account Balance is as follows: " + accountBalance);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter an account Number: ");
        long acc = sc.nextLong(); 
        System.out.println("Account type needed: (Savings/Current)");
        String acctype = sc.next();
        
        BankAccount bank = new BankAccount(name, acc, acctype, 0);
        System.out.println("Account Successfully opened! You can now use your account.");
        bank.display();
        
        int n = 0; 
        
        do {
            System.out.println("\nChoose any of the banking options: ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Balance");
            System.out.println("3. Withdraw Balance");
            System.out.println("4. To quit");
            
            n = sc.nextInt(); 
            switch(n) { 
                case 1: 
                    bank.balanceEnquiry();
                    break; 
                    
                case 2:
                    System.out.println("Enter deposit amount: ");
                    double depAmount = sc.nextDouble(); 
                    bank.deposit(depAmount);
                    break;
                    
                case 3:
                    System.out.println("Enter withdrawal amount: ");
                    double withAmount = sc.nextDouble(); 
                    bank.withdrawn(withAmount);
                    break;
                    
                case 4: 
                    System.out.println("Quitting...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (n != 4);
        
        sc.close(); 
    }
}
