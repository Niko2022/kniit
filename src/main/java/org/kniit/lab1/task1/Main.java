package org.kniit.lab1.task1;

public class Main {
    static void main(String[] args) {
        String line = "";

        for (int i = 1; i <= 100; i++) {
            // Добавляем число
            line += i;

            // Добавляем запятую, если не последнее число
            if (i < 100) {
                line = line + ",";
            }

            // Переходим на новую строку каждые 10 чисел
            if (i % 10 == 0) {
                line = line + "\n";
            }
        }

        System.out.println(line);
    }
}
