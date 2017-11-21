package com.oobootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy implements Parkable {
    List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
    ParkingStrategy parkingStrategy;

    public ParkingBoy(ParkingStrategy parkingStrategy, Parkinglot... parkinglots) {
        this.parkingStrategy = parkingStrategy;
        this.parkinglots.addAll(Arrays.asList(parkinglots));
    }


    public String parking(Car car) throws NoSpaceException {
        return parkingStrategy.parking(parkinglots, car);
    }

    public Car takeCar(String carNumber) {
        for (Parkable parkinglot : parkinglots) {
            Car targetCar = parkinglot.takeCar(carNumber);
            if (targetCar != null) {
                return targetCar;
            }
        }

        return null;
    }

    @Override
    public boolean isAvailable() {
        for (Parkinglot parkinglot : parkinglots) {
            if (parkinglot.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int availableSpace() {
        return parkinglots.stream().map(Parkinglot::availableSpace).reduce(0, Integer::sum);
    }

    @Override
    public int totalCar() {
        return parkinglots.stream().map(Parkinglot::totalCar).reduce(0, Integer::sum);
    }
}
