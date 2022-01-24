package service;

import java.util.Map;

public class PriceCatalogVerticalImpl implements PriceCatalogVertical {

    private Map<Integer, Double> typeMap;
    private DataReader dataReader;

    public PriceCatalogVerticalImpl(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    @Override
    public double getPriceMount(String fileName) {
        return Double.parseDouble(fileName);
    }

    @Override
    public Double getTypePrice(int type, String fileName) {
        typeMap = dataReader.readPricesFromFile(fileName);
        if (typeMap.get(type) == null) {
            throw new IllegalArgumentException("type must be 01, 02 or 03");
        }
        return typeMap.get(type);
    }
}
