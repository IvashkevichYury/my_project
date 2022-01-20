package service;

import java.util.Map;

public class PriceCatalogVerticalImpl implements PriceCatalogVertical {

    private Map<Integer, Double> typeMap;
    String[] listColor = {"white", "green", "yellow", "blue", "beige"};
    String[] listMountType = {"ceiling", "wall"};
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
    public String getColor(int numberColor) {
        if (numberColor >= listColor.length) {
            throw new IllegalArgumentException("color must be white(0), green(1), yellow(2), blue(3), beige(4)");
        }
        return listColor[numberColor];
    }

    @Override
    public String getMountType(int numberMount) {
        if (numberMount >= listMountType.length) {
            throw new IllegalArgumentException("type must be ceiling(0) or wall(1)");
        }
        return listMountType[numberMount];
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
