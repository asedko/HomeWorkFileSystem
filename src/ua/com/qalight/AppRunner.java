package ua.com.qalight;

import ua.com.qalight.service.FileManipulator;

import static ua.com.qalight.service.Randomizer.getRandomInteger;

public class AppRunner {

    public static void main(String[] args) {

        for (int line = 0; line < 10; line++) {
            long timestamp = System.currentTimeMillis();
            int sessionNumber = getRandomInteger(123000000, 123999999);
            String randomIp = getRandomInteger(192, 223) + "." +
                    getRandomInteger(0, 255) + "." +
                    getRandomInteger(0, 255) + "." + 0;
            FileManipulator.writeTextToFile(timestamp + " " + sessionNumber + " " + randomIp + "\n", true);
        }
    }
}
