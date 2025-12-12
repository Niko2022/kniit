package org.kniit.lab2.task3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("Введите первое число (или 'exit' для выхода): ");
            String firstInput = scanner.next(); // считывает до пробела

            if (firstInput.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы.");
                break;
            }

            double a;
            try {
                a = Double.parseDouble(firstInput);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректное число.");
                continue;
            }

            System.out.print("Введите оператор (+, -, *, /): ");
            String opInput = scanner.next();
            char op = opInput.charAt(0); // первый символ строки

            System.out.print("Введите второе число: ");
            String secondInput = scanner.next();

            double b;
            try {
                b = Double.parseDouble(secondInput);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректное число.");
                continue;
            }

            try {
                double result;
                switch (op) {
                    case '+':
                        result = calculator.add(a, b);
                        break;
                    case '-':
                        result = calculator.subtract(a, b);
                        break;
                    case '*':
                        result = calculator.multiply(a, b);
                        break;
                    case '/':
                        result = calculator.divide(a, b);
                        break;
                    default:
                        System.out.println("Ошибка: неизвестный оператор.");
                        continue;
                }
                System.out.println("Результат: " + result);
            } catch (ArithmeticException ex) {
                System.out.println(ex.getMessage());
            }
        }

        scanner.close();
    }
}
