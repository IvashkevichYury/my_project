package service.fileService;

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
            printWriter.println("width,height,type,colorNumber,color,mountType,areaBlinds,blindsCost");
            for (Blind order : orders) {
                printWriter.print(order.getWidth() + ",");
                printWriter.print(order.getHeight() + ",");
                if (order.getType() == 0) {
                    printWriter.print(",");
                } else {
                    printWriter.print(order.getType() + ",");
                }
                if (order.getColorNumber() == 0) {
                    printWriter.print(",");
                } else {
                    printWriter.print(order.getColorNumber() + ",");
                }
                if (order.getColor() == null) {
                    printWriter.print(",");
                } else {
                    printWriter.print(order.getColor() + ",");
                }
                if (order.getMountType() == null) {
                    printWriter.print(",");
                } else {
                    printWriter.print(order.getMountType() + ",");
                }
                printWriter.print(order.getAreaBlinds() + ",");
                printWriter.println(order.getBlindsCost());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
