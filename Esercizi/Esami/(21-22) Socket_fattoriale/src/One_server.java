import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class One_server extends Thread{

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public One_server(Socket s) throws IOException{
        this.socket = s;

                in = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()));
        

        out = new PrintWriter(
                new BufferedWriter(
                    new OutputStreamWriter(
                        socket.getOutputStream())),true);

        start();
        
    }

    public void run(){

        try{
            
            while(true){

                String str = in.readLine();  // leggo la stringa spedita dal Client

                if (str == null) {
                    break;  // client closed connection
                }
                

                System.out.println("Il client ha inviato : "+str);  // stampo a video quello che ha spedito il Client

                Integer x = Integer.parseInt(str);
                if(x==0) break;

                Integer res = fattoriale(x);
                System.out.println("Gli rispondo con : "+res);
                out.println(res);  // gli rinvio al Client quello che aveva spedito
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

    public int fattoriale(int n){
        if(n==0 || n==1){
            return n;
        }
        return n * fattoriale(n-1);
    }
}
