package com.oobootcamp;

import java.util.List;

public class SequenceStrategy implements ParkingStrategy {
    public String parking(List<Parkinglot> parkingLots, Car car) throws NoSpaceException {
        long partCnt = parkingLots.stream()
                .filter(Parkable::isAvailable)
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