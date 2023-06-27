import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourcePath = null;
        String searchWord = null;

        try {
            System.out.print("Введите путь к исходной директории: ");
            sourcePath = reader.readLine();
            System.out.print("Введите слово для поиска: ");
            searchWord = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        assert sourcePath != null;
        File sourceDir = new File(sourcePath);

        if (!sourceDir.isDirectory()) {
            System.out.println("Указанный путь не является директорией: " + sourcePath);
            return;
        }

        File mergedFile = new File("C:\\Users\\NODIRA\\Downloads\\1\\merged_file.txt");
        File forbiddenWordsFile = new File("C:\\Users\\NODIRA\\Downloads\\1\\forbidden_words.txt");

        SearchFilesThread searchFilesThread = new SearchFilesThread(sourceDir, searchWord, mergedFile);
        RemoveForbiddenWordsThread removeForbiddenWordsThread = new RemoveForbiddenWordsThread(mergedFile, forbiddenWordsFile);

        searchFilesThread.start();

        try {
            searchFilesThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        removeForbiddenWordsThread.start();

        try {
            removeForbiddenWordsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Статистика выполненных операций:");
        System.out.println("Объединено файлов: " + searchFilesThread.getFileCount());
        System.out.println("Выполнено вырезание запрещенных слов: " + removeForbiddenWordsThread.getRemovalCount());
    }
}

class SearchFilesThread extends Thread {
    private final File sourceDir;
    private final String searchWord;
    private final File mergedFile;
    private int fileCount;

    public SearchFilesThread(File sourceDir, String searchWord, File mergedFile) {
        this.sourceDir = sourceDir;
        this.searchWord = searchWord;
        this.mergedFile = mergedFile;
    }

    public int getFileCount() {
        return fileCount;
    }

    @Override
    public void run() {
        List<File> matchingFiles = new ArrayList<>();

        searchFiles(sourceDir, matchingFiles);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFile))) {
            for (File file : matchingFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            fileCount = matchingFiles.size();
            System.out.println("Объединено файлов: " + fileCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchFiles(File directory, List<File> matchingFiles) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFiles(file, matchingFiles);
                } else {
                    if (containsWord(file, searchWord)) {
                        matchingFiles.add(file);
                    }
                }
            }
        }
    }

    private boolean containsWord(File file, String word) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(word)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}

class RemoveForbiddenWordsThread extends Thread {
    private final File inputFile;
    private final File forbiddenWordsFile;
    private int removalCount;

    public RemoveForbiddenWordsThread(File inputFile, File forbiddenWordsFile) {
        this.inputFile = inputFile;
        this.forbiddenWordsFile = forbiddenWordsFile;
    }

    public int getRemovalCount() {
        return removalCount;
    }

    @Override
    public void run() {
        List<String> forbiddenWords = readForbiddenWords(forbiddenWordsFile);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\NODIRA\\Downloads\\1\\output_file.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String filteredLine = removeForbiddenWords(line, forbiddenWords);
                writer.write(filteredLine);
                writer.newLine();
                // Увеличить значение removalCount при удалении запрещенного слова
                if (!filteredLine.equals(line)) {
                    removalCount++;
                }
            }

            System.out.println("Выполнено вырезание запрещенных слов");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readForbiddenWords(File file) {
        List<String> forbiddenWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                forbiddenWords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return forbiddenWords;
    }

    private String removeForbiddenWords(String line, List<String> forbiddenWords) {
        for (String word : forbiddenWords) {
            line = line.replace(word, "");
        }

        return line;
    }
}
