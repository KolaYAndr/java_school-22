package task11.classes;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class ServerReceiver extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public ServerReceiver(Socket socket) throws IOException{
        this.socket = socket;

        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        start();
    }

    @Override
    public void run() {
        try {
            String phrase = reader.readLine();
            boolean flag;
            do {
                flag = Objects.equals(phrase.toLowerCase(), "exit");

                phrase = reader.readLine();

                for (ServerReceiver serverReceiver : Server.serverReceivers) {
                    serverReceiver.update(phrase);
                }

                if (flag) {
                    finishing();
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
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
