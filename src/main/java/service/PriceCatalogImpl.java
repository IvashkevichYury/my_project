package service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PriceCatalogImpl implements PriceCatalog {

    private final Map<Integer, Double> colorMap = new HashMap<>();
    String fileName = ".\\\\src\\\\main\\\\resources\\\\horizontalBlindsPriceCatalog.csv";

    @Override
    public Map<Integer, Double> readFile() {
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split("-", 2);
                colorMap.put(Integer.parseInt(lines[0]), Double.parseDouble(lines[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не найден!");
            e.printStackTrace();
        }
        return colorMap;
    }

    @Override
    public Double getColorPrice(int color) {

        if (colorMap.get(color) == null) {
            throw new IllegalArgumentException("color must be 201 or 202");
        }
        return colorMap.get(color);
    }
}
