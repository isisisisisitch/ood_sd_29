package ca.bytetube.ood._02_parkinglotsystem;

public class Main {
    public static void main(String[] args) {
        Driver driver1 = new Driver(1, new Car(1));
        Driver driver2 = new Driver(2, new Limo(2));
        Driver driver3 = new Driver(3, new SemiTruck(3));
        ParkingGarage garage = new ParkingGarage(2, 2);
        ParkingSystem system = new ParkingSystem(garage,10);
        System.out.println(system.parkVehicle(driver1));
        System.out.println(system.parkVehicle(driver2));
        System.out.println(system.parkVehicle(driver3));

        System.out.println(system.removeVehicle(driver1));
        System.out.println(system.removeVehicle(driver2));
        System.out.println(system.removeVehicle(driver3));



    }
}
