package bank.loans;

public class Loans{
    int loanNumber;
    String loanType;
    double loanAmount;
    
    public Loans(int loanNumber, String loanType, double loanAmount) {
        this.loanNumber = loanNumber;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
    }

    public void display(){
        System.out.println("Loan Number: "+loanNumber+" \nLoan Type: "+loanType+" \nLoan Amount: "+loanAmount);
    }
}