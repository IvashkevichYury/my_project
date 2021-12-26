import java.util.Scanner;

public class UserPage {

    double blindsWidth;
    double blindsHeight;
    int color;

    Blinds blinds = new Blinds();

    public void showBlindCost() {

        while (true) {
            System.out.println("Would you like to calculate the cost of blinds?\nIf yes - enter Y, if no - enter N");
            String answer = requestString();
            if (answer.equalsIgnoreCase("Y")) {
                requestData();
                blinds.calculateCostOfBlinds(blindsWidth, blindsHeight, color);
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Calculation finished.");
                break;
            }
        }
    }

    private void requestData() {
        System.out.println("Enter the width of the blind in mm: ");
        blindsWidth = requestDouble() / 1000;
        System.out.println("Enter the height of the blind in mm:");
        blindsHeight = requestDouble() / 1000;
        System.out.println("Enter the color number of the blinds (201, 202): ");
        color = requestInteger();
    }

    private int requestInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private double requestDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private String requestString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
