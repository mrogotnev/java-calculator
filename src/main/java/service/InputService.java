package service;

import exceptions.WrongSyntaxException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputService {

    public String inputExpression() throws WrongSyntaxException {
        ValidationService validationService = new ValidationService();
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        expression = expression.replaceAll("\\s|\\t", "");
        validationService.inputValidation(expression);
        return expression;
    }

}
