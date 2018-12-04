package ua.com.qalight.service;

import java.util.Arrays;
import java.util.List;

public class Randomizer {

    private static final String LETTERS_LOW_CASE = "abcdefgjiklmnopqrstuvwxyz";
    private static final String LETTERS_UPPER_CASE = "ABCDEFGIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "1234567890";

    private static final List<String> DOMAINS = Arrays.asList("gmail.com", "hotmail.com", "mail.com", "i.ua", "bigmir.net");

    public static Integer getRandomInteger(int min, int max) {

        Integer maxValue = (int) (Math.random() * ((max - min) + 1));

        return min + maxValue;
    }

    public static String getRandomDomain(int index) {

        switch (index) {
            case 1:
                return DOMAINS.get(0);
            case 2:
                return DOMAINS.get(1);
            case 3:
                return DOMAINS.get(2);
            case 4:
                return DOMAINS.get(3);
            case 5:
                return DOMAINS.get(4);

            default:
                return DOMAINS.get(0);
        }
    }

    public static String getRandomString(int stringLength) {

        String out = "";

        for (int i = 0; i < stringLength; i++) {

            out += getRandomLetter();
        }

        return out;
    }

    private static String getRandomLetter() {

        String sourceString = LETTERS_LOW_CASE + LETTERS_UPPER_CASE + NUMBERS;

        int srcLength = sourceString.length();

        return String.valueOf(sourceString.charAt(getRandomInteger(0, srcLength - 1)));
    }
}
