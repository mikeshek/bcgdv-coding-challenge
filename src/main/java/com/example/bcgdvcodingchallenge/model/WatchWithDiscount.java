package com.example.bcgdvcodingchallenge.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class WatchWithDiscount extends Watch {

    @Getter
    Discount discount;

    @Override
    public int countPrice(int amount) {
        int price = 0;
        Integer discounts = amount / this.getDiscount().getAmount();

        price += discounts * this.getDiscount().getPriceForAmount();
        price += (amount % this.getDiscount().getAmount()) * this.getUnitPrice();
        return price;
    }

}
