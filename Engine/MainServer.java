package dossier;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import dossier.*;

public class MainServer {

    public static void main(String[] args) {

        ArrayList<ServerThread> threadList = new ArrayList<>();
        try (ServerSocket serversocket = new ServerSocket(5000)){
            while(true) {
                Socket socket = serversocket.accept();
                ServerThread serverThread = new ServerThread(socket, threadList);

                threadList.add(serverThread); 
                serverThread.start();

            }
        } catch (Exception e) {
            System.out.println("Error server: " + e.getStackTrace());
        }
    }
}