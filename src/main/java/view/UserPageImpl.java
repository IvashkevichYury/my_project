package view;

import model.BlindHorizontal;
import model.BlindVertical;
import model.Color;
import model.MountType;
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

    @Override
    public void showBlindCost() {
        File file = new File(property.getFileNameOutput());
        file.delete();
        while (true) {
            System.out.println("Would you like to calculate the cost of blinds?\nIf yes - enter Y, if no - enter N");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                long costBlinds = 0;
                System.out.println("Choose the type of blinds: horizontal (enter H) or vertical (enter V)");
                String horizontalOrVertical = scanner.nextLine();
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
                String answerSave = scanner.nextLine();
                if (answerSave.equalsIgnoreCase("S")) {
                    dataWriter.writeDataToFile(saver.getBlinds(), property.getFileNameOutput());
                }
                System.out.println("Calculation finished.");
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
            if (!line.matches("^\\d{3,4}$") || Integer.parseInt(line) < 250 || Integer.parseInt(line) > 2700) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                blindHorizontal.setWidth(Integer.parseInt(line));
                break;
            }
        }
        System.out.println("Enter the height of the horizontal blind in mm:");
        while (true) {
            String line = scanner.nextLine();
            if (!line.matches("^\\d{3,4}$") || Integer.parseInt(line) < 500 || Integer.parseInt(line) > 3000) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                blindHorizontal.setHeight(Integer.parseInt(line));
                break;
            }
        }
        System.out.println("Enter the color number of the horizontal blind (201, 202): ");
        while (true) {
            String line = scanner.nextLine();
            if (!line.matches("^\\d{3}$") || Integer.parseInt(line) < 201 || Integer.parseInt(line) > 202) {
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
            if (!line.matches("^\\d{3,4}$") || Integer.parseInt(line) < 400 || Integer.parseInt(line) > 6000) {
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
            if (!line.matches("^\\d{3,4}$") || Integer.parseInt(line) < 200 || Integer.parseInt(line) > 4000) {
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
            if (!line.matches("^\\d{1,2}$") || Integer.parseInt(line) < 1 || Integer.parseInt(line) > 3) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                type = Integer.parseInt(line);
                blindVertical.setType(type);
                break;
            }
        }
        System.out.println("Enter the color of the vertical blind (1(white), 2(green), 3(yellow), 4(blue), 5(beige)): ");
        Color[] colors = Color.values();
        int color;
        while (true) {
            String line = scanner.nextLine();
            if (!line.matches("^\\d$") || Integer.parseInt(line) < 1 || Integer.parseInt(line) > 5) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                color = Integer.parseInt(line) - 1;
                blindVertical.setColor(colors[color]);
                break;
            }
        }
        System.out.println("Enter the mount type of the vertical blind (1(ceiling), 2(wall)): ");
        MountType[] mountTypes = MountType.values();
        int mount;
        while (true) {
            String line = scanner.nextLine();
            if (!line.matches("^\\d$") || Integer.parseInt(line) < 1 || Integer.parseInt(line) > 2) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                mount = Integer.parseInt(line) - 1;
                blindVertical.setMountType(mountTypes[mount]);
                break;
            }
        }
        return blindVertical;
    }
}
