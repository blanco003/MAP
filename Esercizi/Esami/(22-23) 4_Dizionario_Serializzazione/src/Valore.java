import java.io.Serializable;

public class Valore implements Serializable{
    private Double val;

    public Valore(Double val){
        this.val = val;
    }

    public Double get_val(){
        return this.val;
    }
    public String toString(){
        return val.toString();
    }
}
