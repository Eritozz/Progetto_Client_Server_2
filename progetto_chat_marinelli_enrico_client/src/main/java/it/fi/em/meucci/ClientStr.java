package it.fi.em.meucci;

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.net.UnknownHostException;

public class ClientStr {
    String nomeServer = "localhost";
    int portaServer = 6789;
    Socket miosocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;


    public Socket connetti(){
        

        try{
            System.out.println("CLIENT partito in esecuzione... ");
            tastiera = new BufferedReader(new InputStreamReader(System.in));

            miosocket = new Socket(nomeServer, portaServer);

            outVersoServer = new DataOutputStream(miosocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));


        } catch(UnknownHostException e){
            System.err.println("Host sconosciuto"); 
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione!");
            System.exit(1);
        }
        return miosocket;
    }

    public void comunica(){
        for(;;)
        try{
            System.out.println("Inserisci la strnga da trasmettere al server: " + '\n');
            stringaUtente = tastiera.readLine();

            System.out.println("Invio la stringa al servr e attendo ...");
            outVersoServer.writeBytes(stringaUtente + '\n');

            stringaRicevutaDalServer = inDalServer.readLine();
            System.out.println("Risposta dal server" + '\n' + stringaRicevutaDalServer);
            if(stringaUtente.equals("FINE")){
                System.out.println("CLIENT: termina elaborazione e chiude connessione");
                miosocket.close();
                break;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione col server");
            System.exit(1);
        }
    }

}
