package ca.bytetube.ood._02_parkinglotsystem;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
    private ParkingGarage garage;
    Map<Integer, Integer> timeParked;
    private int hourRate;

    public ParkingSystem(ParkingGarage garage, int hourRate) {
        this.garage = garage;
        this.hourRate = hourRate;
        timeParked = new HashMap<>();
    }

    public boolean parkVehicle(Driver driver) {
        if (driver == null) return false;
        int curHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        boolean isParked = garage.parkVehicle(driver.getVehicle());
        if (isParked) {
            timeParked.put(driver.getId(), curHour);
        }
        return isParked;
    }

    //calculate parking fee and release the spots
    public boolean removeVehicle(Driver driver) {
        if (!timeParked.containsKey(driver.getId())) return false;

        int end = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int start = timeParked.get(driver.getId());
        int duration = end - start;
        int amount = duration * hourRate;
        driver.charge(amount);

        return garage.removeVehicle(driver.getVehicle());
    }


}
