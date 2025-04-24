public class Cubo implements Runnable{
    private String name;
    private Thread th;

    public Cubo(String name){
        this.name = name;
        this.th = new Thread(this,name);
    }

    public void run(){
        int i = 1;
        while(true){
            try{
                Thread.sleep(1000);         // giusto per rendere l'output leggibile ad occhio
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Thread  "+this.name+" :"+(int)Math.pow(i, 3));
            i++;
        }
    }

    public void start_thread(){
        th.start();
    }

    public static void main(String[] args) {
        Cubo c1 = new Cubo("1");
        Cubo c2 = new Cubo("2");
        c1.start_thread();
        c2.start_thread();
    }


    
}
