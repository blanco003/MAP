import java.io.Serializable;

public class Chiave implements Serializable{

    private String val;

    public Chiave(String val){
        this.val = val;
    }

    public String get_val(){
        return this.val;
    }

    public String toString(){
        return val.toString();
    }

    // Per HashMap

    public int hashCode(){
        return val.hashCode();  // sfruttiamo hashCode della classe Wrapper String
    }

    public boolean equals (Object o) {
        return ((Chiave)o).get_val()==val;
    }

    
}
