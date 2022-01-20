package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DBBlindsImpl implements DBBlinds {

    private List<String> orders = new ArrayList<>();

    @Override
    public void saveOrders(String blind) {
        orders.add(blind);
    }

    @Override
    public void getOrders(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println("width,height,color,type,mountType,blindsCost");
            for (String order : orders) {
                printWriter.print(order);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
