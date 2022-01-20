package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyImpl implements Property{

    @Override
    public String getPropertyValue(String propertyName) {
        String propertyValue = "";
        try (InputStream inputStream = PriceCatalogVerticalImpl.class.getResourceAsStream("/application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException e) {
            System.out.println(e);
        }
        return propertyValue;
    }
}
