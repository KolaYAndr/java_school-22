package ru.croc.task11.classes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static final int PORT = 2021;
    static List<ServerReceiver> serverReceivers;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        try {
            Socket socket = serverSocket.accept();
            serverReceivers.add(new ServerReceiver(socket));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            serverSocket.close();
        } finally {
            serverSocket.close();
        }
    }
}
