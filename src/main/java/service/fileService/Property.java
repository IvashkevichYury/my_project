package service.fileService;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Property {

    Properties properties = new Properties();

    public Property() {
        try (InputStream inputStream = Property.class.getResourceAsStream("/application.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String getFileNameHorizontalCatalog() {
        return properties.getProperty("horizontalCatalog");
    }

    public String getFileNameVerticalCatalog() {
        return properties.getProperty("verticalCatalog");
    }

    public String getFileNamePriceMount() {
        return properties.getProperty("priceMount");
    }

    public String getFileNameDollarExchangeRate() {
        return properties.getProperty("dollarExchangeRate");
    }

    public String getFileNameOutput() {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd_hh.mm");
        return properties.getProperty("output") + formatDate.format(date) + ".csv";
    }

}
