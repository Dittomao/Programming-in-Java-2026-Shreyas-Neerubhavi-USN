package bank.accounts;

public class Accounts {
    long accountNumber;
    public Accounts(long accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }
    String accountType;
    double balance;
    public void deposit(double a){
        balance+=a;
        System.out.println("Your Updated Balance is: "+balance);
    }
    public void withdraw(double a){
        if(a>balance){
            System.out.println("Your balance is low!");
        }
        else{
            balance-=a;
        }
    }
    public void displayBalance(){
        System.out.println("Your current balance is: "+balance);
    }
}
