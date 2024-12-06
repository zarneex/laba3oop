public class StringProcessor {

    private String input;

    // Конструктор без параметров
    public StringProcessor() {
        this.input = "";  // Изначально строка пустая
    }

    // Конструктор с параметром
    public StringProcessor(String input) {
        this.input = input;
    }

    // Метод для замены всех гласных в строке на "-"
    public static String replaceVowels(String input) {
        // Заменяем все символы, которые являются гласными (как в латинице, так и в кириллице) на "-"
        return input.replaceAll("[AEIOUaeiouАЕЁИОУЫЭЮЯаеёиоуыэюя]", "-");
    }
}
