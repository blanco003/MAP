
/* Se scelgo di realizzare il thread implementando l'interfaccia Runnable, devo implementare necessariamente il metodo run,
 * inoltre devo avere tra gli attributi della classe un oggetto Thread che andrà inzializzato mediante il costruttore
 * a 2 argomenti (un oggetto Runnable e un nome).
 * 
 * Ho bisogno anche di una funzione che invochi il metodo start del thread.
 */

public class SimpleThread2 implements Runnable{

    private int countDown = 5;
    private static int threadCount = 0;
    private int threadNumber = ++threadCount;
    private Thread th;

    SimpleThread2(String name){
        th = new Thread(this, name);
        System.out.println("Making " + threadNumber);
    }

    public void run(){
        while (true) {
            System.out.println("Thread " + threadNumber + "(" + countDown + ")" );
            if( --countDown == 0 ) return;
        }
    }

    public void start_thread(){
        th.start();
    }
    
    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            new SimpleThread2("").start_thread();
        }
        System.out.println("all thread started");
    }
}
