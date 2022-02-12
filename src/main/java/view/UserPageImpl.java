package view;

import model.BlindHorizontal;
import model.BlindVertical;
import service.blindService.DataSaver;
import service.blindService.HorizontalService;
import service.blindService.VerticalService;
import service.fileService.DataWriter;
import service.fileService.DataWriterImpl;
import service.fileService.Property;

import java.io.File;
import java.util.Scanner;

public class UserPageImpl implements UserPage {

    private HorizontalService horizontalServiceImpl;
    private VerticalService verticalServiceImpl;
    private Property property;
    private DataWriter dataWriter = new DataWriterImpl();
    private DataSaver saver = new DataSaver();

    public UserPageImpl(HorizontalService horizontalServiceImpl, VerticalService verticalServiceImpl, Property property) {
        this.horizontalServiceImpl = horizontalServiceImpl;
        this.verticalServiceImpl = verticalServiceImpl;
        this.property = property;
    }

    Scanner scanner = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    @Override
    public void showBlindCost() {
        File file = new File(property.getFileNameOutput());
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
                    saver.writeDataToList(blindHorizontal);
                    System.out.println("Horizontal blind costs " + costBlinds + " rubles.\n");
                } else if (horizontalOrVertical.equalsIgnoreCase("V")) {
                    BlindVertical blindVertical = requestDataVerticalBlind();
                    costBlinds = verticalServiceImpl.calculateCost(blindVertical);
                    blindVertical.setBlindsCost(costBlinds);
                    saver.writeDataToList(blindVertical);
                    System.out.println("Vertical blind costs " + costBlinds + " rubles.\n");
                }
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("To save orders to a file, entered S");
                String answerSave = scannerStr.nextLine();
                if (answerSave.equalsIgnoreCase("S")) {
                    dataWriter.writeDataToFile(saver.getBlinds(), property.getFileNameOutput());
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
        while (true) {
            String line = scanner.nextLine();
            if (!line.matches("^-?\\d+$") || Integer.parseInt(line) < 250 || Integer.parseInt(line) > 2700) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                blindHorizontal.setWidth(Integer.parseInt(line));
                break;
            }
        }
        System.out.println("Enter the height of the horizontal blind in mm:");
        while (true) {
            String line = scanner.nextLine();
            if (!line.matches("^-?\\d+$") || Integer.parseInt(line) < 500 || Integer.parseInt(line) > 3000) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                blindHorizontal.setHeight(Integer.parseInt(line));
                break;
            }
        }
        System.out.println("Enter the color number of the horizontal blind (201, 202): ");
        while (true) {
            String line = scanner.nextLine();
            if (!line.matches("^-?\\d+$") || Integer.parseInt(line) < 201 || Integer.parseInt(line) > 202) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                blindHorizontal.setColorNumber(Integer.parseInt(line));
                break;
            }
        }
        return blindHorizontal;
    }

    private BlindVertical requestDataVerticalBlind() {
        BlindVertical blindVertical = new BlindVertical();
        System.out.println("Enter the width of the vertical blind in mm: ");
        int width;
        while (true) {
            String line = scanner.nextLine();
            if (!line.matches("^-?\\d+$") || Integer.parseInt(line) < 400 || Integer.parseInt(line) > 6000) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                width = Integer.parseInt(line);
                blindVertical.setWidth(width);
                break;
            }
        }
        System.out.println("Enter the height of the vertical blind in mm:");
        int height;
        while (true) {
            String line = scanner.nextLine();
            if (!line.matches("^-?\\d+$") || Integer.parseInt(line) < 200 || Integer.parseInt(line) > 4000) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                height = Integer.parseInt(line);
                blindVertical.setHeight(height);
                break;
            }
        }
        System.out.println("Enter the type of the vertical blind (01, 02, 03): ");
        int type;
        while (true) {
            String line = scanner.nextLine();
            if (!line.matches("^-?\\d+$") || Integer.parseInt(line) < 1 || Integer.parseInt(line) > 3) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                type = Integer.parseInt(line);
                blindVertical.setType(type);
                break;
            }
        }
        System.out.println("Enter the color of the vertical blind (white, green, yellow, blue, beige): ");
        String[] colors = {"white", "green", "yellow", "blue", "beige"};
        String color;
        while (true) {
            color = scanner.nextLine();
            int count = 0;
            for (String s : colors) {
                if (color.equalsIgnoreCase(s)) {
                    count++;
                }
            }
            if (color.matches("^-?\\d+$") || count == 0) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                blindVertical.setColor(color);
                break;
            }
        }
        System.out.println("Enter the mount type of the vertical blind (ceiling, wall): ");
        String[] mounts = {"ceiling", "wall"};
        String mount;
        while (true) {
            mount = scanner.nextLine();
            int count = 0;
            for (String s : mounts) {
                if (mount.equalsIgnoreCase(s)) {
                    count++;
                }
            }
            if (mount.matches("^-?\\d+$") || count == 0) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                blindVertical.setMountType(mount);
                break;
            }
        }
        return blindVertical;
    }
}
