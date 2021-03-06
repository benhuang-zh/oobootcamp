package com.oobootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ParkingDirectorTest {


    @Test
    public void can_report_parked_cars_from_parking_manager_when_parking_manager_manages_one_parking_lot_and_one_car_parked() throws NoSpaceException {
        ParkingDirector parkingDirector = new ParkingDirector(new ParkingManager(ParkingLots.getParkableWithOneCarParked()));

        String report = parkingDirector.printReport();

        String expectedReport = "M 1 0\n" +
                " P 1 0";
        assertEquals(expectedReport, report);
    }

    @Test
    public void can_report_parked_cars_from_parking_manager_when_parking_manager_manages_one_parking_lot_wiht_3_capacity_and_one_car_parked() throws NoSpaceException {
        String carNumber = "12312";
        Parkable parkinglot = new Parkinglot(3);
        parkinglot.parking(new Car(carNumber));
        ParkingManager parkingManager = new ParkingManager(parkinglot);
        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);
        String report = parkingDirector.printReport();
        String expectedReport = "M 1 2\n" +
                " P 1 2";

        assertEquals(expectedReport, report);
    }

    @Test
    public void can_report_parked_cars_from_parking_manager_when_parking_manager_manages_one_parking_boy_and_one_car_parked() throws NoSpaceException {
        ParkingDirector parkingDirector = new ParkingDirector(new ParkingManager(ParkingLots.getParkBoyWithOneCarParked()));

        String report = parkingDirector.printReport();

        String expectedReport = "M 1 0\n" +
                " S 1 0\n" +
                "  P 1 0";
        assertEquals(expectedReport, report);
    }


    @Test
    public void can_report_parked_cars_from_parking_manager_when_parking_manager_manages_two_parking_lots_and_two_cars_parked() throws NoSpaceException {
        ParkingDirector parkingDirector = new ParkingDirector(new ParkingManager(ParkingLots.getParkableWithOneCarParked(), ParkingLots.getParkableWithOneCarParked()));

        String report = parkingDirector.printReport();

        String expectedReport = "M 2 0\n" +
                " P 1 0\n" +
                " P 1 0";
        assertEquals(expectedReport, report);
    }


    @Test
    public void should_report_parkinglot_data_first_then_parking_boy_data_when_parking_manager_manages__parking_boy_and_parkinglot() throws NoSpaceException {
        ParkingDirector parkingDirector = new ParkingDirector(new ParkingManager(ParkingLots.getParkBoyWithOneCarParked(),ParkingLots.getParkableWithOneCarParked()));

        String report = parkingDirector.printReport();

        String expectedReport = "M 2 0\n" +
                " P 1 0\n" +
                " S 1 0\n" +
                "  P 1 0";
        assertEquals(expectedReport, report);
    }
}
