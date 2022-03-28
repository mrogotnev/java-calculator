import exceptions.WrongSyntaxException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import service.InputService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputServiceTest {
    //private static final String data = "12     34\n56 78";
    private static final String data = "++12     34\n56 78";
    private static final InputService inputService = new InputService();

    @Test
    public void inputExpressionTest() throws WrongSyntaxException {
        assertEquals("12345678", inputService.inputExpression(data));
    }
}
