package service.fileService;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataReaderImpl implements DataReader {

    @Override
    public Map<Integer, Double> readPricesFromFile(String fileName) {
        Map<Integer, Double> price = new HashMap<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName));) {
            reader.readAll()
                    .stream()
                    .skip(1)
                    .forEach((a) -> {
                        price.put(Integer.parseInt(a[0]), Double.parseDouble(a[1]));
                    });
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return price;
    }
}
