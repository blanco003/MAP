/*  Applicazione Client Server con Server Multithread, ovvero può gestire più di un client alla volta
    Per ogni Client che si connette viene inizializzato un nuovo thread.

    Se termina la comunicazione con un Client viene terminato il thread corrispondente, ma il Server sul thread principale è sempre
    in esecuzione ad aspettare che altri Client lo contattino.

    Ovviamente si è multithreading ma le richieste verrano sempre sequenziate con la tecnica del time slicing

    (JabberClient non necessità di variazioni, rimane identico come nel caso di Client-Server 1 a 1)
*/ 

import java.io.*;   // ci serve per la classi InputStream ed OutputStream
import java.net.*;   // ci server per le classi che gestiscono la comunicazione, InetAddress, ServerSocket, Socket


public class MultiJabberServer {

    static final int PORT = 8080;

    public static void main(String[] args) throws IOException{
        
        // l'oggetto ServerSocket (che è un solo) lavora sul thread principale
        // una volta aperto ServerSocket sulla porta specificata, il thread principale avrà solo un compito, quello di accept()
        // ovvero accettare le richieste che arrivano dai vari Client e creare un oggetto Thread dedicato per gestire tali richieste singolarmente


        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server started : " + s);

        try{
            while(true){  // sempre in esecuzione

                Socket socket = s.accept(); // rimane in attesa di richieste dai Client

                try{

                    new ServerOneJabber(socket);  // crea un thread per gestire la richiesta e si rimette in attesa di altre richieste

                }catch(IOException e){

                    // se fallisce viene chiuso il socket relativo, altrimenti il thread la chiuderà
                    socket.close();
                }

            }
        
        } 

        finally{
            s.close();   // chiusura del ServerSocket
        }


    }
    
}


// gestisce la comunicazione con un singolo Client creando un thread corrispondente

class ServerOneJabber extends Thread{
    
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerOneJabber(Socket s) throws IOException{

        socket = s;

        in = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()));
        

        out = new PrintWriter(
                new BufferedWriter(
                    new OutputStreamWriter(
                        socket.getOutputStream())),true);

        
        // se una qualsiasi delle chiamate precedenti solleva una eccezzione il processo chiamante
        // è responsabile della chiusura del socket. Altrimenti lo chiuderà il thread con la terminazione.


        start(); // inzializza il thread e lo manda in run().  New -> Runnable. Il therad è ora visibile al SO

    }

    public void run(){

        try{
            
            while(true){

                String str = in.readLine();  // leggo la stringa spedita dal Client

                // se ha spedito END vuol dire che sta chiudendo la connessione dunque esco dal ciclo
                if(str.equals("END")) break;  

                System.out.println("Echoing : "+str);  // stampo a video quello che ha spedito il Client

                out.println(str);  // gli rinvio al Client quello che aveva spedito
            }

            System.out.println("closing...");

        }catch(IOException e){

            System.err.println("IOException");

        } finally{

            try{

                socket.close();    // chiudo la socket, e non la serversocket

            }catch(IOException e){
                System.err.println("Socket not closed");
            }
        }

    }

}