package com.example.bcgdvcodingchallenge.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {

    private final CatalogueService catalogueService = new CatalogueService();

    @Test
    void emptyListTest() {
        CheckoutService checkoutService = new CheckoutService(catalogueService);
        Integer price = checkoutService.checkout(Collections.emptyList());
        assertEquals(0, price);
    }

    @Test
    void listWithOneWatchTest() {
        CheckoutService checkoutService = new CheckoutService(catalogueService);
        Integer price = checkoutService.checkout(List.of("001"));
        assertEquals(100, price);
    }

    @Test
    void listWithOneWatchDiscountTest() {
        CheckoutService checkoutService = new CheckoutService(catalogueService);
        Integer price = checkoutService.checkout(Arrays.asList("002", "002"));
        assertEquals(120, price);
    }

    @Test
    void listWithOneWatchMultipleDiscountTest() {
        CheckoutService checkoutService = new CheckoutService(catalogueService);
        Integer price = checkoutService.checkout(Arrays.asList("002", "002", "002", "002"));
        assertEquals(240, price);
    }

    @Test
    void listWithOneWatchMultipleDiscountAndOneTest() {
        CheckoutService checkoutService = new CheckoutService(catalogueService);
        Integer price = checkoutService.checkout(Arrays.asList("002", "002", "002", "002", "002"));
        assertEquals(320, price);
    }

    @Test
    void listWithMultipleWatchTest() {
        CheckoutService checkoutService = new CheckoutService(catalogueService);
        Integer price = checkoutService.checkout(Arrays.asList("001", "002", "003", "004"));
        assertEquals(260, price);
    }
}