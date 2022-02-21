import service.InputService;
import service.ParsingService;

import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello");
        InputService inputService = new InputService();
        //inputService.inputExpression();
        String exp = inputService.inputExpression();
        System.out.println(exp);

        ParsingService parsingService = new ParsingService();
        parsingService.getParsedExpression(exp);
    }
}
