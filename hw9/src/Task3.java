import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Task3 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourcePath = null;
        String destinationPath = null;

        try {
            System.out.print("Введите путь к исходной директории: ");
            sourcePath = reader.readLine();
            System.out.print("Введите путь к новой директории: ");
            destinationPath = reader.readLine();
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
        assert destinationPath != null;
        File destinationDir = new File(destinationPath);

        if (!sourceDir.isDirectory()) {
            System.out.println("Указанный путь не является директорией: " + sourcePath);
            return;
        }

        if (destinationDir.exists()) {
            System.out.println("Директория назначения уже существует: " + destinationPath);
            return;
        }

        if (!destinationDir.mkdirs()) {
            System.out.println("Не удалось создать новую директорию: " + destinationPath);
            return;
        }

        DirectoryCopyThread directoryCopyThread = new DirectoryCopyThread(sourceDir, destinationDir);
        directoryCopyThread.start();

        try {
            directoryCopyThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Статистика выполненных операций:");
        System.out.println("Скопировано файлов: " + directoryCopyThread.getFileCount());
        System.out.println("Скопировано директорий: " + directoryCopyThread.getDirectoryCount());
    }
}

class DirectoryCopyThread extends Thread {
    private final File sourceDir;
    private final File destinationDir;
    private int fileCount;
    private int directoryCount;

    public DirectoryCopyThread(File sourceDir, File destinationDir) {
        this.sourceDir = sourceDir;
        this.destinationDir = destinationDir;
    }

    public int getFileCount() {
        return fileCount;
    }

    public int getDirectoryCount() {
        return directoryCount;
    }

    @Override
    public void run() {
        try {
            boolean success = copyDirectory(sourceDir, destinationDir);
            if (success) {
                System.out.println("Копирование директории завершено успешно");
            } else {
                System.out.println("Ошибка при копировании директории");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean copyDirectory(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            if (!destination.exists()) {
                boolean created = destination.mkdir();
                if (created) {
                    directoryCount++;
                } else {
                    return false; // Возвращаем false в случае ошибки создания директории
                }
            }

            String[] files = source.list();
            if (files != null) {
                for (String file : files) {
                    File srcFile = new File(source, file);
                    File destFile = new File(destination, file);
                    boolean success = copyDirectory(srcFile, destFile);
                    if (!success) {
                        return false; // Возвращаем false, если произошла ошибка при копировании файла
                    }
                }
            }
        } else {
            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            fileCount++;
        }

        return true; // Возвращаем true в случае успешного копирования
    }
}
