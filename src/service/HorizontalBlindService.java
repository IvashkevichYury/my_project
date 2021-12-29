package service;

import model.Blind;

public class HorizontalBlindService {

    private static final double dollarExchangeRate = 15;

    public long calculateCostOfBlinds(Blind blind, PriceCatalog priceCatalog) {
        int areaBlind = blind.getBlindsWidth() / 1000 * blind.getBlindsHeight() / 1000;
        double priceColor = priceCatalog.getColorPrice(blind.getColor());
        return Math.round(areaBlind * priceColor * dollarExchangeRate);
    }
}
