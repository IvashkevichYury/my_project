import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import service.catalog.PriceCatalogHorizontal;
import service.catalog.PriceCatalogHorizontalImpl;
import service.fileService.DataReader;
import service.fileService.DataReaderImpl;
import service.fileService.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PriceCatalogHorizontalImplTest {

    DataReader reader;
    Property property;
    PriceCatalogHorizontal priceCatalogHorizontal;

    @BeforeEach
    void setUp() {
        reader = new DataReaderImpl();
        property = new Property();
        priceCatalogHorizontal = new PriceCatalogHorizontalImpl(reader, property);
    }

    @ParameterizedTest
    @CsvSource({"201, 8.8", "202, 10.4"})
    void getColorPrice_getColor_ShouldReturnCorrectColorPrice(int color, double expected) {
        double actual = priceCatalogHorizontal.getColorPrice(color);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"201, 8.0", "202, 1.4"})
    void getColorPrice_getColor_ShouldReturnWrongColorPrice(int color, double expected) {
        double actual = priceCatalogHorizontal.getColorPrice(color);
        assertNotEquals(expected, actual);
    }
}