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

        if ((width / 1000.00) * (height / 1000.00) < 0.75) {
            return 0.75;
        } else {
            return (width / 1000.00) * (height / 1000.00);
        }
    }

    @Override
    public long calculateCost() {
        double area = calculateAreaOfBlinds(blindHorizontal.getWidth(), blindHorizontal.getHeight());
        double priceColor = priceCatalog.getColorPrice(blindHorizontal.getColor());
        return Math.round(area * priceColor * dollarExchangeRate);
    }
}
