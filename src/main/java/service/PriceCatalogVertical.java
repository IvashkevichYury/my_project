package service;

public interface PriceCatalogVertical {

    double getPriceMount(String fileName);

    Double getTypePrice(int type, String fileName);
}
