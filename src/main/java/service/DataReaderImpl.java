package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataReaderImpl implements DataReader {

    @Override
    public Map<Integer, Double> readPricesFromFile(String fileName) {
        Map<Integer, Double> price = new HashMap<>();
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(",", 2);
                Arrays.stream(lines).forEach(s -> {
                    price.putIfAbsent(Integer.parseInt(lines[0]), Double.parseDouble(lines[1]));
                });
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не найден!");
            e.printStackTrace();
        }
        return price;
    }
}
