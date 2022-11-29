package ru.croc.task11.classes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerSinglePart implements Runnable {
    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public ServerSinglePart(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            this.dataInputStream = new DataInputStream(socket.getInputStream());

            boolean flag;
            do {
                String phrase = dataInputStream.readUTF();

                flag = phrase.equalsIgnoreCase("exit");
                if (flag) {
                    dataOutputStream.writeUTF("Connection suicide");
                    finishing();
                } else {
                    dataOutputStream.writeUTF(phrase);
                    dataOutputStream.flush();
                }
            } while (!flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void finishing() {
        try {
            if (!socket.isClosed()) {
                dataInputStream.close();
                dataOutputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
