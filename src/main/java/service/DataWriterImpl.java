package service;

import model.Blind;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DataWriterImpl implements DataWriter {

    private List<Blind> orders = new ArrayList<>();

    @Override
    public void writeDataToList(Blind blind) {
        orders.add(blind);
    }

    @Override
    public void writeDataToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println("width,height,color,type,mountType,blindsCost");
            for (Blind order : orders) {
                printWriter.print(order);
                printWriter.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
