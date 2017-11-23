package com.oobootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingManager {

    List<Parkable> parkables = new ArrayList<>();

    public ParkingManager(Parkable... parkable) {
        this.parkables.addAll(Arrays.asList(parkable));
    }

    public String parking(Car car) throws NoSpaceException {
        for (Parkable parkable : parkables) {
            if (parkable.isAvailable()) {
                return parkable.parking(car);
            }
        }
        throw new NoSpaceException();
    }

    public Car takeCar(String ticket) {
        for (Parkable parkable : parkables) {
            Car car = parkable.takeCar(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    public String getReport() {
        Integer totalParkedCars = parkables.stream().map(p -> (p.totalCar())).reduce(0, Integer::sum);
        Integer totalAvailableSpaces = parkables.stream().map(p -> (p.availableSpace())).reduce(0, Integer::sum);

        return formatReportString(totalParkedCars, totalAvailableSpaces);
    }

    private String formatReportString(Integer totalCars, Integer availableSpaces) {
        StringBuilder report = new StringBuilder(StringUtil.formatReportString(0, "M", totalCars, availableSpaces));
        for (Parkable p : parkables) {
            report.append(p.getReport(1));
        }
        return report.toString();
    }


}
