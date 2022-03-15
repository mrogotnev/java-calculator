package service;

import exceptions.WrongSyntaxException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    public void inputValidation(String expression) throws WrongSyntaxException {
        Pattern pattern = Pattern.compile("\\W{2,}");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            throw new WrongSyntaxException("Недопустимое повторение символов операций");
        }
        pattern = Pattern.compile("[a-zA-Z]");
        matcher = pattern.matcher(expression);
        if (matcher.find()) {
            throw new WrongSyntaxException("Недопустимый буквенный символ");
        }
        pattern = Pattern.compile("(/0[^.])|(/0$)");
        matcher = pattern.matcher(expression);
        if (matcher.find()) {
            throw new ArithmeticException("Деление на \"0\"");
        }
        pattern = Pattern.compile("^\\D");
        matcher = pattern.matcher(expression);
        if (matcher.find()) {
            throw new WrongSyntaxException("Выражение начинается не с операнда");
        }
    }
}
