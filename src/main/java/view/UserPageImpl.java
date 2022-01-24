package view;

import model.BlindHorizontal;
import model.BlindVertical;
import service.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class UserPageImpl implements UserPage {

    private HorizontalService horizontalServiceImpl;
    private VerticalService verticalServiceImpl;
    private DataWriter dataWriter = new DataWriterImpl();
    Properties properties = new Properties();

    public UserPageImpl(HorizontalService horizontalServiceImpl, VerticalService verticalServiceImpl) {
        this.horizontalServiceImpl = horizontalServiceImpl;
        this.verticalServiceImpl = verticalServiceImpl;
        try {
            properties.load(new FileInputStream(".\\src\\main\\resources\\application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Scanner scanner = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    @Override
    public void showBlindCost() {
        String verticalCatalog = properties.getProperty("verticalCatalog");
        String horizontalCatalog = properties.getProperty("horizontalCatalog");
        String outputFile = properties.getProperty("outputFile");
        String priceMount = properties.getProperty("priceMount");
        String dollarExchangeRate = properties.getProperty("dollarExchangeRate");
        File file = new File(outputFile);
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
                    costBlinds = horizontalServiceImpl.calculateCost(blindHorizontal, horizontalCatalog, dollarExchangeRate);
                    blindHorizontal.setBlindsCost(costBlinds);
                    dataWriter.writeDataToList(blindHorizontal);
                    System.out.println("Horizontal blind costs " + costBlinds + " rubles.\n");
                } else if (horizontalOrVertical.equalsIgnoreCase("V")) {
                    BlindVertical blindVertical = requestDataVerticalBlind();
                    costBlinds = verticalServiceImpl.calculateCost(blindVertical, verticalCatalog, priceMount, dollarExchangeRate);
                    blindVertical.setBlindsCost(costBlinds);
                    dataWriter.writeDataToList(blindVertical);
                    System.out.println("Vertical blind costs " + costBlinds + " rubles.\n");
                }
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("To save orders to a file, entered S");
                String answerSave = scannerStr.nextLine();
                if (answerSave.equalsIgnoreCase("S")) {
                    dataWriter.writeDataToFile(outputFile);
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
