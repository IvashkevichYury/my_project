package service.fileService;

import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameMappingStrategyBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import model.BlindHorizontal;
import model.BlindVertical;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DataWriterImpl implements DataWriter {

    @Override
    public void writeDataToFile(List<BlindHorizontal> blindHorizontalList, List<BlindVertical> blindVerticalList) {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd_hh.mm");
        String fileName = ".\\src\\main\\resources\\output\\output_" + formatDate.format(date) + ".csv";
        try (FileWriter writer = new FileWriter(fileName)) {
            HeaderColumnNameMappingStrategy<BlindHorizontal> strategyH = new HeaderColumnNameMappingStrategyBuilder<BlindHorizontal>().build();
            HeaderColumnNameMappingStrategy<BlindVertical> strategyV = new HeaderColumnNameMappingStrategyBuilder<BlindVertical>().build();
            strategyH.setType(BlindHorizontal.class);
            strategyV.setType(BlindVertical.class);
            StatefulBeanToCsv<BlindHorizontal> beanHorizontalToCsv = new StatefulBeanToCsvBuilder<BlindHorizontal>(writer)
                    .withMappingStrategy(strategyH)
                    .build();
            beanHorizontalToCsv.write(blindHorizontalList);
            StatefulBeanToCsv<BlindVertical> beanVerticalToCsv = new StatefulBeanToCsvBuilder<BlindVertical>(writer)
                    .withMappingStrategy(strategyV)
                    .build();
            beanVerticalToCsv.write(blindVerticalList);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}
