package view;

import model.BlindHorizontal;
import model.BlindVertical;
import service.HorizontalService;
import service.VerticalService;

import java.util.Scanner;

public class UserPageImpl implements UserPage {

    private HorizontalService horizontalServiceImpl;
    private VerticalService verticalServiceImpl;

    public UserPageImpl(HorizontalService horizontalServiceImpl, VerticalService verticalServiceImpl) {
        this.horizontalServiceImpl = horizontalServiceImpl;
        this.verticalServiceImpl = verticalServiceImpl;
    }

    Scanner scanner = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    @Override
    public void showBlindCost() {
        while (true) {
            System.out.println("Would you like to calculate the cost of blinds?\nIf yes - enter Y, if no - enter N");
            String answer = scannerStr.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                long costBlinds = 0;
                System.out.println("Choose the type of blinds: horizontal (enter H) or vertical (enter V)");
                String horizontalOrVertical = scannerStr.nextLine();
                if (horizontalOrVertical.equalsIgnoreCase("H")) {
                    costBlinds = horizontalServiceImpl.calculateCost(requestData());
                } else if (horizontalOrVertical.equalsIgnoreCase("V")) {
                    costBlinds = verticalServiceImpl.calculateCost(requestDataVerticalBlind());
                }
                System.out.println("Horizontal blind costs " + costBlinds + " rubles.\n");
                System.out.println();
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
        System.out.println("Enter the width of the horizontal blind in mm: ");
        blindHorizontal.setWidth(scanner.nextInt());
        System.out.println("Enter the height of the horizontal blind in mm:");
        blindHorizontal.setHeight(scanner.nextInt());
        System.out.println("Enter the color number of the horizontal blind (201, 202): ");
        blindHorizontal.setColor(scanner.nextInt());
        return blindHorizontal;
    }

    private BlindVertical requestDataVerticalBlind() {
        BlindVertical blindVertical = new BlindVertical();
        System.out.println("Enter the width of the vertical blind in mm: ");
        blindVertical.setWidth(scanner.nextInt());
        System.out.println("Enter the height of the vertical blind in mm:");
        blindVertical.setHeight(scanner.nextInt());
        System.out.println("Enter the type of the vertical blind (01, 02, 03): ");
        blindVertical.setType(scanner.nextInt());
        System.out.println("Enter the color of the vertical blind (0 - white, 1 - green, 2 - yellow, 3 - blue, 4 - beige): ");
        blindVertical.setColor(verticalServiceImpl.returnColor(scanner.nextInt()));
        System.out.println("Enter the mount type of the vertical blind (0 - ceiling, 1 - wall): ");
        blindVertical.setMountType(verticalServiceImpl.returnMountType(scanner.nextInt()));
        return blindVertical;
    }
}
