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
    public double getColorPrice(int color) {
        return colorMap.get(color);
    }
}
