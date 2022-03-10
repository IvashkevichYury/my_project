package service.blindService;

import model.BlindHorizontal;
import service.catalog.ExchangeRate;
import service.catalog.PriceCatalogHorizontal;

public class HorizontalServiceImpl implements HorizontalService {

    private final int minWidth = 250;
    private final int maxWidth = 2700;
    private final int minHeight = 500;
    private final int maxHeight = 3000;
    private final double minArea = 0.75;
    private final double converter = 1000;
    private BlindHorizontal blindHorizontal;
    private PriceCatalogHorizontal priceCatalogHorizontal;
    private ExchangeRate exchangeRate;
    private Validator validator;

    public HorizontalServiceImpl(BlindHorizontal blindHorizontal, PriceCatalogHorizontal priceCatalogHorizontal,
                                 ExchangeRate exchangeRate, Validator validator) {
        this.blindHorizontal = blindHorizontal;
        this.priceCatalogHorizontal = priceCatalogHorizontal;
        this.exchangeRate = exchangeRate;
        this.validator = validator;
    }

    private double calculateArea(int width, int height) {
        if (validator.checkInputSize(width, minWidth, maxWidth) || validator.checkInputSize(height, minHeight, maxHeight)) {
            throw new IllegalArgumentException("width must be from " + minWidth + " to " + maxWidth + " " +
                    "and height must be from " + minHeight + " to " + maxHeight);
        } else {
            return Math.max((width / converter) * (height / converter), minArea);
        }
    }

    @Override
    public long calculateCost(BlindHorizontal blindHorizontal) {
        double area = calculateArea(blindHorizontal.getWidth(), blindHorizontal.getHeight());
        blindHorizontal.setArea(area);
        double priceColor = priceCatalogHorizontal.getColorPrice(blindHorizontal.getColorNumber());
        double dollarExchangeRate = exchangeRate.getDollarExchangeRate();
        return Math.round(area * priceColor * dollarExchangeRate);
    }
}
