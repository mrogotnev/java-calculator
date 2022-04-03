import org.junit.Before;
import org.junit.Test;
import service.ParsingService;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParsingServiceTest {
    private static final ParsingService parsingService = new ParsingService();
    private static final String incomeData = "1+2-3*4/5";
    private LinkedList<String> expectedExpression;

    @Before
    public void init() {
        expectedExpression = new LinkedList<>(Arrays.asList("1", "2", "+", "3", "4", "*", "5", "/", "-"));
    }

    @Test
    public void getParsedExpressionTest() {
        assertEquals(expectedExpression, parsingService.getParsedExpression(incomeData));
    }
}
