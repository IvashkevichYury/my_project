package service;

public interface PriceCatalogVertical {

    double getPriceMount();

    String getColor(int numberColor);

    String getMountType(int numberMount);

    Double getTypePrice(int type);

    double getDollarExchangeRate();
}
