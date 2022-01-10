package service;

import java.util.Map;

public interface PriceCatalog {

    Map<Integer, Double> readFile();

    Double getColorPrice(int color);
}
