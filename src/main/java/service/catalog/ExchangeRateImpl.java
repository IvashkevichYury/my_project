package service.catalog;

import service.fileService.Property;

public class ExchangeRateImpl implements ExchangeRate {

    private Property property;

    public ExchangeRateImpl(Property property) {
        this.property = property;
    }

    @Override
    public double getDollarExchangeRate() {
        return Double.parseDouble(property.getFileNameDollarExchangeRate());
    }
}
