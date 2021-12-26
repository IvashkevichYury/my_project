public class Blinds {

    private static final double dollarExchangeRate = 15;
    private final Data data = new Data();

    public void calculateCostOfBlinds(double blindsWidth, double blindsHeight, int color) {

        long cost = Math.round(findAreaBlinds(blindsWidth, blindsHeight) *
                data.determineCostOfSelectedColorOfBlinds(color) * dollarExchangeRate);
        System.out.println("Blinds costs " + cost + " rubles.\n");
    }

    private double findAreaBlinds(double blindsWidth, double blindsHeight) {
        return blindsWidth * blindsHeight;
    }
}
