import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import service.blindService.Validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {

    Validator validator = new Validator();

    @ParameterizedTest
    @CsvSource({"1000, 500, 4000", "2000, 1000, 3000"})
    void checkInputNumber_getNumber_ShouldReturnFalse(String inputString, int min, int max) {

        boolean actual = validator.checkInputNumber(inputString, min, max);
        assertFalse(actual);
    }

    @ParameterizedTest
    @CsvSource({"100, 500, 3000", "1000, 2000, 3000", "0, 1000, 2000"})
    void checkInputNumber_getNumber_ShouldReturnTrue(String inputString, int min, int max) {

        boolean actual = validator.checkInputNumber(inputString, min, max);
        assertTrue(actual);
    }

    @ParameterizedTest
    @CsvSource({"1000, 500, 4000", "2000, 1000, 3000"})
    void checkInputSize_getNumber_ShouldReturnFalse(int inputString, int min, int max) {

        boolean actual = validator.checkInputSize(inputString, min, max);
        assertFalse(actual);
    }

    @ParameterizedTest
    @CsvSource({"100, 500, 3000", "1000, 2000, 3000", "3000, 1000, 2000"})
    void checkInputSize_getNumber_ShouldReturnTrue(int inputString, int min, int max) {

        boolean actual = validator.checkInputSize(inputString, min, max);
        assertTrue(actual);
    }
}