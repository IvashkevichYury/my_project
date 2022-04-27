package service.fileService;

import java.util.Map;

public interface DataReader {
    Map<Integer, Double> readPricesFromFile(String fileName);

}
