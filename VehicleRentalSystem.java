import java.util.Scanner;
class Vehicle{
    protected double dailyRate;

    public Vehicle(double dailyRate){
        this.dailyRate = dailyRate;
    }

    public double calculateRentalCharge(int rentDays){
        return dailyRate * rentDays;
    }

    public String getVehicleType(){
        return "Vehicle";
    }
}

class Car extends Vehicle{
    public Car(){
        super(1500.00);
        }

    @Override 
    public String getVehicleType(){
        return "Car";
    }
}
class Bike extends Vehicle{
    public Bike(){
        super(600.0);
    }
    @Override 
    public String getVehicleType(){
        return "Bike";
    }
}
class Truck extends Vehicle{
    public Truck(){
        super(3000.0);
    }
    @Override 
    public String getVehicleType(){
        return "Truck";
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vehicleType = scanner.nextInt();
        int rentalDays = scanner.nextInt();

        Vehicle vehicle;
        if (vehicleType == 1) {
            vehicle = new Car();
        } else if (vehicleType == 2) {
            vehicle = new Bike();
        } else if (vehicleType == 3) {
            vehicle = new Truck();
        } else {
            System.out.println("Invlaid");
            scanner.close();
            return;
        }

        System.out.printf("Vehicle Type: %s%n", vehicle.getVehicleType());
        System.out.printf("Rental Charge: %.2f%n",vehicle.calculateRentalCharge(rentalDays));
        scanner.close();
    }
}
