package com.example.bcgdvcodingchallenge.model;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Watch {

    String id;
    String name;

    @Getter
    Integer unitPrice;

    @Getter
    Discount discount;
}
