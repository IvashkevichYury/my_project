package service;

import java.io.*;

public class DataWriter {

    public void writeDataToFile(String fileName, String data) {

        try (FileWriter writer = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            printWriter.print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
