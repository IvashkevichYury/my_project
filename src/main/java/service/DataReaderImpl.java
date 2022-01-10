package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class DataReaderImpl implements DataReader {

    @Override
    public Map<Integer, Double> readFile(Map<Integer, Double> price, String fileName) {
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split("-", 2);
                price.put(Integer.parseInt(lines[0]), Double.parseDouble(lines[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не найден!");
            e.printStackTrace();
        }
        return price;
    }

}
