package com.example.bcgdvcodingchallenge.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WatchWithDiscountTest {

    @ParameterizedTest
    @MethodSource("provideWatchesToTest")
    void testPriceCalculationNotActivateDiscount(Watch watch, int amount, int expected) {
        int price = watch.countPrice(amount);
        assertEquals(expected, price);
    }

    private static Stream<Arguments> provideWatchesToTest() {
        return Stream.of(
                Arguments.of(WatchWithDiscount.builder()
                        .id("001")
                        .name("Rolex")
                        .unitPrice(100)
                        .discount(new Discount(3, 200))
                        .build(), 1, 100),
                Arguments.of(WatchWithDiscount.builder()
                        .id("001")
                        .name("Rolex")
                        .unitPrice(100)
                        .discount(new Discount(3, 200))
                        .build(), 3, 200),
                Arguments.of(WatchWithDiscount.builder()
                        .id("001")
                        .name("Rolex")
                        .unitPrice(100)
                        .discount(new Discount(3, 200))
                        .build(), 4, 300)
        );
    }


}