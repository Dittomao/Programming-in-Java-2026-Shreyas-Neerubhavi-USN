package bank.customers;
public class Customers{
    int customerId;
    String customerName;
    long contactNumber;
    public Customers(int customerId, String customerName, long contactNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
    }
    public void display(){
        System.out.println("Cusotmer ID: "+customerId+" \nCustomer Name: "+customerName+" \nContact Number: "+contactNumber);
    }
}
