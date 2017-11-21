package com.oobootcamp;

import java.util.List;

public class SuperParkingStrategy implements ParkingStrategy {

    public String parking(List<Parkinglot> parkinglots, Car car) throws NoSpaceException {
        long partCnt = parkinglots.stream()
                .filter(Parkable::isAvailable)
                .sorted((lot1, lot2) -> Double.compare(lot2.emptyRate(), lot1.emptyRate()))
                .limit(1)
                .peek(lot -> {
                    try {
                        lot.parking(car);
                    } catch (NoSpaceException e) {
                        e.printStackTrace();
                    }
                })
                .count();
        if (partCnt > 0) {
            return car.getNumber();
        }
        throw new NoSpaceException();
    }
}
