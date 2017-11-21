package com.oobootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class ParkingBoyTest {

    ParkingStrategy parkingStrategy;

    @Before
    public void setUp(){
        parkingStrategy = new ParkingBoyStrategy();
    }

    @Test
    public void given_a_parkingBoy_a_parking_lot_when_stop_1_car_then_can_park() throws NoSpaceException {
        Parkinglot parkinglot = new Parkinglot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingStrategy, parkinglot);
        String carNumber = "1212";
        Car car = new Car(carNumber);

        assertEquals(carNumber, parkingBoy.parking(car));
    }

    @Test
    public void given_a_parkingBoy_1_full_parking_lot_and_2nd_not_full_parkinglot_when_stop_1_car_then_can_park_to_2nd_parkinglot() throws NoSpaceException {
        Parkinglot parkinglot = new Parkinglot(0);
        Parkinglot parkinglot2 = new Parkinglot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingStrategy, parkinglot, parkinglot2);
        String carNumber = "1212";
        Car car = new Car(carNumber);

        assertEquals(carNumber, parkingBoy.parking(car));
        assertSame(car, parkinglot2.takeCar(carNumber));
    }

    @Test
    public void should_take_the_car_from_1st_paringlot_when_the_car_is_stopping_in_1st_parkinglot() {
        String carNumber = "1212";
        Car car = new Car(carNumber);
        Parkinglot parkinglot = new Parkinglot(1);
        try {
            parkinglot.parking(car);
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }
        ParkingBoy parkingBoy = new ParkingBoy(parkingStrategy, parkinglot, parkinglot);

        Car targetCar = parkingBoy.takeCar(carNumber);

        assertSame(car, targetCar);
    }

    @Test
    public void should_take_the_car_from_2nd_paringlot_when_the_car_is_stopping_in_2nd_parkinglot() {
        String carNumber = "1212";
        Car car = new Car(carNumber);
        Parkinglot parkinglot = new Parkinglot(1);
        Parkinglot parkinglot2 = new Parkinglot(1);
        try {
            parkinglot2.parking(car);
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }
        ParkingBoy parkingBoy = new ParkingBoy(parkingStrategy, parkinglot, parkinglot2);

        Car targetCar = parkingBoy.takeCar(carNumber);

        assertSame(car, targetCar);
    }

    @Test
    public void should_can_not_park_the_car_when_all_parkinglot_are_full() {
        String carNumber = "1212";
        Car car = new Car(carNumber);
        Parkinglot parkinglot = new Parkinglot(0);
        Parkinglot parkinglot2 = new Parkinglot(0);
        ParkingBoy parkingBoy = new ParkingBoy(parkingStrategy, parkinglot, parkinglot2);

        assertThatThrownBy(() -> parkingBoy.parking(car)).isInstanceOf(NoSpaceException.class);
    }


}