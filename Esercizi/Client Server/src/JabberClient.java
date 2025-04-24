// client che manda e riceve semplice con il server

import java.io.*;   // ci serve per la classi InputStream ed OutputStream
import java.net.*;   // ci server per le classi che gestiscono la comunicazione, InetAddress, ServerSocket, Socket


public class JabberClient {

    public static void main(String[] args) throws IOException{
        
        // indirizzo riservato al localhost : 127.0.0.1
        // ipotizziamo il server sia in esecuzione su localhost
        // altrimenti andrebbe passato l'ip / DNS della macchina su cui è in esecuzione

        // lato client è necessario sapere su quale ip è in esecuzione il server

        InetAddress addr = InetAddress.getByName("127.0.0.1");
        System.out.println("addr : "+ addr);

        // 8080 è la porta dove mi aspetto sia in esecuzione l'oggetto ServerSocket

        Socket socket = new Socket(addr,8080);  // una volta invocato il costruttore lato Server si va avanti

        // quando viene inizializzato Socket vengono anche inzializzati i suoi attributi
        // insieme agli attrubuti per InputStream ed OutputStream

        try{

            System.out.println("Socket : " + socket);

            // gli stream non vengono creati ex novo ma si va a prendere quelli già presenti in Socket

            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(
                                        socket.getInputStream()));

            // Flush automatico con PrintWriter

            PrintWriter out = new PrintWriter(
                                    new BufferedWriter(
                                        new OutputStreamWriter(
                                            socket.getOutputStream())),true);

            for(int i=0; i <10; i++){

                // nel caso di System effettua la stampa a video, essendo che stiamo chiamando println su out 
                // che è un PrintWriter su socket.getOutputStream(),  questa stringa la stiamo scrivendo sull' OutputStream creato con Socket,
                // che grazie a Socket arriverà al server che è in ascolto

                out.println("prova " + i );     // spediamo al server prova 0, prova 1, ... 
                
                String str = in.readLine();  // legge un'eventuale risposta dal server

                // essendo che stiamo chiamando readLine su in che è un BufferReader su socket.getInputStream() ,
                // ci aspettiamo di ricervere la risposta dal server
                // se effettivamente ha risposto con qualcosa, altrimenti readLine() continua ad aspettare fino a quando non riceve qualcosa da leggere


                System.out.println(str);  // stampo a video la risposta del server
            }

            out.println("END");  // spedisco al server come ultimo messaggio END
        }

        // è buona norma chiudere la socket in ogni caso, poichè se terminiamo il programnma senza chiudere la socket
        // viene generata un'eccezione lato server

        finally{
            
            System.out.println("closing ...");
            socket.close();
        }

        // quindi il client non solo fa partire lui la comunicazione ma è anche quello che decide quando chiuderla
        
    }
    
}
