package service.fileService;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DataReaderImpl implements DataReader {

    @Override
    public Map<Integer, Double> readPricesFromFile(String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName));) {
            return reader.readAll()
                    .stream()
                    .skip(1)
                    .collect(Collectors.toMap(k -> Integer.parseInt(k[0]), v -> Double.parseDouble(v[1])));

        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return null;
        }
    }
}
