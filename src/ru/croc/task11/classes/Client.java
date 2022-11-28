package ru.croc.task11.classes;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Client {

    public Client(String ip, int port) {
        try {
            Socket socket = new Socket(ip, port);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите имя пользователя: ");
            String name = br.readLine();

            ClientRead cr = new ClientRead(socket);
            ClientWrite cw = new ClientWrite(name, socket);
            cr.start();
            cw.start();
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
    }

    private static class ClientRead extends Thread {
        private final Socket socket;
        private BufferedReader bufferedReader;

        public ClientRead(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                boolean flag;
                do {
                    String phrase = bufferedReader.readLine();

                    flag = Objects.equals(phrase.toLowerCase(), "exit");

                    if (flag) {
                        finishing();
                    }
                } while (!flag);
            } catch (IOException e) {
                System.out.println("Не получилось взять данные с сокета");
            }
        }

        private void finishing() {
            try {
                bufferedReader.close();
                socket.close();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static class ClientWrite extends Thread{
        private final Socket socket;
        private final String name;
        private BufferedWriter bufferedWriter;
        private BufferedReader bufferedReader;

        public ClientWrite(String name, Socket socket){
            this.socket = socket;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                boolean flag;
                do {
                    String phrase = bufferedReader.readLine();

                    flag = Objects.equals(phrase.toLowerCase(), "exit");

                    if (flag) {
                        finishing();
                    } else update(name + ": " +phrase);
                } while (!flag);
            } catch (IOException e) {
                System.out.println("Не получилось взять данные с сокета");
            }
        }

        private void finishing() {
            try {
                bufferedReader.close();
                bufferedWriter.close();
                socket.close();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

        private void update(String message){
            try {
                bufferedWriter.write(message + "\n");
                bufferedWriter.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
