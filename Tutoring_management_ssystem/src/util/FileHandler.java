package util;

import java.io.File;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class FileHandler {

    public static final String ADMINS = "admins.txt";
    public static final String STUDENTS = "students.txt";
    public static final String TUTORS = "tutors.txt";
    public static final String SCHEDULES = "schedules.txt";
    public static void writeToFile(String fileName, String data) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(data + System.lineSeparator());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean validateLogin(String fileName, String username, String password) {
        try {
            File file = new File(fileName);
            if (!file.exists()) return false;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    if (parts[0].equals(username) && parts[1].equals(password)) {
                        scanner.close();
                        return true;
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void write(String file, String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> read(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException ignored) {}
        return list;
    }
}



