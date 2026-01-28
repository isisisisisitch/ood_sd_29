package ca.bytetube.ood._02_parkinglotsystem;

public class ParkingGarage {
    private ParkingFloor[] floors;

    public ParkingGarage(int floorCount, int spotsFloor) {
        this.floors = new ParkingFloor[floorCount];
        for (int i = 0; i < floorCount; i++) {
            floors[i] = new ParkingFloor(spotsFloor);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (vehicle == null) return false;
        for (ParkingFloor f : floors) {
            if (f.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        if (vehicle == null) return false;
        for (ParkingFloor f : floors) {
            if (f.getVehicleSpots(vehicle) != null) {
                f.removeVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

}
