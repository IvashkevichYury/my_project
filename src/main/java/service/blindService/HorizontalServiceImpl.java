package service.blindService;

import model.BlindHorizontal;
import service.catalog.ExchangeRate;
import service.catalog.PriceCatalogHorizontal;

public class HorizontalServiceImpl implements HorizontalService {

    private final int minWidth = 250;
    private final int maxWidth = 2700;
    private final int minHeight = 500;
    private final int maxHeight = 3000;
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
            throw new IllegalArgumentException("width must be from 250 to 2700 and height must be from 500 to 3000");
        } else {
            return Math.max((width / 1000.00) * (height / 1000.00), 0.75);
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
