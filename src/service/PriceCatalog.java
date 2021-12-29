package service;

import java.util.Map;

public interface PriceCatalog {

    Map<Integer, Double> initDate();
    double getColorPrice(int color);
}
