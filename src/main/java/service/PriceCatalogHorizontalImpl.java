package service;

import java.util.Map;

public class PriceCatalogHorizontalImpl implements PriceCatalogHorizontal {

    private Map<Integer, Double> colorMap;
    private DataReader dataReader;
    private Property property;

    public PriceCatalogHorizontalImpl(DataReader dataReader, Property property) {
        this.dataReader = dataReader;
        this.property = property;
    }

    @Override
    public Double getColorPrice(int color) {
        colorMap = dataReader.readPricesFromFile(property.getPropertyValue("horizontalCatalog"));
        if (colorMap.get(color) == null) {
            throw new IllegalArgumentException("color must be 201 or 202");
        }
        return colorMap.get(color);
    }

    @Override
    public double getDollarExchangeRate() {
        return Double.parseDouble(property.getPropertyValue("dollarExchangeRate"));
    }
}
