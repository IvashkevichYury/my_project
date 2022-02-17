import model.BlindHorizontal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.blindService.HorizontalServiceImpl;
import service.catalog.ExchangeRate;
import service.catalog.PriceCatalogHorizontal;
import service.fileService.DataReader;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HorizontalServiceImplTest {

    @Mock
    BlindHorizontal blind;
    @Mock
    DataReader dataReader;
    @Mock
    PriceCatalogHorizontal catalog;
    @Mock
    ExchangeRate exchangeRate;
    @InjectMocks
    HorizontalServiceImpl horizontalBlindServiceImpl;

    @BeforeEach
    void setUp() {
        lenient().when(catalog.getColorPrice(201)).thenReturn(8.8);
        lenient().when(catalog.getColorPrice(202)).thenReturn(10.4);
        when(exchangeRate.getDollarExchangeRate()).thenReturn(15.0);
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