package ru.croc.task11.classes;

import java.io.*;
import java.net.Socket;

public class Client extends Thread {
    private Socket clientSocket;
    private BufferedReader bufferedReader;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public Client(String ip, int port) {
        try (Socket socket = new Socket(ip, port)) {
            this.clientSocket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            this.dataInputStream = new DataInputStream(socket.getInputStream());

            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            dataOutputStream.writeUTF("Input your name");
            dataOutputStream.flush();
            String name = dataInputStream.readUTF();

            boolean flag;
            do {
                //пользователь вводит фразу
                String phrase = bufferedReader.readLine();

                //проверяем фразу на совпадение с exit
                flag = phrase.equalsIgnoreCase("exit");
                //если совпало, заканчиваем подключение и выводим сообщение о выходе пользователья
                if (flag) {
                    dataOutputStream.writeUTF("User " + name + " left the channel");
                    dataOutputStream.flush();
                    finishing();
                } else {
                    dataOutputStream.writeUTF(name + ": " + phrase);
                    dataOutputStream.flush();
                }
            } while (!flag);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //закрываем всё, что может быть закрыто
    private void finishing() {
        try {
            if (!clientSocket.isClosed()) {
                dataOutputStream.close();
                dataInputStream.close();
                bufferedReader.close();
                clientSocket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
