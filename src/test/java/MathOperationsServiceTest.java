import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import service.MathOperationsService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathOperationsServiceTest {

    private static final double firstOperand = 10.2;
    private static final double secondOperand = 5;
    private static final MathOperationsService mathOperationsService = null;

    @Before
    public void init() {
        MathOperationsService mathOperationsService = new MathOperationsService();
    }

    @Test
    @DisplayName("Тест операции суммирования метода mathTransformation")
    public void mathTransformationPlusTest() {
        //assertEquals(15.5, mathOperationsService.calculate());
    }
}
