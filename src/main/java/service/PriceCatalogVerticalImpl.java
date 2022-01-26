package service;

import java.util.Map;

public class PriceCatalogVerticalImpl implements PriceCatalogVertical {

    private Map<Integer, Double> typeMap;
    private DataReader dataReader;
//    private String fileNamePriceMount;
//    private String fileNameTypePrice;
    private Property property;

    public PriceCatalogVerticalImpl(DataReader dataReader, /*String fileNamePriceMount, String fileNameTypePrice, */Property property) {
        this.dataReader = dataReader;
//        this.fileNamePriceMount = fileNamePriceMount;
//        this.fileNameTypePrice = fileNameTypePrice;
        this.property = property;
    }

    @Override
    public double getPriceMount() {
        return Double.parseDouble(property.getProperty("priceMount"));
    }

    @Override
    public Double getTypePrice(int type) {
        typeMap = dataReader.readPricesFromFile(property.getProperty("verticalCatalog"));
        if (typeMap.get(type) == null) {
            throw new IllegalArgumentException("type must be 01, 02 or 03");
        }
        return typeMap.get(type);
    }
}
