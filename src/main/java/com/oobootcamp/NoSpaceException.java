package com.oobootcamp;

public class NoSpaceException extends Exception {
    public NoSpaceException() {
        super("Parking Lot is full.");
    }
}
