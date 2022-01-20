package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class DataReaderImpl implements DataReader {

    @Override
    public Map<Integer, Double> readPricesFromFile(String fileName) {
        Map<Integer, Double> price = new HashMap<>();
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(",", 2);
                price.put(Integer.parseInt(lines[0]), Double.parseDouble(lines[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не найден!");
            e.printStackTrace();
        }
        return price;
    }

//    @Override
//    public String getPropertyValue(String propertyName) {
//        String propertyValue = "";
//        try (InputStream inputStream = PriceCatalogVerticalImpl.class.getResourceAsStream("/application.properties")) {
//            Properties properties = new Properties();
//            properties.load(inputStream);
//            propertyValue = properties.getProperty(propertyName);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//        return propertyValue;
//    }
}
