package com.oobootcamp;


public class Length {
    private int length;

    private String unit = "cm";

    public Length(int i) {
        this.length = i;
        if(length >= 100){
            this.length = i/100;
            this.unit = "m";
        }
    }

    public Length(int i, String unit) {
        this.length = i;
        this.unit = unit;
    }

    public int compare(Length other) {
        return this.getStanderLength() - other.getStanderLength();
    }

    private int getStanderLength() {
        if ("m".equals(unit)) {
            return length * 100;
        }
        return this.length;
    }

    @Override
    public String toString() {
        return this.length + " " + this.unit;
    }

    public static Length max(Length length1, Length length2) {
        return length1.compare(length2) > 0 ? length1 : length2;
    }
}
