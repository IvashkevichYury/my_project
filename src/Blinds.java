import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Blinds {

    private Map<Integer, Double> color = new HashMap<>();
    private double priceForColors;
    private static final double dollarExchangeRate = 15;

    public void calculateCostOfBlinds() {

        double cost = findAreaBlinds() * determineCostOfSelectedColorOfBlinds() * dollarExchangeRate;
        System.out.println("Blinds costs " + cost + " rubles.\n");
    }

    private double findAreaBlinds() {
        System.out.println("Enter the width of the blind in mm: ");
        double blindsWidth = requestDouble() / 1000;
        System.out.println("Enter the height of the blind in mm:");
        double blindsHeight = requestDouble() / 1000;
        return blindsWidth * blindsHeight;
    }

    private double determineCostOfSelectedColorOfBlinds() {
        System.out.println("Enter the color number of the blinds (201, 202): ");
        int color = requestInteger();
        initDate();
        for (Map.Entry<Integer, Double> entry : this.color.entrySet()) {
            if (entry.getKey() == color) {
                priceForColors = entry.getValue();
            }
        }
        return priceForColors;
    }

    private void initDate() {
        color.put(201, 8.8);
        color.put(202, 10.4);
    }

    private int requestInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private double requestDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

}
