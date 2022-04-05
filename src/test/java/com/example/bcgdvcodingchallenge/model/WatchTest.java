package com.example.bcgdvcodingchallenge.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WatchTest {

    @Test
    void testPriceCalculation() {
        Watch watch = Watch.builder()
                .id("004")
                .name("Casio")
                .unitPrice(30)
                .build();

        int price = watch.countPrice(3);
        assertEquals(90, price);

    }

    @Test
    void testPriceCalculationZeroAmount() {
        Watch watch = Watch.builder()
                .id("004")
                .name("Casio")
                .unitPrice(30)
                .build();

        int price = watch.countPrice(0);
        assertEquals(0, price);

    }

}