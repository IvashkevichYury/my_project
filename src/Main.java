import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BlindsCost blindsCost = new BlindsCost();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Would you like to calculate the cost of blinds?\nIf yes - enter Y, if no - enter N");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                blindsCost.showBlindCost();
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Calculation finished.");
                break;
            }
        }
    }
}
