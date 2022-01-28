package service.fileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DataReaderImpl implements DataReader {

    @Override
    public Map<Integer, Double> readPricesFromFile(String fileName) {
        Map<Integer, Double> price = new HashMap<>();
        try {
            price = Files.lines(Paths.get(fileName))
                    .skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.toMap(k -> Integer.parseInt(k[0]), v -> Double.parseDouble(v[1])));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return price;
    }
}
