package com.oobootcamp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthTest3 {

    @Test
    public void shouldReturnLongerLength() {
        Length longerLength = new Length(10);
        Length l2 = new Length(5);
        assertEquals(longerLength, Length.max(longerLength, l2));
    }

    @Test
    public void shouldReturnDefaultUnitWhenLengthIsNotTooLong() {
        Length longLength = new Length(50);
        assertEquals("50 cm", longLength.toString());
    }

    @Test
    public void shouldReturnLengthUnitWhenLengthIsTooLong() {
        Length longLength = new Length(100);
        assertEquals("1 m", longLength.toString());
    }


    @Test
    public void shouldReturnLongerLengthWithUnit() {
        Length shorterLength = new Length(10, "cm");
        Length longerLength = new Length(5, "m");
        assertEquals(longerLength, Length.max(longerLength, shorterLength));
    }


}