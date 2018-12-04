package ua.com.qalight.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ua.com.qalight.service.FileManipulator.DIRECTORY_PATH;

class FileManipulatorTest {


    private static String textInFile;

    @BeforeAll
    static void setBeforeAll() {
        textInFile = FileManipulator.readTextFromFile();
    }

    @Test
    void testSaveAndReadTextToFile() {
        String testText = "blablabla\n";
        FileManipulator.writeTextToFile(testText, false);
        String textFromFile = FileManipulator.readTextFromFile();
        assertEquals("blablabla\n", textFromFile);
    }

    @Test
    void testCopyTextFile() {
        String testText = "blablabla\n";
        String pathToCopyFile = DIRECTORY_PATH + "textCopy.txt";
        FileManipulator.writeTextToFile(testText, false);
        FileManipulator.copyFile(pathToCopyFile);
        String textFromFile = FileManipulator.readTextFromFile(pathToCopyFile);
        assertEquals("blablabla\n", textFromFile);
        File file = new File(pathToCopyFile);
        file.delete();
    }

    @AfterAll
    static void setAfterAll() {
        FileManipulator.writeTextToFile(textInFile, false);
    }
}