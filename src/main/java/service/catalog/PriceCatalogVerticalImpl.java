package service.catalog;

import service.fileService.DataReader;
import service.fileService.Property;

import java.util.Map;

public class PriceCatalogVerticalImpl implements PriceCatalogVertical {

    private Map<Integer, Double> priceByType;
    private DataReader dataReader;
    private Property property;

    public PriceCatalogVerticalImpl(DataReader dataReader, Property property) {
        this.dataReader = dataReader;
        this.property = property;
    }

    @Override
    public double getPriceMount() {
        return Double.parseDouble(property.getFileNamePriceMount());
    }

    @Override
    public Double getTypePrice(int type) {
        priceByType = dataReader.readPricesFromFile(property.getFileNameVerticalCatalog());
        Double priceType = priceByType.get(type);
        if (priceType == null) {
            throw new IllegalArgumentException("type must be 01, 02 or 03");
        }
        return priceType;
    }
}
