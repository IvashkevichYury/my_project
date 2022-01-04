package test;

import junit.runner.Version;
import model.BlindHorizontal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import service.HorizontalService;
import service.HorizontalServiceImpl;
import service.PriceCatalog;
import service.PriceCatalogImpl;

import static org.junit.jupiter.api.Assertions.*;

class HorizontalServiceImplTest {

    BlindHorizontal blind = new BlindHorizontal();
    PriceCatalog catalog = new PriceCatalogImpl();
    HorizontalService horizontalBlindServiceImpl = new HorizontalServiceImpl(blind, catalog);

    @BeforeEach
    void setUp() {
        catalog.initDate();
    }

    @ParameterizedTest
    @CsvSource({"2000, 4000, 201, 1056", "500, 2000, 202, 156"})
    void calculateCost_getSizeAndColorOfBlind_ShouldReturnCorrectCostOfBlind(int width, int height, int color, long expected) {
        blind.setWidth(width);
        blind.setHeight(height);
        blind.setColor(color);
        long actual = horizontalBlindServiceImpl.calculateCost(blind);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 3000, 201, 496", "500, 1000, 202, 78"})
    void calculateCost_getSizeAndColorOfBlind_ShouldReturnWrongCostOfBlind (int width, int height, int color, long expected) {
        blind.setWidth(width);
        blind.setHeight(height);
        blind.setColor(color);
        long actual = horizontalBlindServiceImpl.calculateCost(blind);
        assertEquals(expected, actual);
    }

}