package service;

import java.util.Map;

public interface DataReader {
    Map<Integer, Double> readPricesFromFile(String fileName);

//    String getPropertyValue(String propertyName);

}
