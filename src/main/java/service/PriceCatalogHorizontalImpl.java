package service;

import java.util.Map;

public class PriceCatalogHorizontalImpl implements PriceCatalogHorizontal {

    private Map<Integer, Double> colorMap;
    private DataReader dataReader;
//    private String fileNameColorPrice;
    private Property property;

    public PriceCatalogHorizontalImpl(DataReader dataReader, /*String fileNameColorPrice, */Property property) {
        this.dataReader = dataReader;
//        this.fileNameColorPrice = fileNameColorPrice;
        this.property = property;
    }

    @Override
    public Double getColorPrice(int color) {
        colorMap = dataReader.readPricesFromFile(property.getProperty("horizontalCatalog"));
        if (colorMap.get(color) == null) {
            throw new IllegalArgumentException("color must be 201 or 202");
        }
        return colorMap.get(color);
    }
}
