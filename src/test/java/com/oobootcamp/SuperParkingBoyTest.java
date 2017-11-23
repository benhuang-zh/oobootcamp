package com.oobootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;


public class SuperParkingBoyTest {
    Car car1;
    Car car2;
    Car car3;
    Car car4;
    Parkinglot parkingLot1;
    Parkinglot parkingLot2;
    ParkingBoy parkingBoy;

    @Before
    public void init() {
        car1 = new Car(1);
        car2 = new Car(2);
        car3 = new Car(3);
        car4 = new Car(4);
        parkingLot1 = new Parkinglot(2);
        parkingLot2 = new Parkinglot(1);

        parkingBoy = new ParkingBoy(new SuperParkingStrategy(), parkingLot1, parkingLot2);
    }

    @Test
    public void can_park_a_car_in_2nd_parking_lot_when_1st_is_space_rate_less_than_2nd_and_both_have1_space() throws NoSpaceException {
        parkingLot1.parking(car1);
        String ticket = parkingBoy.parking(car2);

        assertEquals(car2, parkingLot2.takeCar(ticket));
    }

    @Test
    public void can_park_a_car_in_1st_parking_lot_when_both_have_same_space_rate() throws NoSpaceException {
        String ticket = parkingBoy.parking(car1);

        assertEquals(car1, parkingLot1.takeCar(ticket));
    }

    @Test
    public void can_NOT_park_a_car_when_both_are_full() throws NoSpaceException {
        parkingLot1.parking(car1);
        parkingLot1.parking(car2);
        parkingLot2.parking(car3);

        assertThatThrownBy(() -> parkingBoy.parking(car4)).isInstanceOf(NoSpaceException.class);
    }
}
