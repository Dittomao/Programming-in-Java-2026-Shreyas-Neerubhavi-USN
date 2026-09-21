import bank.accounts.Accounts;
import bank.customers.Customers;
import bank.loans.Loans;

public class Main {
    public static void main(String[] args) {
        Customers c=new Customers(123,"Shreyas",41212233);
        c.display();
        Loans b = new Loans(232, "Personal", 2300.00);
        b.display();
        Accounts a=new Accounts(23423423,"Savings",4000);
        a.displayBalance();
        a.deposit(2000);
        a.withdraw(1000);
        a.displayBalance();
    }
}
