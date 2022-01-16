package service;

import java.util.HashMap;
import java.util.Map;

public class PriceCatalogHorizontalImpl implements PriceCatalogHorizontal {

    private final Map<Integer, Double> colorMap = new HashMap<>();
    private DataReader dataReader;

    public PriceCatalogHorizontalImpl(DataReader dataReader) {
        this.dataReader = dataReader;
        dataReader.readPricesFromFile(colorMap, dataReader.getPropertyValue("horizontalCatalog"));
    }

    @Override
    public Double getColorPrice(int color) {

        if (colorMap.get(color) == null) {
            throw new IllegalArgumentException("color must be 201 or 202");
        }
        return colorMap.get(color);
    }
}