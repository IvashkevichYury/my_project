import model.BlindVertical;
import model.MountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.blindService.Validator;
import service.blindService.VerticalServiceImpl;
import service.catalog.ExchangeRate;
import service.catalog.PriceCatalogVertical;
import service.fileService.DataReader;
import service.fileService.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VerticalServiceImplExceptionTest {

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
    @Mock
    private VerticalServiceImpl verticalService;

    @BeforeEach
    void setUp() {
        lenient().when(priceCatalogVertical.getTypePrice(1)).thenReturn(13.3);
        lenient().when(priceCatalogVertical.getTypePrice(2)).thenReturn(14.7);
        lenient().when(priceCatalogVertical.getTypePrice(3)).thenReturn(15.3);
        lenient().when(priceCatalogVertical.getPriceMount()).thenReturn(0.27);
        lenient().when(exchangeRate.getDollarExchangeRate()).thenReturn(15.0);
    }

    @ParameterizedTest
    @CsvSource({"0, 2000, 02, CEILING", "5000, -4000, 02, WALL", "100, 3000, 03, WALL"})
    void calculateCost_getIncorrectSizeOfBlind_ShouldThrowIllegalArgumentException
            (int width, int height, int type, MountType mountType) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        when(verticalService.calculateCost(blindVertical))
                .thenThrow(new IllegalArgumentException("width must be from 400 to 6000 and height must be from 200 to 4000"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> verticalService.calculateCost(blindVertical));
        String actualException = exception.getMessage();
        String expectedException = "width must be from 400 to 6000 and height must be from 200 to 4000";
        assertEquals(expectedException, actualException);
    }

    @ParameterizedTest
    @CsvSource({"0, 2000, 03, CEILING", "3000, 4000, 00, WALL", "1000, 3000, -03, WALL"})
    void calculateCost_getIncorrectType_ShouldThrowIllegalArgumentException
            (int width, int height, int type, MountType mountType) {
        blindVertical = new BlindVertical(width, height, type, mountType);
        when(verticalService.calculateCost(blindVertical))
                .thenThrow(new IllegalArgumentException("type must be 01, 02 or 03"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> verticalService.calculateCost(blindVertical));
        String actualException = exception.getMessage();
        String expectedException = "type must be 01, 02 or 03";
        assertEquals(expectedException, actualException);
    }
}
