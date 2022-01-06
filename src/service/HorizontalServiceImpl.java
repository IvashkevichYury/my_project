package service;

import model.BlindHorizontal;

public class HorizontalServiceImpl implements HorizontalService {

    private static final double dollarExchangeRate = 15;
    private BlindHorizontal blindHorizontal;
    private PriceCatalog priceCatalog;

    public HorizontalServiceImpl(BlindHorizontal blindHorizontal, PriceCatalog priceCatalog) {
        this.blindHorizontal = blindHorizontal;
        this.priceCatalog = priceCatalog;
    }

    private double calculateAreaOfBlinds(int width, int height) {
        if (width < 250 || width > 2700 || height < 500 || height > 3000) {
            throw new IllegalArgumentException("invalid input data");
        } else {
            return Math.max((width / 1000.00) * (height / 1000.00), 0.75);
        }
    }

    @Override
    public long calculateCost(BlindHorizontal blindHorizontal) {
        double area = calculateAreaOfBlinds(blindHorizontal.getWidth(), blindHorizontal.getHeight());
        blindHorizontal.setAreaBlinds(area);
        double priceColor = priceCatalog.getColorPrice(blindHorizontal.getColor());
        return Math.round(area * priceColor * dollarExchangeRate);
    }
}
