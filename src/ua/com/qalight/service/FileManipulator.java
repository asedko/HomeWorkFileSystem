package ua.com.qalight.service;


import java.io.FileWriter;
import java.io.IOException;

public class FileManipulator {

    public static final String DIRECTORY_PATH =
            System.getProperty("user.dir") +
                    System.getProperty("file.separator") +
                    "files" +
                    System.getProperty("file.separator");

    private static final String FILE_NAME = "logs.txt";


    public static void writeTextToFile(String textToFile, boolean append) {

        try (FileWriter fileWriter = new FileWriter(DIRECTORY_PATH + FILE_NAME, append)) {

            fileWriter.write(textToFile);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

