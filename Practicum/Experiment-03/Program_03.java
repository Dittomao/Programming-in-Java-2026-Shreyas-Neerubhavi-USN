import java.util.Scanner;
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
        Scanner a=new Scanner(System.in);
        Vehicle sc;
        System.out.println("Enter the type of vehicle you have: (BIKE/CAR) ");
        String vehicle1=a.next();
        System.out.println("Enter the vehicle number ");
        String vehicle_num=a.next();
        a.close();
        if (vehicle1.equals("BIKE")){
            sc=new Bike(vehicle_num, vehicle1);
            sc.startEngine();
            sc.showVehicleIdentity();
        }
        else if(vehicle1.equals("CAR")){
            sc=new Car(vehicle_num, vehicle1);
            sc.startEngine();
            sc.showVehicleIdentity();
        }
        else{
            System.out.println("Invalid details");
        }

    }
}