package com.example.bcgdvcodingchallenge.controller;

import com.example.bcgdvcodingchallenge.exception.WatchNotFoundException;
import com.example.bcgdvcodingchallenge.model.CheckoutResponse;
import com.example.bcgdvcodingchallenge.service.CheckoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping(value = "/checkout",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CheckoutResponse checkout(@RequestBody List<String> request) {
        Integer price;
        try {
            price = checkoutService.checkout(request);
        } catch (WatchNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }

        return new CheckoutResponse(price);
    }

}
