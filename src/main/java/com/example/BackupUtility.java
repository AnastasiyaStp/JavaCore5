package com.example;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class BackupUtility {
    public static void backupFiles(String sourceDir) {
        Path sourcePath = Paths.get(sourceDir);
        Path backupPath = Paths.get("./backup");

        try {
            if (!Files.exists(backupPath)) {
                Files.createDirectory(backupPath);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при создании директории резервного копирования: " + e.getMessage());
            return;
        }

        try {
            Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (!Files.isDirectory(file)) {
                        Path targetFile = backupPath.resolve(sourcePath.relativize(file));
                        Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("Ошибка при копировании файлов: " + e.getMessage());
        }
    }
}
