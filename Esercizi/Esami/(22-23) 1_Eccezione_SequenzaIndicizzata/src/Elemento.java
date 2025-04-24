public class Elemento {
    private String nome;
    private double valore;

    public Elemento(String nome,double valore){
        this.nome = nome;
        this.valore = valore;
    }

    public String get_nome(){
        return this.nome;
    }

    public double get_valore(){
        return this.valore;
    }


    public String toString(){
        String res = "Nome : "+nome+" , Valore : "+valore;
        return res;
    }


}


