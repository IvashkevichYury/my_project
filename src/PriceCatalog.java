import java.util.HashMap;
import java.util.Map;

public class PriceCatalog {

    private Map<Integer, Double> colorMap = new HashMap<>();

    public Map<Integer, Double> initDate() {
        colorMap.put(201, 8.8);
        colorMap.put(202, 10.4);

        return colorMap;
    }

    public Map<Integer, Double> getColorMap() {
        return colorMap;
    }
}
