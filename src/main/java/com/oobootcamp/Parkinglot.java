package com.oobootcamp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parkinglot implements Parkable {
    private int capacity = 1;
    private List<Car> cars = new ArrayList<Car>();

    public Parkinglot() {
    }

    public Parkinglot(int i) {
        this.capacity = i;
    }

    @Override
    public String parking(Car car) throws NoSpaceException {
        if (cars.size() < capacity && cars.add(car)) {
            return car.getNumber();
        }
        throw new NoSpaceException();
    }


    @Override
    public Car takeCar(String carNumber) {
        Car takeCar = null;
        for (Iterator<Car> iterator = cars.iterator(); iterator.hasNext(); ) {
            Car car = iterator.next();
            if (carNumber.equals(car.getNumber())) {
                takeCar = car;
                iterator.remove();
                break;
            }
        }
        return takeCar;
    }

    @Override
    public boolean isAvailable() {
        return availableSpace() > 0;
    }

    @Override
    public int availableSpace() {
        return capacity - cars.size();
    }

    @Override
    public int totalCar() {
        return cars.size();
    }

    public double emptyRate() {
        return availableSpace() / capacity;
    }

    @Override
    public ReportData getReportData() {
        return new ReportData("P", totalCar(), availableSpace());
    }
}
