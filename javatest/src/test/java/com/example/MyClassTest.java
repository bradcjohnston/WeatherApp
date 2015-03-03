package com.example;

public class MyClassTest {

    @org.junit.Test
    public void testAddingDosIntegers() throws Exception {
        //MyClas is tested
        addingTwoIntegers test = new addingTwoIntegers();
        //tests
        org.junit.Assert.assertEquals("1 + 2 must be 3", 3, (1, 2));
        assertEquals("0 + 2 must be 2", 2, test.addingDosIntegers(0, 2));
        assertEquals("-1 + 2 must be 1", 1, test.addingDosIntegers(-1, 2));
    }
}