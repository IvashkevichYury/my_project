package service;

import model.BlindHorizontal;

public class HorizontalServiceImpl implements HorizontalService {

    private BlindHorizontal blindHorizontal;
    private PriceCatalogHorizontal priceCatalogHorizontal;
    private ExchangeRate exchangeRate;

    public HorizontalServiceImpl(BlindHorizontal blindHorizontal, PriceCatalogHorizontal priceCatalogHorizontal, ExchangeRate exchangeRate) {
        this.blindHorizontal = blindHorizontal;
        this.priceCatalogHorizontal = priceCatalogHorizontal;
        this.exchangeRate = exchangeRate;
    }

    private double calculateArea(int width, int height) {
        if (width < 250 || width > 2700 || height < 500 || height > 3000) {
            throw new IllegalArgumentException("width must be from 250 to 2700 and height must be from 500 to 3000");
        } else {
            return Math.max((width / 1000.00) * (height / 1000.00), 0.75);
        }
    }

    @Override
    public long calculateCost(BlindHorizontal blindHorizontal) {
        double area = calculateArea(blindHorizontal.getWidth(), blindHorizontal.getHeight());
        blindHorizontal.setAreaBlinds(area);
        double priceColor = priceCatalogHorizontal.getColorPrice(blindHorizontal.getColorNumber());
        double dollarExchangeRate = exchangeRate.getDollarExchangeRate();
        return Math.round(area * priceColor * dollarExchangeRate);
    }
}
