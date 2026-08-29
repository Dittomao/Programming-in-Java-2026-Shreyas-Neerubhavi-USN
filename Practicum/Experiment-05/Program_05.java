import java.util.Scanner;
interface SmartDevice {
    void turnOn();
    void turnOff();
}
class SmartFan implements SmartDevice {
    public void turnOn() {
        System.out.println("Smart Fan is turned ON");
    }  
    public void turnOff() {
        System.out.println("Smart Fan is turned OFF");
    }
}
class SmartLight implements SmartDevice {
    public void turnOn() {
        System.out.println("Smart Light is turned ON");
    }   
    public void turnOff() {
        System.out.println("Smart Light is turned OFF");
    }
}
class SmartAC implements SmartDevice {
    public void turnOn() {
        System.out.println("Smart AC is turned ON");
    }   
    public void turnOff() {
        System.out.println("Smart AC is turned OFF");
    }
}
class Program_05 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        SmartDevice device = null;
        
        System.out.println("Select a Smart Device to control: \n1. Smart Fan\n2. Smart Light\n3. Smart AC");
        int deviceChoice = sc.nextInt();
        
        switch(deviceChoice) {
            case 1: 
                device = new SmartFan();
                break;
            case 2: 
                device = new SmartLight();
                break;
            case 3: 
                device = new SmartAC();
                break;
            default: 
                System.out.println("Invalid Device Choice!");
                sc.close();
                return;
        }    
        System.out.println("Select an operation: \n1. Turn ON\n2. Turn OFF");
        int operationChoice = sc.nextInt();        
        if (operationChoice == 1) {
            device.turnOn();
        } else if (operationChoice == 2) {
            device.turnOff();
        } else {
            System.out.println("Invalid Operation Choice!");
        }       
        sc.close();
    }
}