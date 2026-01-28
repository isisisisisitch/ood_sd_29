package ca.bytetube.ood._02_parkinglotsystem;

public class Vehicle {
    protected int spotSize;
    //protected String plateNums;

    public Vehicle(int spotSize) {
        this.spotSize = spotSize;
    }

    public int getSpotSize() {
        return spotSize;
    }

    public void setSpotSize(int spotSize) {
        this.spotSize = spotSize;
    }


}
