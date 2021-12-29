package service;

import model.Blind;

public interface HorizontalService {

    long calculateCost(Blind blind, PriceCatalog priceCatalogImpl);
}
