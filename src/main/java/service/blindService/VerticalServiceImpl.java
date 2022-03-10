package service.blindService;

import model.BlindVertical;
import model.MountType;
import service.catalog.ExchangeRate;
import service.catalog.PriceCatalogVertical;

public class VerticalServiceImpl implements VerticalService {

    private final int minWidth = 400;
    private final int maxWidth = 6000;
    private final int minHeight = 200;
    private final int maxHeight = 4000;
    private BlindVertical blindVertical;
    private PriceCatalogVertical priceCatalogVertical;
    private ExchangeRate exchangeRate;
    private Validator validator;

    public VerticalServiceImpl(BlindVertical blindVertical, PriceCatalogVertical priceCatalogVertical,
                               ExchangeRate exchangeRate, Validator validator) {
        this.blindVertical = blindVertical;
        this.priceCatalogVertical = priceCatalogVertical;
        this.exchangeRate = exchangeRate;
        this.validator = validator;
    }

    private double calculateArea(int width, int height) {
        if (validator.checkInputSize(width, minWidth, maxWidth) || validator.checkInputSize(height, minHeight, maxHeight)) {
            throw new IllegalArgumentException("width must be from 400 to 6000 and height must be from 200 to 4000");
        } else if (height < 1500) {
            height = 1500;
        }
        return (width / 1000.00) * (height / 1000.00);
    }

    private double calculateCostOfMount(MountType mountType, int width) {
        double costOfMount = 0;
        double priceMount = priceCatalogVertical.getPriceMount();
        if (mountType.equals(MountType.CEILING)) {
            return costOfMount;
        } else if (mountType.equals(MountType.WALL)) {
            if (width < 2000) {
                costOfMount = priceMount * 2;
            } else if (width <= 3000) {
                costOfMount = priceMount * 3;
            } else {
                costOfMount = priceMount * 4;
            }
        }
        return costOfMount;
    }

    @Override
    public long calculateCost(BlindVertical blindVertical) {
        double area = calculateArea(blindVertical.getWidth(), blindVertical.getHeight());
        blindVertical.setArea(area);
        double priceType = priceCatalogVertical.getTypePrice(blindVertical.getType());
        double costOfMount = calculateCostOfMount(blindVertical.getMountType(), blindVertical.getWidth());
        double dollarExchangeRate = exchangeRate.getDollarExchangeRate();
        return Math.round(area * priceType * dollarExchangeRate + costOfMount * dollarExchangeRate);
    }

}
