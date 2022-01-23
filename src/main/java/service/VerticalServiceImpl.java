package service;

import model.BlindVertical;

public class VerticalServiceImpl implements VerticalService {

    private BlindVertical blindVertical;
    private PriceCatalogVertical priceCatalogVertical;
    private ExchangeRate exchangeRate;

    public VerticalServiceImpl(BlindVertical blindVertical, PriceCatalogVertical priceCatalogVertical, ExchangeRate exchangeRate) {
        this.blindVertical = blindVertical;
        this.priceCatalogVertical = priceCatalogVertical;
        this.exchangeRate = exchangeRate;
    }

    private double calculateArea(int width, int height) {
        if (width < 400 || width > 6000 || height < 200 || height > 4000) {
            throw new IllegalArgumentException("width must be from 400 to 6000 and height must be from 200 to 4000");
        } else if (height < 1500) {
            height = 1500;
        }
        return (width / 1000.00) * (height / 1000.00);
    }

    private double calculateCostOfMount(String mountType, int width, String fileNamePriceMount) {
        double costOfMount = 0;
        double priceMount = priceCatalogVertical.getPriceMount(fileNamePriceMount);
        if (mountType.equalsIgnoreCase("ceiling")) {
            return costOfMount;
        } else if (mountType.equalsIgnoreCase("wall")) {
            if (width < 2000) {
                costOfMount = priceMount * 2;
            } else if (width <= 3000) {
                costOfMount = priceMount * 3;
            } else {
                costOfMount = priceMount * 4;
            }
        }
        return costOfMount;
    }

    @Override
    public long calculateCost(BlindVertical blindVertical, String fileNameTypePrice, String fileNamePriceMount, String fileNameExchangeRate) {
        double area = calculateArea(blindVertical.getWidth(), blindVertical.getHeight());
        blindVertical.setAreaBlinds(area);
        double priceType = priceCatalogVertical.getTypePrice(blindVertical.getType(), fileNameTypePrice);
        double costOfMount = calculateCostOfMount(blindVertical.getMountType(), blindVertical.getWidth(), fileNamePriceMount);
        double dollarExchangeRate = exchangeRate.getDollarExchangeRate(fileNameExchangeRate);
        return Math.round(area * priceType * dollarExchangeRate + costOfMount * dollarExchangeRate);
    }

}
