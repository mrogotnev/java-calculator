import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import exceptions.WrongSyntaxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import service.MathOperationsService;
import java.util.*;
import java.util.stream.Stream;

public class MathOperationsServiceTest {
    private static MathOperationsService mathOperationsService;

    @BeforeAll
    public static void init() {
        mathOperationsService = new MathOperationsService();
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void calculateTests(LinkedList<String> expression, double value) throws WrongSyntaxException {
        assertThat(value, closeTo(mathOperationsService.calculate(expression), 0.01));
    }

    @Test
    public void manySignsInExpressionTest() throws WrongSyntaxException {
        Assertions.assertThrows(WrongSyntaxException.class, () -> {
            mathOperationsService.calculate(new LinkedList<String>(Arrays.asList("1", "+", "+", "1")));
        });
    }

    @Test
    public void unknowSigninExpressionTest() throws WrongSyntaxException {
        Assertions.assertThrows(WrongSyntaxException.class, () -> {
            mathOperationsService.calculate(new LinkedList<String>(Arrays.asList("2", "^", "2")));
        });
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new LinkedList<String>(Arrays.asList("1", "2", "+", "3", "4", "*", "5", "/", "-")), 0.6),
                Arguments.of(new LinkedList<String>(Arrays.asList("1", "2", "/", "3", "+", "5", "2", "*", "-")), -6.5),
                Arguments.of(new LinkedList<String>(Arrays.asList("5.6", "5.8", "+")), 11.4)
        );
    }




}

