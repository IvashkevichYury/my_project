import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import service.catalog.PriceCatalogVertical;
import service.catalog.PriceCatalogVerticalImpl;
import service.fileService.DataReader;
import service.fileService.DataReaderImpl;
import service.fileService.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PriceCatalogVerticalImplTest {

    DataReader reader;
    Property property;
    PriceCatalogVertical priceCatalogVertical;

    @BeforeEach
    void setUp() {
        reader = new DataReaderImpl();
        property = new Property();
        priceCatalogVertical = new PriceCatalogVerticalImpl(reader, property);
    }

    @ParameterizedTest
    @CsvSource({"0.27"})
    void getPriceMount_ShouldReturnCorrectPriceMount(double expected) {
        double actual = priceCatalogVertical.getPriceMount();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1.27"})
    void getPriceMount_ShouldReturnWrongPriceMount(double expected) {
        double actual = priceCatalogVertical.getPriceMount();
        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"01, 13.3", "02, 14.7", "03, 15.3"})
    void getTypePrice_ShouldReturnCorrectTypePrice(int type, double expected) {
        double actual = priceCatalogVertical.getTypePrice(type);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"01, 14.3", "02, 14.0", "03, 10.3"})
    void getTypePrice_ShouldReturnWrongTypePrice(int type, double expected) {
        double actual = priceCatalogVertical.getTypePrice(type);
        assertNotEquals(expected, actual);
    }
}