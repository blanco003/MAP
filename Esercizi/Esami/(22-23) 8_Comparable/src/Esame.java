
 /* La traccia richiede di implementare l'interfaccia Comparable per realizzare la relazione d'ordine tra gli Esami in base al voto,
  * dunque dobbiamo implementare il metodo compareTo() che prende in input un'altro esame e restituisce un valore positivo, negativo o 0 
  * a seconda del risultato del confronto.
  *
  * In seguito viene chiesto l'esame con il numero piu basso di Cfu, tuttavia per l'interfaccia Comparable possiamo realizzare una sola relazione d'ordine alla volta
  * nel metodo compareTo(), dunque potremmo sovrascriverlo aggiorando la relazione d'ordine ma in questo modo la precente relazione d'ordine andrebbe perse.
  *
  * Per mantenerla potremmo pensare di creare una classe a parte che implementa Comparator per realizzare l'altra relazione d'ordine.
  */

public class Esame implements Comparable<Esame>{
    private int codice;
    private int voto;
    private int cfu;

    Esame(int codice, int voto, int cfu){
        this.codice = codice;
        this.voto = voto;
        this.cfu = cfu;
    }

    public int get_codice(){
        return this.codice;
    }

    public int get_voto(){
        return this.voto;
    }


    public int get_cfu(){
        return this.cfu;
    }

    public int compareTo(Esame e){
        return this.voto-e.voto;
    }

    public String toString(){
        return "Codice : "+codice+" , Voto : "+voto+" , Cfu : "+cfu;
    }


}
