package ru.croc.task11.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static ExecutorService executeIt = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(2000)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            boolean flag;
            do {
                String phrase = bufferedReader.readLine();
                flag = phrase.equalsIgnoreCase("exit");

                if (flag){
                    bufferedReader.close();
                    serverSocket.close();
                }

                Socket client = serverSocket.accept();

                executeIt.execute(new ServerSinglePart(client));
            } while (!flag);
            executeIt.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
