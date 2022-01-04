package testing;

import model.BlindHorizontal;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import service.HorizontalService;
import service.HorizontalServiceImpl;
import service.PriceCatalog;
import service.PriceCatalogImpl;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class TestService {

    BlindHorizontal blind = new BlindHorizontal();
    PriceCatalog catalog = new PriceCatalogImpl();
    HorizontalService horizontalBlindServiceImpl = new HorizontalServiceImpl(blind, catalog);
    int width;
    int height;
    int color;
    double expResultColorPrice;
    long expResultCost;

    public TestService(int width, int height, int color, double expResultColorPrice, long expResultCost) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.expResultColorPrice = expResultColorPrice;
        this.expResultCost = expResultCost;
    }

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{{2000, 4000, 201, 8.8, 1056}, {500, 2000, 202, 10.4, 156}});
    }

    @Before
    public void setUp() {
        catalog.initDate();
    }

    @org.junit.Test
    public void testGetColorPrice() {
        blind.setColor(color);
        assertEquals(expResultColorPrice, catalog.getColorPrice(blind.getColor()));
    }

    @org.junit.Test
    public void testCalculateCost() {

        blind.setWidth(width);
        blind.setHeight(height);
        blind.setColor(color);
        assertEquals(expResultCost, horizontalBlindServiceImpl.calculateCost(blind));

    }
}
