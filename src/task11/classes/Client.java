package task11.classes;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public Client(String ip, int port) {
        try {
            Socket socket = new Socket(ip, port);
        }
        catch (IOException e){
            System.err.println("Socket failed");
        }
    }
}
