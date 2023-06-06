import java.util.*;

public class Dictionary {
    private Map<String, List<String>> dictionary;
    private Map<String, Integer> wordCount;

    public Dictionary() {
        dictionary = new HashMap<>();
        wordCount = new HashMap<>();
    }

    public void addTranslation(String word, String translation) {
        List<String> translations = dictionary.getOrDefault(word, new ArrayList<>());
        translations.add(translation);
        dictionary.put(word, translations);
    }

    public void removeTranslation(String word, String translation) {
        List<String> translations = dictionary.getOrDefault(word, new ArrayList<>());
        translations.remove(translation);
        if (translations.isEmpty()) {
            dictionary.remove(word);
        } else {
            dictionary.put(word, translations);
        }
    }

    public void addWord(String word) {
        dictionary.putIfAbsent(word, new ArrayList<>());
    }

    public void removeWord(String word) {
        dictionary.remove(word);
    }

    public void replaceWord(String oldWord, String newWord) {
        List<String> translations = dictionary.getOrDefault(oldWord, new ArrayList<>());
        dictionary.remove(oldWord);
        dictionary.put(newWord, translations);
    }

    public void replaceTranslation(String word, String oldTranslation, String newTranslation) {
        List<String> translations = dictionary.getOrDefault(word, new ArrayList<>());
        translations.remove(oldTranslation);
        translations.add(newTranslation);
        dictionary.put(word, translations);
    }

    public void incrementWordCount(String word) {
        int count = wordCount.getOrDefault(word, 0);
        wordCount.put(word, count + 1);
    }

    public List<String> getTranslations(String word) {
        return dictionary.getOrDefault(word, new ArrayList<>());
    }

    public List<String> getPopularWords() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<String> popularWords = new ArrayList<>();
        for (int i = 0; i < Math.min(10, entries.size()); i++) {
            popularWords.add(entries.get(i).getKey());
        }
        return popularWords;
    }

    public List<String> getUnpopularWords() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        List<String> unpopularWords = new ArrayList<>();
        for (int i = 0; i < Math.min(10, entries.size()); i++) {
            unpopularWords.add(entries.get(i).getKey());
        }
        return unpopularWords;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить перевод");
            System.out.println("2. Удалить перевод");
            System.out.println("3. Добавить слово");
            System.out.println("4. Удалить слово");
            System.out.println("5. Заменить слово");
            System.out.println("6. Заменить перевод");
            System.out.println("7. Отобразить переводы слова");
            System.out.println("8. Отобразить популярные слова");
            System.out.println("9. Отобразить непопулярные слова");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введите слово для перевода:");
                    String word = scanner.nextLine();
                    System.out.println("Введите перевод:");
                    String translation = scanner.nextLine();
                    dictionary.addTranslation(word, translation);
                    dictionary.incrementWordCount(word);
                    break;
                case 2:
                    System.out.println("Введите слово для удаления перевода:");
                    word = scanner.nextLine();
                    System.out.println("Введите перевод для удаления:");
                    translation = scanner.nextLine();
                    dictionary.removeTranslation(word, translation);
                    break;
                case 3:
                    System.out.println("Введите слово для добавления:");
                    word = scanner.nextLine();
                    dictionary.addWord(word);
                    break;
                case 4:
                    System.out.println("Введите слово для удаления:");
                    word = scanner.nextLine();
                    dictionary.removeWord(word);
                    break;
                case 5:
                    System.out.println("Введите слово для замены:");
                    String oldWord = scanner.nextLine();
                    System.out.println("Введите новое слово:");
                    String newWord = scanner.nextLine();
                    dictionary.replaceWord(oldWord, newWord);
                    break;
                case 6:
                    System.out.println("Введите слово для замены перевода:");
                    word = scanner.nextLine();
                    System.out.println("Введите старый перевод:");
                    String oldTranslation = scanner.nextLine();
                    System.out.println("Введите новый перевод:");
                    String newTranslation = scanner.nextLine();
                    dictionary.replaceTranslation(word, oldTranslation, newTranslation);
                    break;
                case 7:
                    System.out.println("Введите слово для отображения переводов:");
                    word = scanner.nextLine();
                    List<String> translations = dictionary.getTranslations(word);
                    if (!translations.isEmpty()) {
                        System.out.println("Переводы слова " + word + ":");
                        for (String trans : translations) {
                            System.out.println(trans);
                        }
                    } else {
                        System.out.println("Переводы для слова " + word + " не найдены.");
                    }
                    break;
                case 8:
                    List<String> popularWords = dictionary.getPopularWords();
                    System.out.println("Топ 10 популярных слов:");
                    for (String popularWord : popularWords) {
                        System.out.println(popularWord);
                    }
                    break;
                case 9:
                    List<String> unpopularWords = dictionary.getUnpopularWords();
                    System.out.println("Топ 10 непопулярных слов:");
                    for (String unpopularWord : unpopularWords) {
                        System.out.println(unpopularWord);
                    }
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, повторите попытку.");
                    break;
            }
        }
    }
}
