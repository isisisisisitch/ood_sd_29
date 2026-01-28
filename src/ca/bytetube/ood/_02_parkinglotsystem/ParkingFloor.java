package ca.bytetube.ood._02_parkinglotsystem;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    //0 = available 1=occupied
    private int[] spots;
    private Map<Vehicle, int[]> vehicleMap;

    public ParkingFloor(int spotsCount) {
        spots = new int[spotsCount];
        vehicleMap = new HashMap<>();
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (vehicle == null) return false;
        int size = vehicle.getSpotSize();
        int l = 0, r = 0;
        while (r < spots.length) {
            if (spots[r] != 0) {
                l = r + 1;
            }
            if (r - l + 1 == size) {
                for (int k = l; k <= r; k++) {
                    spots[k] = 1;
                }
                vehicleMap.put(vehicle, new int[]{l, r});
                return true;
            }
            r++;
        }

        return false;
    }

    //release the parking spots occupied by the vehicle
    public void removeVehicle(Vehicle vehicle) {
        if (vehicle == null) throw new IllegalArgumentException("vehicle can not be null !");
        int[] startEnd = vehicleMap.get(vehicle);
        int start = startEnd[0];
        int end = startEnd[1];
        for (int k = start; k <= end; k++) {
            spots[k] = 0;
        }

        vehicleMap.remove(vehicle);
    }

    public int[] getVehicleSpots(Vehicle vehicle) {
        if (vehicle == null) throw new IllegalArgumentException("vehicle can not be null !");
        return vehicleMap.get(vehicle);
    }

}
