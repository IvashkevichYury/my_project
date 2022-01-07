package view;

import model.BlindHorizontal;
import service.HorizontalService;
import service.HorizontalServiceImpl;
import service.PriceCatalog;

import java.util.Scanner;

public class UserPageImpl implements UserPage {

    private PriceCatalog priceCatalogImpl;
    private HorizontalService horizontalServiceImpl;

    public UserPageImpl(HorizontalService horizontalServiceImpl, PriceCatalog priceCatalogImpl) {
        this.horizontalServiceImpl = horizontalServiceImpl;
        this.priceCatalogImpl = priceCatalogImpl;
    }

    Scanner scanner = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    @Override
    public void showBlindCost() {
        priceCatalogImpl.initDate();
        while (true) {
            System.out.println("Would you like to calculate the cost of blinds?\nIf yes - enter Y, if no - enter N");
            String answer = scannerStr.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                long costBlinds = horizontalServiceImpl.calculateCost(requestData());
                System.out.println("Horizontal blind costs " + costBlinds + " rubles.\n");
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Calculation finished.");
                scannerStr.close();
                scanner.close();
                break;
            }
        }
    }

    private BlindHorizontal requestData() {
        BlindHorizontal blindHorizontal = new BlindHorizontal();
        System.out.println("Enter the width of the blindHorizontal in mm: ");
        blindHorizontal.setWidth(scanner.nextInt());
        System.out.println("Enter the height of the blindHorizontal in mm:");
        blindHorizontal.setHeight(scanner.nextInt());
        System.out.println("Enter the color number of the blindHorizontal (201, 202): ");
        blindHorizontal.setColor(scanner.nextInt());
        return blindHorizontal;
    }

}
