import java.util.Scanner;

class Payment {
    void makePayment(double amount) {
        System.out.println("Processing generic payment of Rs " + amount);
    }
    void makePayment(double amount, String transactionId) {
        System.out.println("Rs " + amount + " paid successfully. (Transaction ID: " + transactionId + ")");
    }
}
class CreditCardPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Rs " + amount + " paid through Credit Card");
    }
}
class UPIPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Rs " + amount + " paid through UPI");
    }
}
class NetBankingPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Rs " + amount + " paid through Net Banking");
    }
}
class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Payment tip = null; 
        System.out.println("Enter the amount to be paid:");
        double amount = sc.nextDouble();      
        System.out.println("How do you want to pay? \n1. Credit Card\n2. UPI\n3. Net Banking");
        int choice = sc.nextInt();   
        switch (choice) {
            case 1: 
                tip = new CreditCardPayment();
                break;
            case 2: 
                tip = new UPIPayment();
                break;
            case 3: 
                tip = new NetBankingPayment();
                break;
            default: 
                System.out.println("Invalid Choice!");
                sc.close();
                return;
        }  
        System.out.println("Do you want to provide a transaction ID? (1 for Yes, 2 for No)");
        int idChoice = sc.nextInt();
        if (idChoice == 1) {
            System.out.println("Enter Transaction ID:");
            String txnId = sc.next();
            tip.makePayment(amount, txnId);
        } 
        else {
            tip.makePayment(amount);
        }     
        sc.close();
    }
}