package service;

import model.Blind;

public interface HorizontalBlindService {

    long calculateCostOfBlinds(Blind blind, PriceCatalog priceCatalogImpl);
}
