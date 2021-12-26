import java.util.Map;

public class CostBlinds {

    private static final double dollarExchangeRate = 15;

    AreaBlinds areaBlinds = new AreaBlinds();

    public long calculateCostOfBlinds(Blind blind, Map<Integer, Double> priceForColors) {

        long cost = Math.round(areaBlinds.findAreaBlinds(blind) * priceForColors.get(blind.getColor())
                * dollarExchangeRate);

        return cost;
    }
}
