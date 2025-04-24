public class Chiave implements Comparable<Chiave>{
    private Integer val;

    public Chiave(Integer val){
        this.val=val;
    }

    public Integer get_val(){
        return this.val;
    }

    public String toString(){
        return val.toString();
    }

    public boolean equals(Chiave k2){
        return this.val.equals(k2.get_val());
    }

    public int compareTo(Chiave k){
        // possiamo anche sfruttare compareTo della classe Wrapper Integer
        return this.val-k.get_val();
    }

}
