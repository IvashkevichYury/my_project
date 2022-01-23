package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyImpl implements Property{

    public Map<String, String> saveProperties(String fileProperties) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(fileProperties));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, String> mapProperties = new HashMap<>();

        for (String name : properties.stringPropertyNames()) {
            mapProperties.put(name, properties.getProperty(name));
        }
        return mapProperties;
    }
}
