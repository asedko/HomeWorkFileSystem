package ua.com.qalight;

import ua.com.qalight.service.FileManipulator;

public class AppRunner {

    public static void main(String[] args) {

        String sourcePath =
                System.getProperty("user.dir") +
                        System.getProperty("file.separator") +
                        "files" +
                        System.getProperty("file.separator") +
                        "IMG_0027.PNG";

        String targetPath =
                System.getProperty("user.dir") +
                        System.getProperty("file.separator") +
                        "files" +
                        System.getProperty("file.separator") +
                        "IMG_0027Copy.PNG";

        FileManipulator.copyFile(sourcePath, targetPath);

    }


}
