package com.oobootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class SmartParkingBoyTest {

    ParkingStrategy smartParkingBoyStrategy;

    @Before
    public void setUp() {
        smartParkingBoyStrategy = new SmartParkingBoyStrategy();
    }

    @Test
    public void should_part_car_in_1st_parkinglot_when_1st_parkinglot_has_1_slot_and_2nd_parkinglot_has_1_slot() throws NoSpaceException {
        String carNumber = "1212";
        Car car = new Car(carNumber);
        Parkinglot parkinglot = new Parkinglot(1);
        Parkinglot parkinglot2 = new Parkinglot(1);

        ParkingBoy parkingBoy = new ParkingBoy(smartParkingBoyStrategy, parkinglot, parkinglot2);

        assertEquals(carNumber, parkingBoy.parking(car));
        assertSame(car, parkinglot.takeCar(carNumber));
    }

    @Test
    public void should_part_car_in_2nd_parkinglot_when_1st_parkinglot_has_1_slot_and_2nd_parkinglot_has_2_slot() throws NoSpaceException {
        String carNumber = "1212";
        Car car = new Car(carNumber);
        Parkinglot parkinglot = new Parkinglot(1);
        Parkinglot parkinglot2 = new Parkinglot(2);
        ParkingBoy parkingBoy = new ParkingBoy(smartParkingBoyStrategy, parkinglot, parkinglot2);

        assertEquals(carNumber, parkingBoy.parking(car));
        assertSame(car, parkinglot2.takeCar(carNumber));

    }

    @Test
    public void should_return_false_when_parkinglot_are_full(){
        Parkinglot parkinglot = new Parkinglot(1);
        try {
            parkinglot.parking(new Car("1"));
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }
        Parkinglot parkinglot2 = new Parkinglot(1);
        try {
            parkinglot2.parking(new Car("2"));
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }
        ParkingBoy parkingBoy = new ParkingBoy(smartParkingBoyStrategy, parkinglot, parkinglot2);

        assertThatThrownBy(() -> parkingBoy.parking(new Car("3"))).isInstanceOf(NoSpaceException.class);
    }

}