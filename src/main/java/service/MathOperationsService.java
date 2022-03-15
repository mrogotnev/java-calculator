package service;

import exceptions.WrongSyntaxException;

import java.util.LinkedList;

public class MathOperationsService {
    public Double calculate(LinkedList<String> expression) throws WrongSyntaxException {
        LinkedList<Double> stackWithResult = new LinkedList();
        while (!expression.isEmpty()){
            try {
                Double aDouble = Double.parseDouble(expression.getFirst());
                stackWithResult.add(aDouble);
                expression.removeFirst();
            } catch (NumberFormatException ex) {
                if (stackWithResult.size() < 2) {
                    throw new WrongSyntaxException("Слишком много операндов");
                }
                Double rightOperator = Double.parseDouble(String.valueOf(stackWithResult.getLast()));
                stackWithResult.removeLast();
                Double leftOperator = Double.parseDouble(String.valueOf(stackWithResult.getLast()));
                stackWithResult.removeLast();
                stackWithResult.add(mathTransformation(rightOperator, leftOperator, expression.getFirst()));
                expression.removeFirst();
            }
        }
        return stackWithResult.getLast();
    }

    private Double mathTransformation(Double rightOperator, Double leftOperator, String currentSign) throws WrongSyntaxException {
        switch (currentSign) {
            case ("+"):
                return leftOperator + rightOperator;
            case ("-"):
                return leftOperator - rightOperator;
            case ("*"):
                return leftOperator * rightOperator;
            case ("/"):
                return leftOperator / rightOperator;
        }
        throw new WrongSyntaxException("Неизвестный знак");
    }
}
