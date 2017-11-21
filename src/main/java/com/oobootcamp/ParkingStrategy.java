package com.oobootcamp;

import java.util.List;

public interface ParkingStrategy {
    String parking(List<Parkinglot> parkinglots, Car car) throws NoSpaceException;
}
