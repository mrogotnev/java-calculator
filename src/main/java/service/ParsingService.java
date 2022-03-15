package service;

import java.util.*;

public class ParsingService {
    private LinkedList<String> tmpStackForSigns = new LinkedList<>();
    private LinkedList<String> parsedExpression = new LinkedList<>();
    private HashMap<String, Integer> signAndPriority = new HashMap<>();


    public ParsingService() {
        signAndPriority.put("+", 1);
        signAndPriority.put("-", 1);
        signAndPriority.put("*", 2);
        signAndPriority.put("/", 2);
    }

    public LinkedList<String> getParsedExpression(String expression) {
        String[] arrayExpression = expression.split("(?<=[\\d.])(?=[^\\d.])|(?<=[^\\d.])(?=[\\d.])");
        for (String signOrOperator: arrayExpression) {
            try {
                Double integer = Double.parseDouble(signOrOperator);
                parsedExpression.add(signOrOperator);
            } catch (NumberFormatException ex) {
                compareOfPriorities(signOrOperator);
            }
        }
        for (int i = tmpStackForSigns.size(); i > 0; i--) {
            parsedExpression.add(tmpStackForSigns.peekLast());
            tmpStackForSigns.removeLast();
        }
        return parsedExpression;
    }

    private void compareOfPriorities(String currentSign) {
        if (tmpStackForSigns.peekLast() != null) {
            if (signAndPriority.get(currentSign) <= signAndPriority.get(tmpStackForSigns.peekLast())) {
                parsedExpression.add(tmpStackForSigns.peekLast());
                tmpStackForSigns.removeLast();
                compareOfPriorities(currentSign);
            } else {
                tmpStackForSigns.add(currentSign);
            }
        } else {
            tmpStackForSigns.add(currentSign);
        }
    }
}
