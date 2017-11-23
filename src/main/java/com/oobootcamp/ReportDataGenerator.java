package com.oobootcamp;

import java.util.List;

public class ReportDataGenerator {
    static ReportData genReportData(String parkableType, Integer totalParkedCars, Integer totalAvailableSpaces, List<? extends Parkable> parkables) {
        ReportData reportData = new ReportData(parkableType, totalParkedCars, totalAvailableSpaces);
        for (Parkable p : parkables) {
            reportData.getSubReport().add(p.getReportData());
        }
        return reportData;
    }
}
