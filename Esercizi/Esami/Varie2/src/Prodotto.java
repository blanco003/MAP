public class Prodotto implements Comparable<Prodotto>{

    private Integer codice;
    private String nome;
    private Double prezzo;

    Prodotto(Integer c, String n, Double p){
        this.codice = c;
        this.nome = n;
        this.prezzo = p;
    }

    public Integer get_codice(){
        return this.codice;
    }

    public String get_nome(){
        return this.nome;
    }

    public String toString(){
        return "Codice : "+codice.toString()+" , Nome : "+nome+" , Prezzo : "+prezzo.toString();
    }

    public int hashCode(){
        return this.codice.hashCode();
    }

    // la traccia specifica che 2 prodotti sono distini se hanno codice diverso
    public boolean equals(Object o){
        return this.codice.equals( ((Prodotto)o).get_codice()  );
    }

    // relazione d'ordine usata più frequentemente : ordianamento in base al codice
    public int compareTo(Prodotto p){
        return this.codice-p.get_codice();
    }
   
}