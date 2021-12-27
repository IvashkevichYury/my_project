package service;

import java.util.Map;

public class CostBlinds {

    private static final double dollarExchangeRate = 15;

    private double findAreaBlinds(Blind blind) {
        return blind.getBlindsWidth() * blind.getBlindsHeight();
    }

    private double findPriceColor(Blind blind, Map<Integer, Double> priceForColors) {
        return priceForColors.get(blind.getColor());
    }

    public long calculateCostOfBlinds(Blind blind, Map<Integer, Double> priceForColors) {

        return Math.round(findAreaBlinds(blind) * findPriceColor(blind, priceForColors) * dollarExchangeRate);
    }
}