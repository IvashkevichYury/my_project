package service;

import java.util.Map;

public class PriceCatalogVerticalImpl implements PriceCatalogVertical {

    private Map<Integer, Double> typeMap;
    private DataReader dataReader;
    private Property property;

    public PriceCatalogVerticalImpl(DataReader dataReader, Property property) {
        this.dataReader = dataReader;
        this.property = property;
    }

    @Override
    public double getPriceMount() {
        return Double.parseDouble(property.getPropertyValue("priceMount"));
    }

    @Override
    public Double getTypePrice(int type) {
        typeMap = dataReader.readPricesFromFile(property.getPropertyValue("verticalCatalog"));
        if (typeMap.get(type) == null) {
            throw new IllegalArgumentException("type must be 01, 02 or 03");
        }
        return typeMap.get(type);
    }
}
