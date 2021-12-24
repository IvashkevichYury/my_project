import java.util.Scanner;

public class BlindsCost {
    private int blindsWidth;
    private int blindsHeight;
    private double areaBlinds;
    private double priceForColors;
    private double cost;
    private static double dollarExchangeRate = 15;

    public double calculateCostOfBlinds() {
        cost = findAreaBlinds() * priceCalculationForColors() * dollarExchangeRate;
        System.out.println("Стоимость жалюзи: " + cost);
        return cost;
    }

    private double findAreaBlinds() {
        System.out.println("Введите ширину жалюзи в мм:");
        blindsWidth = requestNumber() / 1000;
        System.out.println("Введите длину жалюзи в мм:");
        blindsHeight = requestNumber() / 1000;
        areaBlinds = blindsWidth * blindsHeight;
        return areaBlinds;
    }

    private double priceCalculationForColors() {
        System.out.println("Введите номер цвета жалюзи (201, 202): ");
        int color = requestNumber();
        switch (color) {
            case 201:
                priceForColors = 8.8;
                break;
            case 202:
                priceForColors = 10.4;
                break;
        }
        return priceForColors;
    }

    private int requestNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
