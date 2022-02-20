package service.blindService;

public class Validator {

    public boolean checkInputNumber(String inputString, int min, int max) {
        return (!inputString.matches("^\\d{1,4}$") || Integer.parseInt(inputString) < min || Integer.parseInt(inputString) > max);
    }

    public boolean checkInputSize(int size, int min, int max) {
        return (size < min || size > max);
    }
}
