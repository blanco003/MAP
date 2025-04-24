class Serie implements Runnable{
    private int x;
    private Thread th;
    
    public Serie(int x){
        if (x < 0) {
            throw new IllegalArgumentException("Il valore di x deve essere un intero positivo.");
        }
        this.x = x;
        this.th = new Thread(this);
    }

    public void run(){
        int i = 1;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            System.out.println("Thread ("+ x +") : "+ Math.pow(x, i));
            i++;
        }
    }

    public void start_thread(){
        th.start();
    }

    public static void main(String[] args) {

        Serie s1 = new Serie(1);
        Serie s2 = new Serie(-2);
        Serie s3 = new Serie(3);

        s1.start_thread();
        s2.start_thread();
        s3.start_thread();
    }
}

