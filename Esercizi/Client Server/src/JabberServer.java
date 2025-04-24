// server (non multithreading) che controlla se il client si mette in attesa

import java.io.*;   // ci serve per la classi InputStream ed OutputStream
import java.net.*;   // ci server per le classi che gestiscono la comunicazione, InetAddress, ServerSocket, Socket

public class JabberServer{   // jabber = chiacchera

    // scegliamo una port al di fuori del range 1-1024, naturalmente dobbiamo scegliere una libera
    public static final int PORT = 8080;


    public static void main(String[] args)  throws IOException{
        // piuttosto che gestire l'IOException decidiamo di espellerla, sarebbe buona norma gestirla

        // creiamo un oggetto ServerSocket
        ServerSocket s = new ServerSocket(PORT);  // genera IOExceptio se la porta risulta occupata, ed il programma termina (si potrebbe gestire meglio chiedendo una nuova port)
        System.out.println("Started : " + s);

        // non ho ancora occupato la porta, ho semplicemente creato l'oggetto nella memoria heap

        try{

            // ServerSocket rimane in attesa fino a quando qualche client non lo contatta con un oggetto Socket
            Socket socket = s.accept();  // connessione accettata 

            try{

                    System.out.println("Connessione accettata : " + socket);


                    // gli stream non vengono creati ex novo ma sono quelli creati dentro l'oggetto Socket lato Client

                    BufferedReader in = new BufferedReader(
                                            new InputStreamReader(
                                                socket.getInputStream()));

                
                    // Flush automatico con PrintWriter
                    
                    PrintWriter out = new PrintWriter(
                                            new BufferedWriter(
                                                new OutputStreamWriter(
                                                    socket.getOutputStream())),true);

                    
                    
                    // i due Stream Client e Server si incrociano, ovvero quello che è InputStream lato Client diventa OutputStream lato Server
                    // e quello che è OutputStream lato Client diventa InputStream lato Server

                    // ovviamente se lato Client sull'OutputStream abbiamo scritto con un Writer,
                    // dobbiamo leggere da questo con un Reader, ovvero se stiamo scrivendo flussi di caratteri lato client 
                    // dobbiamo leggere flussi di caratteri lato Server e viceversa (non si mischiano)


                    while (true) {

                        String str = in.readLine();   // legge quello che il Client gli ha spedito

                         // controlla se corrisponde ad END, ovvero il Client sta chiudendo la comunicazione, se si usciamo dal ciclo
                        if(str.equals("END")) break;  

                        System.out.println("Echoing : " + str); // stampa a video quello che il Client gli ha spedito

                        out.println(str);  // rispedisce al Client quello che gli aveva scritto
                        
                    }
            }

            // chiudiamo i due socket

            finally{

                System.out.println("closing...");   // chiusura connessione con il Client
                socket.close();

            }

        }

        // dobbiamo ricordarci in ogni caso di liberare la porta occupata, dunque inseriamo il comando nel blocco finally
        // se non la liberassimo tramite comando close, l'unico altro modo per liberarla è riavviando la macchina

        finally{
                s.close();     // libero la porta del ServerSocket
        }

    }


}