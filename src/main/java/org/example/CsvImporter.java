package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvImporter {

    public List<Student> loadFromCsv(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 8) {
                    continue;
                }

                Student student = new Student(
                        0,
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        parts[3].trim(),
                        parts[4].trim(),
                        Integer.parseInt(parts[5].trim()),
                        Integer.parseInt(parts[6].trim()),
                        Integer.parseInt(parts[7].trim())
                );

                students.add(student);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения CSV", e);
        }

        return students;
    }
}
