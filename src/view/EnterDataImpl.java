package view;

import model.Blind;

import java.util.Scanner;

public class EnterDataImpl implements EnterData {

    Blind blind = new Blind();
    Scanner scanner = new Scanner(System.in);

    @Override
    public Blind requestData() {


        System.out.println("Enter the width of the blind in mm: ");
        blind.setWidth(scanner.nextInt());
        System.out.println("Enter the height of the blind in mm:");
        blind.setHeight(scanner.nextInt());
        System.out.println("Enter the color number of the blind (201, 202): ");
        blind.setColor(scanner.nextInt());
        return blind;
    }

}

