import java.util.HashMap;
import java.util.Map;

public class Data {

    private Map<Integer, Double> colorMap = new HashMap<>();
    private double priceForColors;

    public double determineCostOfSelectedColorOfBlinds(int color) {

        initDate();
        try {
            priceForColors = colorMap.get(color);
        } catch (NullPointerException e) {
            System.out.println("The selected color doesn't exist!");
        }
        return priceForColors;
    }

    private void initDate() {
        colorMap.put(201, 8.8);
        colorMap.put(202, 10.4);
    }
}
