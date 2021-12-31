package view;

import model.Blind;
import service.HorizontalService;
import service.HorizontalServiceImpl;
import service.PriceCatalog;
import service.PriceCatalogImpl;

import java.util.Scanner;

public class UserPageImpl implements UserPage {

    Blind blind = new Blind();
    PriceCatalog priceCatalogImpl = new PriceCatalogImpl();
    HorizontalService horizontalServiceImpl;

    Scanner scanner = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);
    long costBlinds;

    @Override
    public void showBlindCost() {
        priceCatalogImpl.initDate();
        while (true) {
            System.out.println("Would you like to calculate the cost of blinds?\nIf yes - enter Y, if no - enter N");
            String answer = scannerStr.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                horizontalServiceImpl = new HorizontalServiceImpl(requestData(), priceCatalogImpl);
                costBlinds = horizontalServiceImpl.calculateCost();
                System.out.println("model.Blind costs " + costBlinds + " rubles.\n");
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Calculation finished.");
                scannerStr.close();
                scanner.close();
                break;
            }
        }
    }

    private Blind requestData() {

        System.out.println("Enter the width of the blind in mm: ");
        blind.setWidth(scanner.nextInt());
        System.out.println("Enter the height of the blind in mm:");
        blind.setHeight(scanner.nextInt());
        System.out.println("Enter the color number of the blind (201, 202): ");
        blind.setColor(scanner.nextInt());
        return blind;
    }

}
