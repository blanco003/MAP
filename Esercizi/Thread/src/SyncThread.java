public class SyncThread {

    private TwoCounter t=new TwoCounter();
    
    SyncThread(){
        t.start();   // ciclo infinito
        new Watcher();
    }
    
    class TwoCounter extends Thread{   // inner class, attiva
        private int a=0;
        private int b=0;
        
        synchronized public void run() {       // quando entra in esecuzione blocca le risorse (a e b)
            while (true) {    // ciclo infinito, dunque le risore saranno bloccate per sempre, fino alla terminazione del programma
            {
                a++;
                b++;
            }
            try {
                sleep(500);
             } catch(InterruptedException e) {
                System.err.println("Interrupted");
            }
            }
    }

    // synchTest è eseguito solo quando run non è in esecuzione  nello stesso Thread e viceversa

    public synchronized void synchTest() {       // blocca le risorse, stampa a video, e le rilascia
        System.out.println("a"+a+"b"+b);
    }

    }


    class Watcher extends Thread{
        
        public Watcher() { 
            start(); 
        }

        public void run() {
            while(true) {
                t.synchTest();
                try {
                    sleep(500);
                } catch(InterruptedException e) {
                    System.err.println("Interrupted");
                }
            }
        }
    }

    public static void main (String args[]) {
        SyncThread s = new SyncThread();
    }
}