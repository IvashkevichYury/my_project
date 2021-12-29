package view;

import model.Blind;
import service.HorizontalBlindService;
import service.HorizontalBlindServiceImpl;
import service.PriceCatalog;
import service.PriceCatalogImpl;

import java.util.Scanner;

public class UserPageImpl implements UserPage{

    HorizontalBlindService horizontalBlindServiceImpl = new HorizontalBlindServiceImpl();
    PriceCatalog priceCatalogImpl = new PriceCatalogImpl();
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
                costBlinds = horizontalBlindServiceImpl.calculateCostOfBlinds(requestData(), priceCatalogImpl);
                System.out.println("model.Blind costs " + costBlinds + " rubles.\n");
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Calculation finished.");
                scannerStr.close();
                scanner.close();
                break;
            }
        }
    }

    @Override
    public Blind requestData() {
        Blind blind = new Blind();
        System.out.println("Enter the width of the blind in mm: ");
        blind.setBlindsWidth(scanner.nextInt());
        System.out.println("Enter the height of the blind in mm:");
        blind.setBlindsHeight(scanner.nextInt());
        System.out.println("Enter the color number of the blind (201, 202): ");
        blind.setColor(scanner.nextInt());
        return blind;
    }
}
