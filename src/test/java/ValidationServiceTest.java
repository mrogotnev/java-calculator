import exceptions.WrongSyntaxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.ValidationService;

public class ValidationServiceTest {
    private static final ValidationService validationService = new ValidationService();

    @Test
    public void inputValidationRepeatSigns() throws WrongSyntaxException {
        Assertions.assertThrows(WrongSyntaxException.class, () -> {
            validationService.inputValidation("5++2");
        });
    }

    @Test
    public void inputValidationLettersInExpression() throws WrongSyntaxException {
        Assertions.assertThrows(WrongSyntaxException.class, () -> {
            validationService.inputValidation("5 + 2 asd");
        });

    }

    @Test
    public void inputValidationSignInStartOfExpression() throws WrongSyntaxException {
        Assertions.assertThrows(WrongSyntaxException.class, () -> {
            validationService.inputValidation("+5 2");
        });
    }

    @Test
    public void inputValidationTryZeroDiv() throws WrongSyntaxException {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            validationService.inputValidation("5/0");
        });
    }
}
