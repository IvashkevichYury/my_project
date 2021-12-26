public class CostBlinds {

    private static final double dollarExchangeRate = 15;

    AreaBlinds areaBlinds = new AreaBlinds();
    Data data = new Data();

    public long calculateCostOfBlinds(Blinds blinds) {

        long cost = Math.round(areaBlinds.findAreaBlinds(blinds) * data.determineCostOfSelectedColorOfBlinds(blinds.getColor())
                * dollarExchangeRate);

        return cost;
    }
}
