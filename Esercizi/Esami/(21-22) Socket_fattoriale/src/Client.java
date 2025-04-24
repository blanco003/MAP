
import java.io.*;   // ci serve per la classi InputStream ed OutputStream
import java.net.*;   // ci server per le classi che gestiscono la comunicazione, InetAddress, ServerSocket, Socket
import java.util.Scanner;

public class Client {
    
    
    public static void main(String[] args) throws IOException{
        
        InetAddress addr = InetAddress.getByName("127.0.0.1");  // ipotizziamo il server sia in esecuzione su localhost
        System.out.println("Indirizzo : "+addr);

        // inizializzo la connessione al server
        Socket socket = new Socket(addr,8080);

        // si aspetta che il server accetti la richiesta di connesione del client

        try{
            System.out.println("Socket : "+socket);

            // i due Stream Client e Server si incrociano, ovvero quello che è InputStream lato Client diventa OutputStream lato Server
            // e quello che è OutputStream lato Client diventa InputStream lato Server

            // ovviamente se lato Client sull'OutputStream abbiamo scritto con un Writer,
            // dobbiamo leggere da questo con un Reader, ovvero se stiamo scrivendo flussi di caratteri lato client 
            // dobbiamo leggere flussi di caratteri lato Server e viceversa (non si mischiano)

            // stream per scrivere al server

            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(
                                            socket.getInputStream()));

            // stream per leggere le risposte del server

            PrintWriter out = new PrintWriter(
                                    new BufferedWriter(
                                            new OutputStreamWriter(
                                                socket.getOutputStream())),true);

            while(true){
                
                System.out.println("Inserisci il numero di cui calcolare il fattoriale (0 per terminare): ");
                Scanner scanner = new Scanner(System.in);
                Integer x =  scanner.nextInt();
                


                System.out.println("Mando al server : "+x);
                out.println(x);   // mando il numero al server

                if(x==0){
                    scanner.close();   
                    break;
                    
                }

                System.out.println("Risposta server : "+in.readLine());   // leggo la risposta dal server e la stampo a video
            }

                                     

        }
        finally{
            
            System.out.println("chiusara connessione ...");
            socket.close();
        }
    }
}
