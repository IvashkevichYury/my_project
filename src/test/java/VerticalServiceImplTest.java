import model.BlindVertical;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import service.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VerticalServiceImplTest {
    BlindVertical blindVertical;
    DataReader dataReader = new DataReaderImpl();
    Property property = new PropertyImpl();
    ExchangeRate exchangeRate = new ExchangeRateImpl();
    PriceCatalogVertical priceCatalogVertical = new PriceCatalogVerticalImpl(dataReader);
    VerticalService verticalService = new VerticalServiceImpl(blindVertical, priceCatalogVertical, exchangeRate);
    Map<String, String> propertiesMap = new HashMap<>();

    @BeforeEach
    void setUp() {
//        propertiesMap = property.saveProperties(".\\src\\main\\resources\\application.properties");
    }

    @ParameterizedTest
    @CsvSource({"3000, 3000, 01, ceiling, 1796", "2000, 2000, 02, ceiling, 882", "2000, 3000, 03, ceiling, 1377"})
    void calculateCost_getCeilingType_ShouldReturnCorrectCostOfBlind
            (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical, property.getValueProperties("verticalCatalog"), property.getValueProperties("priceMount"), property.getValueProperties("dollarExchangeRate"));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"3000, 3000, 01, ceiling, 1800", "2000, 2000, 02, ceiling, 880", "2000, 3000, 03, ceiling, 1367"})
    void calculateCost_getCeilingType_ShouldReturnWrongCostOfBlind
            (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical, property.getValueProperties("verticalCatalog"), property.getValueProperties("priceMount"), property.getValueProperties("dollarExchangeRate"));
        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 3000, 01, wall, 607", "1200, 2000, 02, wall, 537", "1900, 3000, 03, wall, 1316"})
    void calculateCost_getWallTypeAndWidthLessThan2000_ShouldReturnCorrectCostOfBlind
            (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical, property.getValueProperties("verticalCatalog"), property.getValueProperties("priceMount"), property.getValueProperties("dollarExchangeRate"));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"2000, 2000, 01, wall, 810", "2500, 3500, 02, wall, 1942", "3000, 3000, 03, wall, 2078"})
    void calculateCost_getWallTypeAndWidthMoreThan2000AndLessThan3000_ShouldReturnCorrectCostOfBlind
            (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical, property.getValueProperties("verticalCatalog"), property.getValueProperties("priceMount"), property.getValueProperties("dollarExchangeRate"));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"3100, 3500, 01, wall, 2181", "5000, 4000, 02, wall, 4426", "4000, 2000, 03, wall, 1852"})
    void calculateCost_getWallTypeAndWidthMoreThan3000_ShouldReturnCorrectCostOfBlind
            (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical, property.getValueProperties("verticalCatalog"), property.getValueProperties("priceMount"), property.getValueProperties("dollarExchangeRate"));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 3000, 01, wall, 605", "2500, 3500, 02, wall, 1940", "4000, 2000, 03, wall, 1850"})
    void calculateCost_getWallType_ShouldReturnWrongCostOfBlind
            (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical, property.getValueProperties("verticalCatalog"), property.getValueProperties("priceMount"), property.getValueProperties("dollarExchangeRate"));
        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"0, 2000, 02, ceiling", "5000, -4000, 02, wall", "100, 3000, 03, wall"})
    void calculateCost_getIncorrectSizeOfBlind_ShouldThrowIllegalArgumentException
            (int width, int height, int type, String mountType) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        Exception actualException = assertThrows(IllegalArgumentException.class,
                () -> verticalService.calculateCost(blindVertical, property.getValueProperties("verticalCatalog"), property.getValueProperties("priceMount"), property.getValueProperties("dollarExchangeRate")));
        String expectedMessage = "width must be from 400 to 6000 and height must be from 200 to 4000";
        assertEquals(expectedMessage, actualException.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1000, 400, 01, ceiling, 1.5", "2000, 1000, 02, wall, 3", "1500, 1200, 03, wall, 2.25"})
    void calculateCost_getHeightLessThan1500_ShouldReturnCorrectAreaOfBlind
            (int width, int height, int type, String mountType, double expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        verticalService.calculateCost(blindVertical, property.getValueProperties("verticalCatalog"), property.getValueProperties("priceMount"), property.getValueProperties("dollarExchangeRate"));
        double actual = blindVertical.getAreaBlinds();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 2000, 01, ceiling, 2", "3000, 3000, 02, wall, 9", "4000, 2500, 03, wall, 10"})
    void calculateCost_getHeightMoreThan1500_ShouldReturnCorrectAreaOfBlind
            (int width, int height, int type, String mountType, double expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        verticalService.calculateCost(blindVertical, property.getValueProperties("verticalCatalog"), property.getValueProperties("priceMount"), property.getValueProperties("dollarExchangeRate"));
        double actual = blindVertical.getAreaBlinds();
        assertEquals(expected, actual);
    }
}