package service;

import model.Blind;

public class HorizontalBlindServiceImpl implements HorizontalBlindService{

    private static final double dollarExchangeRate = 15;
    private double areaBlind;

    @Override
    public double calculateAreaOfBlinds(int width, int height) {
        areaBlind = (width / 1000.00) * (height / 1000.00);
        if (areaBlind < 0.75) {
            areaBlind = 0.75;
        }
        return areaBlind;
    }

    @Override
    public long calculateCostOfBlinds(Blind blind, PriceCatalog priceCatalogImpl) {
        areaBlind = calculateAreaOfBlinds(blind.getBlindsWidth(), blind.getBlindsHeight());
        double priceColor = priceCatalogImpl.getColorPrice(blind.getColor());
        return Math.round(areaBlind * priceColor * dollarExchangeRate);
    }
}
