package com.oobootcamp;

import java.util.List;

public interface Parkable {
    String parking(Car car) throws NoSpaceException;

    Car takeCar(String carNumber);

    boolean isAvailable();


    int availableSpace();

    int totalCar();

    List<ReportData> getReportData(int level);
}
