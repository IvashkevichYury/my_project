package service;

import model.BlindVertical;

public class VerticalServiceImpl implements VerticalService {

    private static final double dollarExchangeRate = 15;
    private BlindVertical blindVertical;
    private PriceCatalogVertical priceCatalogVertical;

    public VerticalServiceImpl(BlindVertical blindVertical, PriceCatalogVertical priceCatalogVertical) {
        this.blindVertical = blindVertical;
        this.priceCatalogVertical = priceCatalogVertical;
    }

    private double calculateArea(int width, int height) {
        if (width < 400 || width > 6000 || height < 200 || height > 4000) {
            throw new IllegalArgumentException("width must be from 400 to 6000 and height must be from 200 to 4000");
        } else if (height < 1500) {
            height = 1500;
        }
        return (width / 1000.00) * (height / 1000.00);
    }

    private double calculateCostOfMount(String mountType, int width) {
        double costOfMount = 0;
        double priceMount = priceCatalogVertical.getPriceMount();
        if (mountType.equalsIgnoreCase("ceiling")) {
            return costOfMount;
        } else if ((mountType.equalsIgnoreCase("wall")) && (width < 2000)) {
            costOfMount = priceMount * 2;
        } else if ((mountType.equalsIgnoreCase("wall")) && (width >= 2000 && width <= 3000)) {
            costOfMount = priceMount * 3;
        } else if ((mountType.equalsIgnoreCase("wall")) && (width > 3000)) {
            costOfMount = priceMount * 4;
        }
        return costOfMount;
    }

    @Override
    public long calculateCost(BlindVertical blindVertical) {
        double area = calculateArea(blindVertical.getWidth(), blindVertical.getHeight());
        blindVertical.setAreaBlinds(area);
        double priceType = priceCatalogVertical.getTypePrice(blindVertical.getType());
        double costOfMount = calculateCostOfMount(blindVertical.getMountType(), blindVertical.getWidth());
        return Math.round(area * priceType * dollarExchangeRate + costOfMount * dollarExchangeRate);
    }

    @Override
    public String getColor(int numberColor) {
        return priceCatalogVertical.getColor(numberColor);
    }

    @Override
    public String getMountType(int numberMount) {
        return priceCatalogVertical.getMountType(numberMount);
    }
}
