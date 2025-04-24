
import java.io.*;   // ci serve per la classi InputStream ed OutputStream
import java.net.*;   // ci server per le classi che gestiscono la comunicazione, InetAddress, ServerSocket, Socket

public class Multi_server {

     // scegliamo una port al di fuori del range 1-1024, naturalmente dobbiamo scegliere una libera
     public static final int PORT = 8080;

    public static void main(String[] args) throws IOException{
        
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Avviato server : "+s);

        // il server ora è in attesa di richieste dal client

        try{
            while(true){  // sempre in esecuzione

                Socket socket = s.accept(); // rimane in attesa di richieste dai Client

                try{

                    new One_server(socket);  // crea un thread per gestire la richiesta e si rimette in attesa di altre richieste

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
