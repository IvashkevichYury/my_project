import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.fileService.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyTest {

    Property property;

    @BeforeEach
    void setUp() {
        property = new Property();
    }

    @Test
    void getFileNameHorizontalCatalog_ShouldReturnFileName() {
        String actual = property.getFileNameHorizontalCatalog();
        String expected = ".\\src\\main\\resources\\horizontalBlindsPriceCatalog.csv";
        assertEquals(expected, actual);
    }

    @Test
    void getFileNameVerticalCatalog_ShouldReturnFileName() {
        String actual = property.getFileNameVerticalCatalog();
        String expected = ".\\src\\main\\resources\\verticalBlindsPriceCatalog.csv";
        assertEquals(expected, actual);
    }

    @Test
    void getFileNamePriceMount_ShouldReturnFileName() {
        String actual = property.getFileNamePriceMount();
        String expected = "0.27";
        assertEquals(expected, actual);
    }

    @Test
    void getFileNameDollarExchangeRate_ShouldReturnFileName() {
        String actual = property.getFileNameDollarExchangeRate();
        String expected = "15";
        assertEquals(expected, actual);
    }
}