package service.fileService;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import model.Blind;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataWriter {

    Property property;

    public DataWriter(Property property) {
        this.property = property;
    }

    public void writeDataToFile(List<? extends Blind> blind) {
        try (FileWriter writer = new FileWriter(property.getFileNameOutput(), true)) {
            StatefulBeanToCsv<Blind> beanToCsv = new StatefulBeanToCsvBuilder<Blind>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write((List<Blind>) blind);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}
