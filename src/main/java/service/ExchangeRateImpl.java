package service;

public class ExchangeRateImpl implements ExchangeRate {

//    private String fileNameExchangeRate;
    private Property property;

    public ExchangeRateImpl(/*String fileNameExchangeRate, */Property property) {
//        this.fileNameExchangeRate = fileNameExchangeRate;
        this.property = property;
    }

    @Override
    public double getDollarExchangeRate() {
        return Double.parseDouble(property.getProperty("dollarExchangeRate"));
    }
}
