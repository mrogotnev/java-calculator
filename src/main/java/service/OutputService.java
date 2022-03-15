package service;

public class OutputService {
    public void startMessage() {
        System.out.println("Программа калькулятор");
        System.out.println("Введите выражения. Допустимые операции + - * /. Запрещен ввод отрицательных чисел и скобок");
    }

    public void result(Double result) {
        System.out.println("Результат вычислений: " + result);
    }
}
