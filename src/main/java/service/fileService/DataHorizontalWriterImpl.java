package service.fileService;

import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameMappingStrategyBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import model.Blind;
import model.BlindHorizontal;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DataHorizontalWriterImpl implements DataWriter {

    @Override
    public void writeDataToFile(List<? extends Blind> blindHorizontalList) {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd_hh.mm");
        String fileName = ".\\src\\main\\resources\\output\\output_" + formatDate.format(date) + ".csv";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            HeaderColumnNameMappingStrategy<BlindHorizontal> strategy = new HeaderColumnNameMappingStrategyBuilder<BlindHorizontal>().build();
            strategy.setType(BlindHorizontal.class);
            StatefulBeanToCsv<BlindHorizontal> beanToCsv = new StatefulBeanToCsvBuilder<BlindHorizontal>(writer)
                    .withMappingStrategy(strategy)
                    .build();
            beanToCsv.write((List<BlindHorizontal>) blindHorizontalList);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}
