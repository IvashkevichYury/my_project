package service;

import model.Blind;
import model.BlindHorizontal;

public class HorizontalServiceImpl implements HorizontalService {

    private static final double dollarExchangeRate = 15;
    private double areaBlind;

    Blind blindHorizontal;
    PriceCatalog priceCatalog;

    public HorizontalServiceImpl(Blind blindHorizontal, PriceCatalog priceCatalog) {
        this.blindHorizontal = blindHorizontal;
        this.priceCatalog = priceCatalog;
    }

    private double calculateAreaOfBlinds(int width, int height) {
        areaBlind = (width / 1000.00) * (height / 1000.00);
        if (areaBlind < 0.75) {
            areaBlind = 0.75;
        }
        return areaBlind;
    }

    @Override
    public long calculateCost() {
        areaBlind = calculateAreaOfBlinds(blindHorizontal.getWidth(), blindHorizontal.getHeight());
        double priceColor = priceCatalog.getColorPrice(blindHorizontal.getColor());
        return Math.round(areaBlind * priceColor * dollarExchangeRate);
    }
}
