import model.BlindHorizontal;
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
    PriceCatalogVertical priceCatalogVertical = new PriceCatalogVerticalImpl(dataReader);
    VerticalService verticalService = new VerticalServiceImpl(blindVertical, priceCatalogVertical);
    private final Map<Integer, Double> typeMap = new HashMap<>();
    String fileName = ".\\\\src\\\\main\\\\resources\\\\verticalBlindsPriceCatalog.csv";

    @BeforeEach
    void setUp() {
        dataReader.readPricesFromFile(typeMap, fileName);
    }


    //    1.	Корректные данные, потолок – корректная стоимость
    @ParameterizedTest
    @CsvSource({"3000, 3000, 01, ceiling, 1796", "2000, 2000, 02, ceiling, 882", "2000, 3000, 03, ceiling, 1377"})
    void calculateCost_getCeilingType_ShouldReturnCorrectCostOfBlind
    (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertEquals(expected, actual);
    }

    //    2.	Корректные данные, потолок – неправильная стоимость
    @ParameterizedTest
    @CsvSource({"3000, 3000, 01, ceiling, 1800", "2000, 2000, 02, ceiling, 880", "2000, 3000, 03, ceiling, 1367"})
    void calculateCost_getCeilingType_ShouldReturnWrongCostOfBlind
    (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertNotEquals(expected, actual);
    }

    //3.	Корректные данные, стена, ширина до 2000 – корректная стоимость
    @ParameterizedTest
    @CsvSource({"1000, 3000, 01, wall, 607", "1200, 2000, 02, wall, 537", "1900, 3000, 03, wall, 1316"})
    void calculateCost_getWallTypeAndWidthLessThan2000_ShouldReturnCorrectCostOfBlind
    (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertEquals(expected, actual);
    }

    //4.	Корректные данные, стена, ширина от 2000 до 3000 – корректная стоимость
    @ParameterizedTest
    @CsvSource({"2000, 2000, 01, wall, 810", "2500, 3500, 02, wall, 1942", "3000, 3000, 03, wall, 2078"})
    void calculateCost_getWallTypeAndWidthMoreThan2000AndLessThan3000_ShouldReturnCorrectCostOfBlind
    (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertEquals(expected, actual);
    }

    //5.	Корректные данные, стена, ширина от 3000 – корректная стоимость
    @ParameterizedTest
    @CsvSource({"3100, 3500, 01, wall, 2181", "5000, 4000, 02, wall, 4426", "4000, 2000, 03, wall, 1852"})
    void calculateCost_getWallTypeAndWidthMoreThan3000_ShouldReturnCorrectCostOfBlind
    (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertEquals(expected, actual);
    }

    //6.	Корректные данные, стена – некорректная стоимость
    @ParameterizedTest
    @CsvSource({"1000, 3000, 01, wall, 605", "2500, 3500, 02, wall, 1940", "4000, 2000, 03, wall, 1850"})
    void calculateCost_getWallType_ShouldReturnWrongCostOfBlind
    (int width, int height, int type, String mountType, long expected) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        long actual = verticalService.calculateCost(blindVertical);
        assertNotEquals(expected, actual);
    }

    //7.	Отрицательные или нулевые значения размеров – сообщение об ошибке
    @ParameterizedTest
    @CsvSource({"0, 2000, 02, ceiling", "5000, -4000, 02, wall", "100, 3000, 03, wall"})
    void calculateCost_getIncorrectSizeOfBlind_ShouldThrowIllegalArgumentException
    (int width, int height, int type, String mountType) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        Exception actualException = assertThrows(IllegalArgumentException.class,
                () -> verticalService.calculateCost(blindVertical));
        String expectedMessage = "width must be from 400 to 6000 and height must be from 200 to 4000";
        assertEquals(expectedMessage, actualException.getMessage());
    }

    //8.	Некорректные данные цвета – сообщение об ошибке
    @ParameterizedTest
    @CsvSource({"5", "10"})
    void calculateCost_getIncorrectColorOfBlind_ShouldThrowIllegalArgumentException
    (int color) {
//        blindVertical = new BlindVertical(width, height, type, color, mountType);
        Exception actualException = assertThrows(IllegalArgumentException.class,
                () -> priceCatalogVertical.getColor(color));
        String expectedMessage = "color must be white(0), green(1), yellow(2), blue(3), beige(4)";
        assertEquals(expectedMessage, actualException.getMessage());
    }

//9.	Некорректные данные типа крепления – сообщение об ошибке


//10.	Высота меньше 1500 – корректная площадь


//11.	Высота больше 1500 – корректная площадь


}