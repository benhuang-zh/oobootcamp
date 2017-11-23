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

    public List<ReportData> getReportData() {
        Integer totalParkedCars = parkables.stream().map(p -> (p.totalCar())).reduce(0, Integer::sum);
        Integer totalAvailableSpaces = parkables.stream().map(p -> (p.availableSpace())).reduce(0, Integer::sum);

        List<ReportData> list = new ArrayList<>();
        ReportData managerReprotData = new ReportData(0, "M", totalParkedCars, totalAvailableSpaces);
        list.add(managerReprotData);
        for (Parkable p : parkables) {
            list.addAll(p.getReportData(1));
        }
        return list;
    }


}
