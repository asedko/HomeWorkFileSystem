package ua.com.qalight.service;

import ua.com.qalight.entity.User;

import java.io.*;
import java.nio.file.Files;

public class FileManipulator {

    public static final String DIRECTORY_PATH =
            System.getProperty("user.dir") +
                    System.getProperty("file.separator") +
                    "files" +
                    System.getProperty("file.separator");

    private static final String FILE_NAME = "text.txt";

    public static String readTextFromFile() {
        FileReader fileReader = null;
        String out = "";
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(DIRECTORY_PATH + FILE_NAME);
            bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                out += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return out;
    }

    public static void writeTextToFile(String textToFile, boolean append) {

        try (FileWriter fileWriter = new FileWriter(DIRECTORY_PATH + FILE_NAME, append)) {

            fileWriter.write(textToFile);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String pathToCopyFile) {

        String textFromFile = readTextFromFile();
        try (FileWriter fileWriter = new FileWriter(pathToCopyFile)) {

            fileWriter.write(textFromFile);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readTextFromFile(String pathToFile) {

        FileReader fileReader = null;
        String out = "";
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(pathToFile);
            bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                out += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return out;
    }

    public static byte[] readFile(String filePath) {

        byte[] out = null;

        File file = new File(filePath);
        try {
            out = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out;
    }

    public static User readObject(String filePath) {

        User user = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            user = (User) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void writeBytesToFile(String filePath, byte[] bytes) {

        File file = new File(filePath);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String sourcePath, String targetPath) {

        byte[] bytes = readFile(sourcePath);

        writeBytesToFile(targetPath, bytes);

    }
}

