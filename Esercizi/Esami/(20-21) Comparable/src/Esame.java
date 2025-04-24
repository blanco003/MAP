public class Esame implements Comparable<Esame>{
    private Integer codice;
    private Integer voto;

    Esame(Integer codice, Integer voto){
        this.codice = codice;
        this.voto = voto;
    }

    public String toString(){
        return "Codice : "+this.codice.toString()+" , Voto : "+this.voto.toString();
    }

    public Integer get_voto(){
        return this.voto;
    }

    public int compareTo(Esame e){
        return this.voto-e.get_voto();
    }
}