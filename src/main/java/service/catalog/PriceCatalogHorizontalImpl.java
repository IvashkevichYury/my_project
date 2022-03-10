package service.catalog;

import service.fileService.DataReader;
import service.fileService.Property;

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
        colorMap = dataReader.readPricesFromFile(property.getFileNameHorizontalCatalog());
        Double colorPrice = colorMap.get(color);
        if (colorPrice == null) {
            throw new IllegalArgumentException("color number must be 201 or 202");
        }
        return colorPrice;
    }
}
