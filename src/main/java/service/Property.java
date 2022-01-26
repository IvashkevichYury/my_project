package service;

import java.io.IOException;
import java.io.InputStream;
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

    public String getPropertyHorizontalCatalog() {
        return properties.getProperty("horizontalCatalog");
    }

    public String getPropertyVerticalCatalog() {
        return properties.getProperty("verticalCatalog");
    }

    public String getPropertyPriceMount() {
        return properties.getProperty("priceMount");
    }

    public String getPropertyDollarExchangeRate() {
        return properties.getProperty("dollarExchangeRate");
    }

    public String getPropertyOutputFile() {
        return properties.getProperty("outputFile");
    }

}
