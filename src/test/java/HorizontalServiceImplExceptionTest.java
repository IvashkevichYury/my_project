import model.BlindHorizontal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.blindService.HorizontalServiceImpl;
import service.blindService.Validator;
import service.catalog.ExchangeRate;
import service.catalog.PriceCatalogHorizontal;
import service.fileService.DataReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HorizontalServiceImplExceptionTest {

    @Mock
    BlindHorizontal blind;
    @Mock
    DataReader dataReader;
    @Mock
    PriceCatalogHorizontal catalog;
    @Mock
    ExchangeRate exchangeRate;
    @Mock
    Validator validator;
    @Mock
    HorizontalServiceImpl horizontalBlindServiceImpl;

    @BeforeEach
    void setUp() {
        lenient().when(catalog.getColorPrice(201)).thenReturn(8.8);
        lenient().when(catalog.getColorPrice(202)).thenReturn(10.4);
        lenient().when(exchangeRate.getDollarExchangeRate()).thenReturn(15.0);
    }

    @ParameterizedTest
    @CsvSource({"1000, 0, 201", "0, 1000, 202", "-1000, 2000, 201", "500, -800, 202"})
    void calculateCost_getZeroOrNegativeSizeOfBlind_ShouldThrowIllegalArgumentException(int width, int height, int color) {
        blind = new BlindHorizontal(width, height, color);
        when(horizontalBlindServiceImpl.calculateCost(blind))
                .thenThrow(new IllegalArgumentException("width must be from 250 to 2700 and height must be from 500 to 3000"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> horizontalBlindServiceImpl.calculateCost(blind));
        String actualException = exception.getMessage();
        String expectedException = "width must be from 250 to 2700 and height must be from 500 to 3000";
        assertEquals(expectedException, actualException);
    }

    @ParameterizedTest
    @CsvSource({"1000, 2000, 200", "500, 1000, 0", "500, 1500, -201"})
    void calculateCost_getWrongColorOfBlind_ShouldThrowIllegalArgumentException(int width, int height, int color) {
        blind = new BlindHorizontal(width, height, color);
        when(horizontalBlindServiceImpl.calculateCost(blind))
                .thenThrow(new IllegalArgumentException("color number must be 201 or 202"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> horizontalBlindServiceImpl.calculateCost(blind));
        String actualException = exception.getMessage();
        String expectedException = "color number must be 201 or 202";
        assertEquals(expectedException, actualException);
    }
}
