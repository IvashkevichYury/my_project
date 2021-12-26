import java.util.Scanner;

public class UserPage {

    CostBlinds costBlinds = new CostBlinds();

    public void showBlindCost() {

        while (true) {
            System.out.println("Would you like to calculate the cost of blinds?\nIf yes - enter Y, if no - enter N");
            String answer = requestString();
            if (answer.equalsIgnoreCase("Y")) {

                System.out.println("Blinds costs " + costBlinds.calculateCostOfBlinds(requestData()) + " rubles.\n");
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Calculation finished.");
                break;
            }
        }
    }

    public Blinds requestData() {
        Blinds blinds = new Blinds();
        System.out.println("Enter the width of the blind in mm: ");
        blinds.setBlindsWidth(requestDouble() / 1000);
        System.out.println("Enter the height of the blind in mm:");
        blinds.setBlindsHeight(requestDouble() / 1000);
        System.out.println("Enter the color number of the blinds (201, 202): ");
        blinds.setColor(requestInteger());
        return blinds;
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
