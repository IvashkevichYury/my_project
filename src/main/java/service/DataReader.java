package service;

import java.util.Map;

public interface DataReader {
    Map<Integer, Double> readPricesFromFile(Map<Integer, Double> price, String fileName);

    String getPropertyValue(String propertyName);

}
