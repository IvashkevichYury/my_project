package service;

import model.Blind;

public class HorizontalBlindServiceImpl implements HorizontalBlindService{

    private static final double dollarExchangeRate = 15;

    @Override
    public long calculateCostOfBlinds(Blind blind, PriceCatalog priceCatalogImpl) {
        int areaBlind = blind.getBlindsWidth() / 1000 * blind.getBlindsHeight() / 1000;
        double priceColor = priceCatalogImpl.getColorPrice(blind.getColor());
        return Math.round(areaBlind * priceColor * dollarExchangeRate);
    }
}
