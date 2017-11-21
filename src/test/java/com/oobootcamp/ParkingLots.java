package com.oobootcamp;


public class ParkingLots {
    public static Parkable getParkableWithOneCarParked() throws NoSpaceException {
        Parkable parkinglot2 = new Parkinglot(1);
        parkinglot2.parking(new Car("39543978"));
        return parkinglot2;
    }

    public static Parkable getParkBoyWithOneCarParked() throws NoSpaceException {
        Parkinglot parkinglot2 = new Parkinglot(1);
        parkinglot2.parking(new Car("39543978"));
        Parkable parkingBoy = new ParkingBoy(new ParkingBoyStrategy(), parkinglot2);
        return parkingBoy;
    }
}
