package view;

import model.BlindHorizontal;
import model.BlindVertical;
import service.*;

import java.io.File;
import java.util.Scanner;

public class UserPageImpl implements UserPage {

    private HorizontalService horizontalServiceImpl;
    private VerticalService verticalServiceImpl;
    private Property property;
    private DataWriter dataWriter = new DataWriterImpl();
//    String outputFile;

    public UserPageImpl(HorizontalService horizontalServiceImpl, VerticalService verticalServiceImpl, Property property/* String outputFile*/) {
        this.horizontalServiceImpl = horizontalServiceImpl;
        this.verticalServiceImpl = verticalServiceImpl;
        this.property = property;
//        this.outputFile = outputFile;
    }

    Scanner scanner = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    @Override
    public void showBlindCost() {
        File file = new File(property.getProperty("outputFile"));
        file.delete();
        while (true) {
            System.out.println("Would you like to calculate the cost of blinds?\nIf yes - enter Y, if no - enter N");
            String answer = scannerStr.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                long costBlinds = 0;
                System.out.println("Choose the type of blinds: horizontal (enter H) or vertical (enter V)");
                String horizontalOrVertical = scannerStr.nextLine();
                if (horizontalOrVertical.equalsIgnoreCase("H")) {
                    BlindHorizontal blindHorizontal = requestDataHorizontalBlind();
                    costBlinds = horizontalServiceImpl.calculateCost(blindHorizontal);
                    blindHorizontal.setBlindsCost(costBlinds);
                    dataWriter.writeDataToList(blindHorizontal);
                    System.out.println("Horizontal blind costs " + costBlinds + " rubles.\n");
                } else if (horizontalOrVertical.equalsIgnoreCase("V")) {
                    BlindVertical blindVertical = requestDataVerticalBlind();
                    costBlinds = verticalServiceImpl.calculateCost(blindVertical);
                    blindVertical.setBlindsCost(costBlinds);
                    dataWriter.writeDataToList(blindVertical);
                    System.out.println("Vertical blind costs " + costBlinds + " rubles.\n");
                }
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("To save orders to a file, entered S");
                String answerSave = scannerStr.nextLine();
                if (answerSave.equalsIgnoreCase("S")) {
                    dataWriter.writeDataToFile(property.getProperty("outputFile"));
                }
                System.out.println("Calculation finished.");
                scannerStr.close();
                scanner.close();
                break;
            }
        }
    }

    private BlindHorizontal requestDataHorizontalBlind() {
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
        System.out.println("Enter the color of the vertical blind (white, green, yellow, blue, beige): ");
        blindVertical.setColor(scannerStr.nextLine());
        System.out.println("Enter the mount type of the vertical blind (ceiling, wall): ");
        blindVertical.setMountType(scannerStr.nextLine());
        return blindVertical;
    }
}
