package com.oobootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


public class ParkingManagerTest {


    @Test
    public void can_park_a_car_in_parking_lot() throws NoSpaceException {


        Parkable parkinglot = new Parkinglot(1);
        ParkingManager parkingManager = new ParkingManager(parkinglot);
        String carNumber = "12312";
        String ticket = parkingManager.parking(new Car(carNumber));

        assertEquals(carNumber, ticket);
    }

    @Test
    public void can_park_a_car_by_parkingBoy() throws NoSpaceException {

        Parkinglot parkinglot1 = new Parkinglot(1);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingBoyStrategy(), parkinglot1);
        ParkingManager parkingManager = new ParkingManager(parkingBoy);

        String carNumber = "12312";
        Car car = new Car(carNumber);
        String ticket = parkingManager.parking(car);

        assertSame(car, parkingManager.takeCar(ticket));
    }

    @Test
    public void can_park_a_car_in_2nd_parking_lot_when_the_first_parking_is_full() throws NoSpaceException {

        Parkinglot parkinglot1 = new Parkinglot(0);
        Parkinglot parkinglot2 = new Parkinglot(1);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingBoyStrategy(), parkinglot2);
        ParkingManager parkingManager = new ParkingManager(parkinglot1, parkingBoy);
        String carNumber = "12312";
        Car car = new Car(carNumber);
        String ticket = parkingManager.parking(car);

        assertSame(car, parkingManager.takeCar(ticket));
    }


}
