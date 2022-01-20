import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import service.*;

import static org.junit.jupiter.api.Assertions.*;

class PriceCatalogVerticalImplTest {
    DataReader dataReader = new DataReaderImpl();
    Property property = new PropertyImpl();
    PriceCatalogVertical priceCatalogVertical = new PriceCatalogVerticalImpl(dataReader, property);

    @ParameterizedTest
    @CsvSource({"5", "10"})
    void getColor_getIncorrectColorOfBlind_ShouldThrowIllegalArgumentException
            (int color) {

        Exception actualException = assertThrows(IllegalArgumentException.class,
                () -> priceCatalogVertical.getColor(color));
        String expectedMessage = "color must be white(0), green(1), yellow(2), blue(3), beige(4)";
        assertEquals(expectedMessage, actualException.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"2", "3"})
    void getMountType_getIncorrectMountType_ShouldThrowIllegalArgumentException
            (int mountType) {

        Exception actualException = assertThrows(IllegalArgumentException.class,
                () -> priceCatalogVertical.getMountType(mountType));
        String expectedMessage = "type must be ceiling(0) or wall(1)";
        assertEquals(expectedMessage, actualException.getMessage());
    }
}