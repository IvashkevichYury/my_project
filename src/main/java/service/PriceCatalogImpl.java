package service;

import java.util.HashMap;
import java.util.Map;

public class PriceCatalogImpl implements PriceCatalog {

    private final Map<Integer, Double> colorMap = new HashMap<>();

    @Override
    public Map<Integer, Double> initDate() {
        colorMap.put(201, 8.8);
        colorMap.put(202, 10.4);

        return colorMap;
    }

    @Override
    public Double getColorPrice(int color) {

        if (colorMap.get(color) == null) {
            throw new IllegalArgumentException("color must be 201 or 202");
        }
        return colorMap.get(color);
    }
}
