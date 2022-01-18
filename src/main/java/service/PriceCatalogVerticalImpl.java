package service;

import java.util.Map;

public class PriceCatalogVerticalImpl implements PriceCatalogVertical {

    private Map<Integer, Double> typeMap;
    private double priceMount;
    String[] listColor = {"white", "green", "yellow", "blue", "beige"};
    String[] listMountType = {"ceiling", "wall"};
    private DataReader dataReader;

    public PriceCatalogVerticalImpl(DataReader dataReader) {
        this.dataReader = dataReader;
        typeMap = dataReader.readPricesFromFile(dataReader.getPropertyValue("verticalCatalog"));
        priceMount = Double.parseDouble(dataReader.getPropertyValue("priceMount"));
    }

    @Override
    public double getPriceMount() {
        return priceMount;
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
        if (typeMap.get(type) == null) {
            throw new IllegalArgumentException("type must be 01, 02 or 03");
        }
        return typeMap.get(type);
    }
}
