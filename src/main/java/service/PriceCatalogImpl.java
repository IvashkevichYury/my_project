package service;

import java.util.HashMap;
import java.util.Map;

public class PriceCatalogImpl implements PriceCatalog {

    private final Map<Integer, Double> colorMap = new HashMap<>();
    String fileName = ".\\\\src\\\\main\\\\resources\\\\horizontalBlindsPriceCatalog.csv";
    private DataReader dataReader;

    public PriceCatalogImpl(DataReader dataReader) {
        this.dataReader = dataReader;
        dataReader.readFile(colorMap, fileName);
    }

    @Override
    public Double getColorPrice(int color) {

        if (colorMap.get(color) == null) {
            throw new IllegalArgumentException("color must be 201 or 202");
        }
        return colorMap.get(color);
    }
}
