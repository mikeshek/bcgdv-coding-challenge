package com.example.bcgdvcodingchallenge.service;

import com.example.bcgdvcodingchallenge.model.Catalogue;
import com.example.bcgdvcodingchallenge.model.Discount;
import com.example.bcgdvcodingchallenge.model.Watch;
import com.example.bcgdvcodingchallenge.model.WatchWithDiscount;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CatalogueService {

    /*
        Generates catalogue structure
        In real life, could be loaded from DB
    */
    public Catalogue getCatalogue() {
        Catalogue catalogue = new Catalogue(new HashMap<>());

        catalogue.getWatchMap().put("001",
                WatchWithDiscount.builder()
                        .id("001")
                        .name("Rolex")
                        .unitPrice(100)
                        .discount(new Discount(3, 200))
                        .build());

        catalogue.getWatchMap().put("002",
                WatchWithDiscount.builder()
                        .id("002")
                        .name("Michael Kors")
                        .unitPrice(80)
                        .discount(new Discount(2, 120))
                        .build());

        catalogue.getWatchMap().put("003",
                Watch.builder()
                        .id("003")
                        .name("Swatch")
                        .unitPrice(50)
                        .build());

        catalogue.getWatchMap().put("004",
                Watch.builder()
                        .id("004")
                        .name("Casio")
                        .unitPrice(30)
                        .build());

        return catalogue;
    }

}