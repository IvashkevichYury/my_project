package service;

import java.util.Map;

public interface PriceCatalog {

    Map<Integer, Double> initDate();

    Double getColorPrice(int color);
}
