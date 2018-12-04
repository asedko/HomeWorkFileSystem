package ua.com.qalight.service;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("id")
public class ServerConnectionInfo implements Serializable {

    private static final String FILE_PATH = System.getProperty("user.dir") +
            System.getProperty("file.separator") +
            "files" +
            System.getProperty("file.separator") +
            "logs.txt";

    public long connectTime;
    public int sessionNumber;
    public String clientIp;

    public long getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(long connectTime) {
        this.connectTime = connectTime;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public static void writeObject(ServerConnectionInfo serverConnectionInfo, boolean append) {

        try (FileOutputStream fos = new FileOutputStream(FILE_PATH, append);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(serverConnectionInfo);
            oos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return connectTime + " " + sessionNumber + " " + clientIp;
    }
}

