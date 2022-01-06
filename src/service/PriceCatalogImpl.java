package service;

import java.util.HashMap;
import java.util.Map;

public class PriceCatalogImpl implements PriceCatalog {

    private final Map<Integer, Double> colorMap = new HashMap<>();
    Double colorPrice;

    @Override
    public Map<Integer, Double> initDate() {
        colorMap.put(201, 8.8);
        colorMap.put(202, 10.4);

        return colorMap;
    }

    @Override
    public Double getColorPrice(int color) {

        colorPrice = colorMap.get(color);
        if (colorPrice == null) {
            throw new IllegalArgumentException("invalid input data: color");
        }
        return colorPrice;
    }
}
