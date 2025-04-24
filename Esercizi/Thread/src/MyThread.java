
// creiamo più Thread

public class MyThread implements Runnable{
        
    String name;
    Thread th;

    MyThread(String thread_name){
        name = thread_name;
        th = new Thread(this, thread_name);
        System.out.println("Nuovo thread : " + th);
        th.start(); // facciamo partire direttamente il thread nel costruttore
    }

    public void run(){

        try {

            for(int i=3 ; i > 0; i--){
                System.out.println(name + " : " + i);
                Thread.sleep(1500);
            }

        } catch (InterruptedException e) {
            System.out.println(name + " interruzione");
        }

        System.out.println(name + " uscita");
    }


    public static void main(String[] args) {
        
        new MyThread("Uno");
        new MyThread("Due");
        new MyThread("Tre");

        try{
            Thread.sleep(10000);
        }catch(InterruptedException e){
            System.out.println("interruzione main thread");
        }

        System.out.println("uscita main thread");

    }

}  
