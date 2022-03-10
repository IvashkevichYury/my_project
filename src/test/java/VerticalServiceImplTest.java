import model.BlindVertical;
import model.MountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.blindService.Validator;
import service.blindService.VerticalServiceImpl;
import service.catalog.ExchangeRate;
import service.catalog.PriceCatalogVertical;
import service.fileService.DataReader;
import service.fileService.Property;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VerticalServiceImplTest {

    @Mock
    private BlindVertical blindVertical;
    @Mock
    private DataReader dataReader;
    @Mock
    private Property property;
    @Mock
    private ExchangeRate exchangeRate;
    @Mock
    private PriceCatalogVertical priceCatalogVertical;
    @Mock
    private Validator validator;
    @InjectMocks
    private VerticalServiceImpl verticalService;

    @BeforeEach
    void setUp() {
        lenient().when(priceCatalogVertical.getTypePrice(1)).thenReturn(13.3);
        lenient().when(priceCatalogVertical.getTypePrice(2)).thenReturn(14.7);
        lenient().when(priceCatalogVertical.getTypePrice(3)).thenReturn(15.3);
        when(priceCatalogVertical.getPriceMount()).thenReturn(0.27);
        when(exchangeRate.getDollarExchangeRate()).thenReturn(15.0);
    }

    @ParameterizedTest
    @CsvSource({"3000, 3000, 01, CEILING, 1796", "2000, 2000, 02, CEILING, 882", "2000, 3000, 03, CEILING, 1377"})
    void calculateCost_getCeilingType_ShouldReturnCorrectCostOfBlind
            (int width, int height, int type, MountType mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"3000, 3000, 01, CEILING, 1800", "2000, 2000, 02, CEILING, 880", "2000, 3000, 03, CEILING, 1367"})
    void calculateCost_getCeilingType_ShouldReturnWrongCostOfBlind
            (int width, int height, int type, MountType mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 3000, 01, WALL, 607", "1200, 2000, 02, WALL, 537", "1900, 3000, 03, WALL, 1316"})
    void calculateCost_getWallTypeAndWidthLessThan2000_ShouldReturnCorrectCostOfBlind
            (int width, int height, int type, MountType mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"2000, 2000, 01, WALL, 810", "2500, 3500, 02, WALL, 1942", "3000, 3000, 03, WALL, 2078"})
    void calculateCost_getWallTypeAndWidthMoreThan2000AndLessThan3000_ShouldReturnCorrectCostOfBlind
            (int width, int height, int type, MountType mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"3100, 3500, 01, WALL, 2181", "5000, 4000, 02, WALL, 4426", "4000, 2000, 03, WALL, 1852"})
    void calculateCost_getWallTypeAndWidthMoreThan3000_ShouldReturnCorrectCostOfBlind
            (int width, int height, int type, MountType mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 3000, 01, WALL, 605", "2500, 3500, 02, WALL, 1940", "4000, 2000, 03, WALL, 1850"})
    void calculateCost_getWallType_ShouldReturnWrongCostOfBlind
            (int width, int height, int type, MountType mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 400, 01, CEILING, 1.5", "2000, 1000, 02, WALL, 3", "1500, 1200, 03, WALL, 2.25"})
    void calculateCost_getHeightLessThan1500_ShouldReturnCorrectAreaOfBlind
            (int width, int height, int type, MountType mountType, double expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        verticalService.calculateCost(blindVertical);
        double actual = blindVertical.getArea();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 2000, 01, CEILING, 2", "3000, 3000, 02, WALL, 9", "4000, 2500, 03, WALL, 10"})
    void calculateCost_getHeightMoreThan1500_ShouldReturnCorrectAreaOfBlind
            (int width, int height, int type, MountType mountType, double expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        verticalService.calculateCost(blindVertical);
        double actual = blindVertical.getArea();
        assertEquals(expected, actual);
    }
}
