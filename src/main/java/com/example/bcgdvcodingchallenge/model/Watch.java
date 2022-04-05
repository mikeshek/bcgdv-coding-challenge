package com.example.bcgdvcodingchallenge.model;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Watch implements Priceable {

    String id;
    String name;

    @Getter
    Integer unitPrice;

    @Override
    public int countPrice(int amount) {
        return amount * unitPrice;
    }
}
