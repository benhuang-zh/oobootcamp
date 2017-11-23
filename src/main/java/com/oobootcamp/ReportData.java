package com.oobootcamp;

import java.util.ArrayList;
import java.util.List;

public class ReportData {
    private String parkableType;
    private Integer totalCars;
    private Integer availableSpaces;
    private List<ReportData> subReport = new ArrayList<>();


    public ReportData( String parkableType, Integer totalCars, Integer availableSpaces) {
        this.parkableType = parkableType;
        this.totalCars = totalCars;
        this.availableSpaces = availableSpaces;
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

    public List<ReportData> getSubReport() {
        return subReport;
    }
}
