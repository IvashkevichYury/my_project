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

    BlindHorizontal blind;
    PriceCatalog catalog = new PriceCatalogImpl();
    HorizontalService horizontalBlindServiceImpl = new HorizontalServiceImpl(blind, catalog);

    @BeforeEach
    void setUp() {
        catalog.initDate();
    }

    @ParameterizedTest
    @CsvSource({"1500, 3000, 201, 594", "500, 2000, 202, 156"})
    void calculateCost_getAreaOfBlindMoreThan075_ShouldReturnCorrectCostOfBlind(int width, int height, int color, long expected) {
        blind = new BlindHorizontal(width, height, color);
        long actual = horizontalBlindServiceImpl.calculateCost(blind);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"300, 500, 201, 99", "500, 1000, 202, 117"})
    void calculateCost_getAreaOfBlindLessThan075_ShouldReturnCorrectCostOfBlind(int width, int height, int color, long expected) {
        blind = new BlindHorizontal(width, height, color);
        long actual = horizontalBlindServiceImpl.calculateCost(blind);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 3000, 201, 496", "500, 1000, 202, 78"})
    void calculateCost_getPositiveSizeAndColorOfBlind_ShouldReturnWrongCostOfBlind(int width, int height, int color, long expected) {
        blind = new BlindHorizontal(width, height, color);
        long actual = horizontalBlindServiceImpl.calculateCost(blind);
        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 0, 201", "0, 1000, 202", "-1000, 2000, 201", "500, -800, 202"})
    void calculateCost_getZeroOrNegativeSizeOfBlind_ShouldThrowIllegalArgumentException(int width, int height, int color) {
        blind = new BlindHorizontal(width, height, color);
        Exception actualException = assertThrows(IllegalArgumentException.class,
                () -> horizontalBlindServiceImpl.calculateCost(blind));
        String expectedMessage = "width must be from 250 to 2700 and height must be from 500 to 3000";
        assertEquals(expectedMessage, actualException.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1000, 2000, 200", "500, 1000, 0", "500, 1500, -201"})
    void calculateCost_getWrongColorOfBlind_ShouldThrowIllegalArgumentException(int width, int height, int color) {
        blind = new BlindHorizontal(width, height, color);
        Exception actualException = assertThrows(IllegalArgumentException.class,
                () -> horizontalBlindServiceImpl.calculateCost(blind));
        String expectedMessage = "color must be 201 or 202";
        assertEquals(expectedMessage, actualException.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1500, 3000, 201, 4.5", "500, 2000, 202, 1"})
    void calculateCost_getWidthAndHeight_ShouldReturnAreaOfBlindMoreThan075(int width, int height, int color, double expected) {
        blind = new BlindHorizontal(width, height, color);
        horizontalBlindServiceImpl.calculateCost(blind);
        double actual = blind.getAreaBlinds();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"500, 1000, 201, 0.75", "350, 2000, 202, 0.75"})
    void calculateCost_getWidthAndHeight_ShouldReturnAreaOfBlindLessThan075(int width, int height, int color, double expected) {
        blind = new BlindHorizontal(width, height, color);
        horizontalBlindServiceImpl.calculateCost(blind);
        double actual = blind.getAreaBlinds();
        assertEquals(expected, actual);
    }
}