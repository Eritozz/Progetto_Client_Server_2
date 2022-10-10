package it.fi.em.meucci;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class SecondClient {
    String nomeServer = "Server prova";
    int portaServer = 6789;
    DataInputStream input;
    DataOutputStream output;

    protected Socket connetti()throws IOException
    {
        Socket socketProva = new Socket (nomeServer, portaServer);
        output = new DataOutputStream(socketProva.getOutputStream());
        input = new DataInputStream(socketProva.getInputStream());
        return socketProva;
    }

}

