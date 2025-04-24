import java.io.Serializable;

public class Elemento implements Serializable{
    private String nome;
    private Double valore;

    public Elemento(String nome,Double valore){
        this.nome = nome;
        this.valore = valore;
    }

    public String get_nome(){
        return this.nome;
    }

    public String toString(){
        return "Nome : "+nome+", Valore : "+valore;
    }


}
