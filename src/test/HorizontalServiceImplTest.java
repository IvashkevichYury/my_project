package test;

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
    @CsvSource({"1500, 3000, 201, 594", "500, 2000, 202, 156"})
    void calculateCost_getAreaOfBlindMoreThan075_ShouldReturnCorrectCostOfBlind(int width, int height, int color, long expected) {
        blind.setWidth(width);
        blind.setHeight(height);
        blind.setColor(color);
        long actual = horizontalBlindServiceImpl.calculateCost(blind);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"300, 500, 201, 99", "500, 1000, 202, 117"})
    void calculateCost_getAreaOfBlindLessThan075_ShouldReturnCorrectCostOfBlind(int width, int height, int color, long expected) {
        blind.setWidth(width);
        blind.setHeight(height);
        blind.setColor(color);
        long actual = horizontalBlindServiceImpl.calculateCost(blind);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 3000, 201, 496", "500, 1000, 202, 78"})
    void calculateCost_getPositiveSizeAndColorOfBlind_ShouldReturnWrongCostOfBlind(int width, int height, int color, long expected) {
        blind.setWidth(width);
        blind.setHeight(height);
        blind.setColor(color);
        long actual = horizontalBlindServiceImpl.calculateCost(blind);
        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 0, 201", "0, 1000, 202", "-1000, 2000, 201", "500, -800, 202"})
    void calculateCost_getZeroOrNegativeSizeOfBlind_ShouldThrowIllegalArgumentException(int width, int height, int color) {
        blind.setWidth(width);
        blind.setHeight(height);
        blind.setColor(color);
        assertThrows(IllegalArgumentException.class, () -> horizontalBlindServiceImpl.calculateCost(blind));
    }

    @ParameterizedTest
    @CsvSource({"1000, 200, 200", "500, 1000, 0", "500, 1500, -201"})
    void calculateCost_getWrongColorOfBlind_ShouldThrowIllegalArgumentException(int width, int height, int color) {
        blind.setWidth(width);
        blind.setHeight(height);
        blind.setColor(color);
        assertThrows(IllegalArgumentException.class, () -> horizontalBlindServiceImpl.calculateCost(blind));
    }
}