package com.example.bcgdvcodingchallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class Catalogue {
    Map<String, Watch> watchMap;
}
