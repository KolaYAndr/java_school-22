package ru.croc.task11.classes;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class ServerReceiver extends Thread {
    private final Socket socket;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public ServerReceiver(Socket socket) throws IOException{
        this.socket = socket;

        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        start();
    }

    @Override
    public void run() {
        try {
            boolean flag;
            do {
                String phrase = reader.readLine();

                flag = Objects.equals(phrase.toLowerCase(), "exit");


                if (flag) {
                    finishing();
                } else
                    for (ServerReceiver serverReceiver : Server.serverReceivers) {
                        serverReceiver.update(phrase);
                    }
            } while (!flag);
        } catch (IOException e) {
            finishing();
        }

    }

    private void finishing() {
        try {
            socket.close();
            writer.close();
            reader.close();

            for (ServerReceiver serverReceivers : Server.serverReceivers) {
                serverReceivers.interrupt();
                Server.serverReceivers.remove(this);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void update(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
