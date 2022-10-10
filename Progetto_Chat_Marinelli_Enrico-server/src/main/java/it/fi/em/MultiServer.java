package it.fi.em;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public void avvia(){
        try{
            ServerSocket serverSocket = new ServerSocket(6789);
            for(;;){
                System.out.println("Server in attesa...");
                Socket socket = serverSocket.accept();
                System.out.println("Server socket " + socket);
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server!");
            System.exit(1);
        }
    }
}
