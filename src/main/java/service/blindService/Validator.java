package service.blindService;

public class Validator {

    public boolean checkInputNumber(String inputString, int min, int max) {
        return (!inputString.matches("^\\d{1,4}$") || Integer.parseInt(inputString) < min || Integer.parseInt(inputString) > max);
    }
}
