package com.oobootcamp;

import java.util.List;

public class ParkingBoyStrategy implements ParkingStrategy {

    public String parking(List<Parkinglot> parkinglots, Car car) throws NoSpaceException {
        for (Parkable parkinglot : parkinglots) {
            if (parkinglot.isAvailable()) {
                return parkinglot.parking(car);
            }
        }
        throw new NoSpaceException();
    }
}
