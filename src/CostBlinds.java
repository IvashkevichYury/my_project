import java.util.Map;

public class CostBlinds {

    private static final double dollarExchangeRate = 15;

    AreaBlinds areaBlinds = new AreaBlinds();

    public long calculateCostOfBlinds(Blinds blinds, Map<Integer, Double> priceForColors) {

        long cost = Math.round(areaBlinds.findAreaBlinds(blinds) * priceForColors.get(blinds.getColor())
                * dollarExchangeRate);

        return cost;
    }
}
