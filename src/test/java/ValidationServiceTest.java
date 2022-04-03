import exceptions.WrongSyntaxException;
import org.junit.Test;
import service.ValidationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationServiceTest {
    private static final ValidationService validationService = new ValidationService();

    @Test(expected = WrongSyntaxException.class)
    public void inputValidationRepeatSigns() throws WrongSyntaxException {
        validationService.inputValidation("5++2");
    }

    @Test(expected = WrongSyntaxException.class)
    public void inputValidationLettersInExpression() throws WrongSyntaxException {
        validationService.inputValidation("5 + 2 asd");
    }

    @Test(expected = WrongSyntaxException.class)
    public void inputValidationSignInStartOfExpression() throws WrongSyntaxException {
        validationService.inputValidation("+5 2");
    }

    @Test(expected = ArithmeticException.class)
    public void inputValidationTryZeroDiv() throws WrongSyntaxException {
        validationService.inputValidation("5/0");
    }
}
