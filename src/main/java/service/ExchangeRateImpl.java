package service;

public class ExchangeRateImpl implements ExchangeRate {

    @Override
    public double getDollarExchangeRate(String fileName) {
        return Double.parseDouble(fileName);
    }
}
