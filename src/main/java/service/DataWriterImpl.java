package service;

import java.io.*;
import java.util.Properties;

public class DataWriterImpl implements DataWriter {

    @Override
    public void writeDataToFile(String fileName, String data) {

        try (FileWriter writer = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            printWriter.print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public String getPropertyValue(String propertyName) {
//        String propertyValue = "";
//        try (InputStream inputStream = PriceCatalogVerticalImpl.class.getResourceAsStream("/application.properties")) {
//            Properties properties = new Properties();
//            properties.load(inputStream);
//            propertyValue = properties.getProperty(propertyName);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//        return propertyValue;
//    }
}
