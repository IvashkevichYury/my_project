package service;

public class ExchangeRateImpl implements ExchangeRate {

    private String fileNameExchangeRate;

    public ExchangeRateImpl(String fileNameExchangeRate) {
        this.fileNameExchangeRate = fileNameExchangeRate;
    }

    @Override
    public double getDollarExchangeRate() {
        return Double.parseDouble(fileNameExchangeRate);
    }
}
