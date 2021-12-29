package service;

import model.Blind;

public class HorizontalServiceImpl implements HorizontalService {

    private static final double dollarExchangeRate = 15;
    private double areaBlind;

    Blind blind;
    PriceCatalog priceCatalog;

    public HorizontalServiceImpl(Blind blind, PriceCatalog priceCatalog) {
        this.blind = blind;
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
        areaBlind = calculateAreaOfBlinds(blind.getWidth(), blind.getHeight());
        double priceColor = priceCatalog.getColorPrice(blind.getColor());
        return Math.round(areaBlind * priceColor * dollarExchangeRate);
    }
}
