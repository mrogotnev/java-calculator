import exceptions.WrongSyntaxException;
import service.InputService;
import service.MathOperationsService;
import service.OutputService;
import service.ParsingService;

public class main {
    public static void main(String[] args) throws WrongSyntaxException {
        OutputService outputService = new OutputService();
        outputService.startMessage();

        InputService inputService = new InputService();

        ParsingService parsingService = new ParsingService();

        MathOperationsService mathOperationsService = new MathOperationsService();
        outputService.result(mathOperationsService.calculate(parsingService.getParsedExpression(inputService.inputExpression())));
    }
}
