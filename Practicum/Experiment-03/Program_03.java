abstract class Vehicle{
    String vehicleNumber;
    String brand;
    Vehicle(String VehicleNumber,String brand){
        this.vehicleNumber=VehicleNumber;
        this.brand=brand;
    }
    abstract void startEngine();
    final void showVehicleIdentity(){
        System.out.println("This is a vehicle");
    }
} 
class Car extends Vehicle{
    Car(String vehicleNumber, String brand){
        super(vehicleNumber,brand);
    }
    void startEngine(){
        System.out.println("Car has started.");
    }
}
class Bike extends Vehicle{
    Bike(String vehicleNumber, String brand){
        super(vehicleNumber, brand);
    }
    void startEngine(){
        System.out.println("Bike has started.");
    }
}
class Program_03{
    public static void main(String args[]){
        Vehicle sc;
        sc=new Car("hello","mustang");
        sc.startEngine();
        sc.showVehicleIdentity();
        sc=new Bike("432134123", "Challenger");
        sc.startEngine();
        sc.showVehicleIdentity();

    }
}