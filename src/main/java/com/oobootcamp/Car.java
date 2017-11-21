package com.oobootcamp;

public class Car {
    private String number;

    public Car(int number) {
        this.number = String.valueOf(number);
    }

    public Car(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
