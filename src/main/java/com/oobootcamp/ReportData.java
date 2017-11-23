package com.oobootcamp;

public class ReportData {
    private final int level;
    private final String parkableType;
    private final Integer totalCars;
    private final Integer availableSpaces;

    public ReportData(int level, String parkableType, Integer totalCars, Integer availableSpaces) {
        this.level = level;
        this.parkableType = parkableType;
        this.totalCars = totalCars;
        this.availableSpaces = availableSpaces;
    }

    public int getLevel() {
        return level;
    }

    public String getParkableType() {
        return parkableType;
    }

    public Integer getTotalCars() {
        return totalCars;
    }

    public Integer getAvailableSpaces() {
        return availableSpaces;
    }
}
