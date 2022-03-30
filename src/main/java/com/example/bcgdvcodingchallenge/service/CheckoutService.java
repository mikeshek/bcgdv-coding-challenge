package com.example.bcgdvcodingchallenge.service;

import com.example.bcgdvcodingchallenge.exception.WatchNotFoundException;
import com.example.bcgdvcodingchallenge.model.Catalogue;
import com.example.bcgdvcodingchallenge.model.Watch;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckoutService {

    private final CatalogueService catalogueService;

    public CheckoutService(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    // Checkout logic
    public Integer checkout(List<String> watchList) {
        Catalogue catalogue = catalogueService.getCatalogue();

        Map<String, Integer> counter = new HashMap<>();
        for (String watchId : watchList) {
            counter.put(watchId, counter.getOrDefault(watchId, 0) + 1);
        }

        int price = 0;
        for (Map.Entry<String, Integer> watchCounter : counter.entrySet()) {
            String watchId = watchCounter.getKey();
            Integer count = watchCounter.getValue();

            if (catalogue.getWatchMap().containsKey(watchId)) {
                Watch watch = catalogue.getWatchMap().get(watchId);
                if (watch.getDiscount() != null) {
                    Integer discounts = count / watch.getDiscount().getAmount();

                    price += discounts * watch.getDiscount().getPriceForAmount();
                    price += (count % watch.getDiscount().getAmount()) * watch.getUnitPrice();
                } else {
                    price += count * watch.getUnitPrice();
                }
            } else {
                throw new WatchNotFoundException("Watch Id '" + watchId + "' was not found in the catalog.");
            }
        }

        return price;
    }
}
