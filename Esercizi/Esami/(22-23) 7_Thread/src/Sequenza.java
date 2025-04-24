public class Sequenza extends Thread{    // Ereditarietà per estensione
    private int x;

    Sequenza(int x){
        this.x = x;
    }


    // Ereditarietà per variazione funzionale : sovrascriviamo run() della classe Thread
    public void run(){
        int i = 1;
        while (true) {

            try{
                sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Thread ("+this.x+") : " +  Math.pow(this.x, i));
            i++;
        }
    }

    public static void main(String[] args) {
        Sequenza s1 = new Sequenza(3);
        Sequenza s2 = new Sequenza(-3);
        s1.start();
        s2.start();
    }
}
