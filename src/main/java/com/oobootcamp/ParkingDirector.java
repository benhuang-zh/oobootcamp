package com.oobootcamp;

public class ParkingDirector {
    private ParkingManager parkingManager;

    public ParkingDirector(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    public String printReport() {
        return parkingManager.getReport();
    }
}
