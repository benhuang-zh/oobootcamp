package com.oobootcamp;

public interface Parkable {
    String parking(Car car) throws NoSpaceException;

    Car takeCar(String carNumber);

    boolean isAvailable();


    int availableSpace();

    int totalCar();
}
