import java.io.IOException;
import java.util.Scanner;

public class MenuHandler {
    private String currentString;
    private int[][] currentMatrix;

    // Конструктор с параметрами для строки и матрицы
    public MenuHandler(String currentString, int[][] currentMatrix) {
        this.currentString = currentString;
        this.currentMatrix = currentMatrix;
    }

    // Конструктор без параметров
    public MenuHandler() {
        this.currentString = "";
        this.currentMatrix = null;
    }

    // Главный метод меню
    public void displayMenu() {
        while (true) {
            printMenu();
            int choice = getIntInput("Выберите действие: ");
            switch (choice) {
                case 1:
                    loadStringFromFile();
                    break;
                case 2:
                    loadMatrixFromFile();
                    break;
                case 3:
                    inputStringManually();
                    break;
                case 4:
                    inputMatrixManually();
                    break;
                case 5:
                    replaceVowelsInString();
                    break;
                case 6:
                    sumDiagonalsInMatrix();
                    break;
                case 7:
                    findMostFrequentElementInMatrix();
                    break;
                case 8:
                    calculateGeometricMean();
                    break;
                case 9:
                    saveStringToFile();
                    break;
                case 10:
                    saveMatrixToFile();
                    break;
                case 11:
                    printCurrentData();
                    break;
                case 0:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    // Печать меню
    private void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Загрузить строку из файла");
        System.out.println("2. Загрузить матрицу из файла");
        System.out.println("3. Ввести строку вручную");
        System.out.println("4. Ввести матрицу вручную");
        System.out.println("5. (Задача A) Заменить гласные в строке");
        System.out.println("6. (Задача B) Суммировать элементы на диагоналях матрицы");
        System.out.println("7. (Задача C) Найти наиболее частый элемент в матрице");
        System.out.println("8. (Задача D) Вычислить геометрическое среднее для матрицы");
        System.out.println("9. Сохранить строку в файл");
        System.out.println("10. Сохранить матрицу в файл");
        System.out.println("11. Показать текущую строку и матрицу");
        System.out.println("0. Выйти");
    }

    // Получить ввод от пользователя
    private int getIntInput(String prompt) {
        int value = -1;
        while (true) {
            System.out.print(prompt);
            try {
                value = new Scanner(System.in).nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ошибка: введите целое число.");
                new Scanner(System.in).next();  // Очищаем неверный ввод
            }
        }
        return value;
    }

    // Загрузка строки из файла
    private void loadStringFromFile() {
        try {
            currentString = FileHandler.loadStringFromFile();
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке строки: " + e.getMessage());
        }
    }

    // Загрузка матрицы из файла
    private void loadMatrixFromFile() {
        try {
            currentMatrix = FileHandler.loadMatrixFromFile();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при загрузке матрицы: " + e.getMessage());
        }
    }

    // Ввод строки вручную
    private void inputStringManually() {
        System.out.print("Введите строку: ");
        currentString = new Scanner(System.in).nextLine();
    }

    // Ввод матрицы вручную
    private void inputMatrixManually() {
        int size = getIntInput("Введите размерность матрицы: ");
        while (size <= 0) {
            System.out.println("Ошибка: размерность матрицы должна быть положительным числом. Попробуйте снова.");
            size = getIntInput("Введите размерность матрицы: ");
        }
        currentMatrix = new int[size][size];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                currentMatrix[i][j] = getIntInput("Введите элемент матрицы [" + (i + 1) + "][" + (j + 1) + "]: ");
            }
        }
    }

    // Заменить гласные в строке
    private void replaceVowelsInString() {
        if (currentString == null || currentString.isEmpty()) {
            System.out.println("Ошибка: строка не введена.");
        } else {
            currentString = StringProcessor.replaceVowels(currentString); // Используем StringProcessor
            System.out.println("Строка после замены гласных: " + currentString);
        }
    }

    // Суммировать элементы на диагоналях матрицы
    private void sumDiagonalsInMatrix() {
        if (currentMatrix == null) {
            System.out.println("Ошибка: матрица не введена.");
        } else {
            int sum = MatrixProcessor.sumDiagonals(currentMatrix);
            System.out.println("Сумма элементов на диагоналях: " + sum);
        }
    }

    // Найти наиболее частый элемент в матрице
    private void findMostFrequentElementInMatrix() {
        if (currentMatrix == null) {
            System.out.println("Ошибка: матрица не введена.");
        } else {
            int mostFrequent = MatrixProcessor.findMostFrequentElement(currentMatrix);
            System.out.println("Наиболее частый элемент в матрице: " + mostFrequent);
        }
    }

    // Вычислить геометрическое среднее для матрицы
    private void calculateGeometricMean() {
        if (currentMatrix == null) {
            System.out.println("Ошибка: матрица не введена.");
        } else {
            Double geometricMean = MatrixProcessor.calculateGeometricMean(currentMatrix);
            if (geometricMean != null) {
                System.out.println("Геометрическое среднее: " + geometricMean);
            }
        }
    }

    // Сохранить строку в файл
    private void saveStringToFile() {
        if (currentString == null || currentString.isEmpty()) {
            System.out.println("Ошибка: строка не введена.");
        } else {
            try {
                FileHandler.saveStringToFile(currentString);
            } catch (IOException e) {
                System.out.println("Ошибка при сохранении строки в файл: " + e.getMessage());
            }
        }
    }

    // Сохранить матрицу в файл
    private void saveMatrixToFile() {
        if (currentMatrix == null) {
            System.out.println("Ошибка: матрица не введена.");
        } else {
            try {
                FileHandler.saveMatrixToFile(currentMatrix);
            } catch (IOException e) {
                System.out.println("Ошибка при сохранении матрицы в файл: " + e.getMessage());
            }
        }
    }

    // Показать текущую строку и матрицу
    private void printCurrentData() {
        if (currentString != null && !currentString.isEmpty()) {
            System.out.println("Текущая строка: " + currentString);
        } else {
            System.out.println("Строка не введена.");
        }

        if (currentMatrix != null) {
            System.out.println("Текущая матрица:");
            for (int[] row : currentMatrix) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Матрица не введена.");
        }
    }
}
