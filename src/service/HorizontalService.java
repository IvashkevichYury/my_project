package service;

import model.Blind;

public interface HorizontalService {

    double calculateAreaOfBlinds(int width, int height);
    long calculateCost(Blind blind, PriceCatalog priceCatalogImpl);
}
