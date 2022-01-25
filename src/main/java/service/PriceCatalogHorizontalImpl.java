package service;

import java.util.Map;

public class PriceCatalogHorizontalImpl implements PriceCatalogHorizontal {

    private Map<Integer, Double> colorMap;
    private DataReader dataReader;
    private String fileNameColorPrice;

    public PriceCatalogHorizontalImpl(DataReader dataReader, String fileNameColorPrice) {
        this.dataReader = dataReader;
        this.fileNameColorPrice = fileNameColorPrice;
    }

    @Override
    public Double getColorPrice(int color) {
        colorMap = dataReader.readPricesFromFile(fileNameColorPrice);
        if (colorMap.get(color) == null) {
            throw new IllegalArgumentException("color must be 201 or 202");
        }
        return colorMap.get(color);
    }
}
