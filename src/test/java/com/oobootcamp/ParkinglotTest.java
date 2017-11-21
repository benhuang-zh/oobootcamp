package com.oobootcamp;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParkinglotTest {

    @Test
    public void should_stop_a_car() {
        Parkable parkinglot = new Parkinglot();
        String carNumber = "1212";
        Car car = new Car(carNumber);
        try {
            Assert.assertEquals(carNumber, parkinglot.parking(car));
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_get_car_from_parkinglog_after_parking() {
        Parkable parkinglot = new Parkinglot();
        String carNumber = "1213";
        Car car = new Car(carNumber);
        try {
            parkinglot.parking(car);
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }
        Assert.assertSame(car, parkinglot.takeCar(carNumber));
    }

    @Test
    public void should_get_null_when_get_car_twice_from_parkinglot_after_parking() {
        Parkable parkinglot = new Parkinglot();
        String carNumber = "1213";
        Car car = new Car(carNumber);
        try {
            parkinglot.parking(car);
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }
        Assert.assertSame(car, parkinglot.takeCar(carNumber));
        Assert.assertNull(parkinglot.takeCar(carNumber));
    }

    @Test
    public void given_a_2_car_capacity_parkinglot_can_stop_2_cars() throws NoSpaceException {
        Parkable parkinglot = new Parkinglot(2);
        String carNumber1 = "1";
        Car car1 = new Car(carNumber1);
        String carNumber2 = "2";
        Car car2 = new Car(carNumber2);
        Assert.assertEquals(carNumber1, parkinglot.parking(car1));
        Assert.assertEquals(carNumber2, parkinglot.parking(car2));
    }

    @Test
    public void given_a_1_car_capacity_parkinglot_can_not_stop_2_cars() throws NoSpaceException {
        Parkable parkinglot = new Parkinglot(1);
        String carNumber1 = "1";
        Car car1 = new Car(carNumber1);
        String carNumber2 = "2";
        Car car2 = new Car(carNumber2);
        Assert.assertEquals(carNumber1, parkinglot.parking(car1));
        assertThatThrownBy(() -> parkinglot.parking(car2)).isInstanceOf(NoSpaceException.class);
    }

}