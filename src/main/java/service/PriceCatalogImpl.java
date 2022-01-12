package service;

import java.util.HashMap;
import java.util.Map;

public class PriceCatalogImpl implements PriceCatalog {

    private final Map<Integer, Double> typeMap = new HashMap<>();
    String fileName = ".\\\\src\\\\main\\\\resources\\\\horizontalBlindsPriceCatalog.csv";
    private DataReader dataReader;

    public PriceCatalogImpl(DataReader dataReader) {
        this.dataReader = dataReader;
        dataReader.readFile(typeMap, fileName);
    }

    @Override
    public Double getTypePrice(int type) {

        if (typeMap.get(type) == null) {
            throw new IllegalArgumentException("type must be 201 or 202");
        }
        return typeMap.get(type);
    }
}
