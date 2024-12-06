import java.io.*;
import java.util.Scanner;  // Импортируем Scanner для чтения с консоли

public class FileHandler {

    // Метод для загрузки строки из файла
    public static String loadStringFromFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла для загрузки строки (по умолчанию .txt): ");
        String fileName = scanner.nextLine().trim();

        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        if (line == null) {
            System.out.println("Файл пуст или произошла ошибка чтения.");
            return null;
        }
        System.out.println("Строка успешно загружена.");
        return line;
    }

    // Метод для загрузки матрицы из файла
    public static int[][] loadMatrixFromFile() throws IOException, NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла для загрузки матрицы (по умолчанию .txt): ");
        String fileName = scanner.nextLine().trim();

        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        if (line == null || line.isEmpty()) {
            System.out.println("Файл пуст или содержит некорректные данные.");
            return null;
        }

        String[] values = line.split(" ");
        int size = values.length;
        int[][] matrix = new int[size][size];
        int rowIndex = 0;

        do {
            values = line.split(" ");
            for (int col = 0; col < values.length; col++) {
                matrix[rowIndex][col] = Integer.parseInt(values[col]);
            }
            rowIndex++;
        } while ((line = reader.readLine()) != null);

        System.out.println("Матрица успешно загружена.");
        return matrix;
    }

    // Метод для сохранения строки в файл
    public static void saveStringToFile(String data) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла для сохранения строки (по умолчанию .txt): ");
        String fileName = scanner.nextLine().trim();

        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(data);
        System.out.println("Строка сохранена в файл " + fileName);
    }

    // Метод для сохранения матрицы в файл
    public static void saveMatrixToFile(int[][] matrix) throws IOException {
        if (matrix == null) {
            System.out.println("Матрица не загружена или не введена.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла для сохранения матрицы (по умолчанию .txt): ");
        String fileName = scanner.nextLine().trim();

        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int[] row : matrix) {
            for (int value : row) {
                writer.write(value + " ");
            }
            writer.newLine();
        }
        System.out.println("Матрица сохранена в файл " + fileName);
    }
}
