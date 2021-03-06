package service;

import exceptions.WrongSyntaxException;

import java.util.Scanner;

public class InputService {

    public String inputExpression(String expression) throws WrongSyntaxException {
        ValidationService validationService = new ValidationService();
        expression = expression.replaceAll("\\s|\\t", "");
        validationService.inputValidation(expression);
        return expression;
    }

    public String consoleInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
