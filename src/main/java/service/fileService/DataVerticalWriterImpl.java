package service.fileService;

import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameMappingStrategyBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import model.Blind;
import model.BlindVertical;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DataVerticalWriterImpl implements DataWriter {
    @Override
    public void writeDataToFile(List<? extends Blind> blindVerticalList) {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd_hh.mm");
        String fileName = ".\\src\\main\\resources\\output\\output_" + formatDate.format(date) + ".csv";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            HeaderColumnNameMappingStrategy<BlindVertical> strategy = new HeaderColumnNameMappingStrategyBuilder<BlindVertical>().build();
            strategy.setType(BlindVertical.class);
            StatefulBeanToCsv<BlindVertical> beanToCsv = new StatefulBeanToCsvBuilder<BlindVertical>(writer)
                    .withMappingStrategy(strategy)
                    .build();
            beanToCsv.write((List<BlindVertical>) blindVerticalList);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}
