package view;

import model.BlindHorizontal;
import model.BlindVertical;
import model.Color;
import model.MountType;
import service.blindService.DataSaver;
import service.blindService.HorizontalService;
import service.blindService.Validator;
import service.blindService.VerticalService;
import service.fileService.DataWriter;
import service.fileService.Property;

import java.util.Scanner;

public class UserPageImpl implements UserPage {

    private HorizontalService horizontalServiceImpl;
    private VerticalService verticalServiceImpl;
    private Property property;
    private DataWriter dataHorizontalWriter;
    private DataWriter dataVerticalWriter;
    private DataSaver saver;
    private Validator validator;

    public UserPageImpl(HorizontalService horizontalServiceImpl, VerticalService verticalServiceImpl,
                        Property property, DataWriter dataHorizontalWriter, DataWriter dataVerticalWriter, DataSaver saver, Validator validator) {
        this.horizontalServiceImpl = horizontalServiceImpl;
        this.verticalServiceImpl = verticalServiceImpl;
        this.property = property;
        this.dataHorizontalWriter = dataHorizontalWriter;
        this.dataVerticalWriter = dataVerticalWriter;
        this.saver = saver;
        this.validator = validator;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void showBlindCost() {
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
                    blindHorizontal.setCost(costBlinds);
                    saver.writeBlindHorizontalToList(blindHorizontal);
                    System.out.println("Horizontal blind costs " + costBlinds + " rubles.\n");
                } else if (horizontalOrVertical.equalsIgnoreCase("V")) {
                    BlindVertical blindVertical = requestDataVerticalBlind();
                    costBlinds = verticalServiceImpl.calculateCost(blindVertical);
                    blindVertical.setCost(costBlinds);
                    saver.writeBlindVerticalToList(blindVertical);
                    System.out.println("Vertical blind costs " + costBlinds + " rubles.\n");
                }
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("To save orders to a file, entered S");
                String answerSave = scanner.nextLine();
                if (answerSave.equalsIgnoreCase("S")) {
                    dataHorizontalWriter.writeDataToFile(saver.getBlindHorizontalList());
                    dataVerticalWriter.writeDataToFile(saver.getBlindVerticalList());
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
            if (validator.checkInputNumber(line, 250, 2700)) {
                System.out.println("You entered incorrect data, please enter again!\nWidth should be from 250 to 2700 mm.");
            } else {
                blindHorizontal.setWidth(Integer.parseInt(line));
                break;
            }
        }
        System.out.println("Enter the height of the horizontal blind in mm:");
        while (true) {
            String line = scanner.nextLine();
            if (validator.checkInputNumber(line, 500, 3000)) {
                System.out.println("You entered incorrect data, please enter again!\nHeight should be from 500 to 3000 mm.");
            } else {
                blindHorizontal.setHeight(Integer.parseInt(line));
                break;
            }
        }
        System.out.println("Enter the color number of the horizontal blind (201, 202): ");
        while (true) {
            String line = scanner.nextLine();
            if (validator.checkInputNumber(line, 201, 202)) {
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
            if (validator.checkInputNumber(line, 400, 6000)) {
                System.out.println("You entered incorrect data, please enter again!\nWidth should be from 400 to 6000 mm.");
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
            if (validator.checkInputNumber(line, 200, 4000)) {
                System.out.println("You entered incorrect data, please enter again!\nHeight should be from 200 to 4000 mm.");
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
            if (validator.checkInputNumber(line, 1, 3)) {
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
            if (validator.checkInputNumber(line, 1, colors.length)) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                color = Integer.parseInt(line) - 1;
                blindVertical.setColor(colors[color]);
                break;
            }
        }
        System.out.println("Enter the mount type of the vertical blind (1(ceiling), 2(wall)): ");
        int mount;
        while (true) {
            String line = scanner.nextLine();
            if (validator.checkInputNumber(line, 1, MountType.values().length)) {
                System.out.println("You entered incorrect data, please enter again!");
            } else {
                mount = Integer.parseInt(line);
                blindVertical.setMountType(MountType.getMountType(mount));
                break;
            }
        }
        return blindVertical;
    }
}
