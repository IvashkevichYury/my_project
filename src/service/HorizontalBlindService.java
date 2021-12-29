package service;

import model.Blind;

public interface HorizontalBlindService {

    double calculateAreaOfBlinds(int width, int height);
    long calculateCostOfBlinds(Blind blind, PriceCatalog priceCatalogImpl);
}
