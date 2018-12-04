package ua.com.qalight;

import ua.com.qalight.service.ServerConnectionInfo;

import static ua.com.qalight.service.Randomizer.getRandomInteger;

public class AppRunner {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            ServerConnectionInfo serverConnectionInfo = new ServerConnectionInfo();
            serverConnectionInfo.setConnectTime(System.currentTimeMillis());
            serverConnectionInfo.setSessionNumber(getRandomInteger(123000000, 123999999));
            serverConnectionInfo.setClientIp(getRandomInteger(192, 223) + "." +
                    getRandomInteger(0, 255) + "." +
                    getRandomInteger(0, 255) + "." + 0);
            ServerConnectionInfo.writeObject(serverConnectionInfo, true);
        }
    }
}
