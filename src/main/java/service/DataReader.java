package service;

import java.util.Map;

public interface DataReader {
    Map<Integer, Double> readFile(Map<Integer, Double> price, String fileName);

}
