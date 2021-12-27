package view;

import model.Blind;
import service.HorizontalBlindService;
import service.PriceCatalog;

import java.util.Scanner;

public class UserPage {

    HorizontalBlindService horizontalBlindService = new HorizontalBlindService();
    PriceCatalog priceCatalog = new PriceCatalog();
    Scanner scanner = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    public void showBlindCost() {
        priceCatalog.initDate();
        while (true) {
            System.out.println("Would you like to calculate the cost of blinds?\nIf yes - enter Y, if no - enter N");
            String answer = scannerStr.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                System.out.println("model.Blind costs " +
                        horizontalBlindService.calculateCostOfBlinds(requestData(), priceCatalog.getColorMap()) + " rubles.\n");
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Calculation finished.");
                scannerStr.close();
                scanner.close();
                break;
            }
        }
    }

    public Blind requestData() {
        Blind blind = new Blind();
        System.out.println("Enter the width of the blind in mm: ");
        blind.setBlindsWidth(scanner.nextDouble());
        System.out.println("Enter the height of the blind in mm:");
        blind.setBlindsHeight(scanner.nextDouble());
        System.out.println("Enter the color number of the blind (201, 202): ");
        blind.setColor(scanner.nextInt());
        return blind;
    }
}
