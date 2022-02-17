package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    public void inputValidation(String expression) {
        Pattern pattern = Pattern.compile("\\W{2,}");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            throw new IllegalArgumentException("Недопустимое повторение символов операций");
        }
    }
}
