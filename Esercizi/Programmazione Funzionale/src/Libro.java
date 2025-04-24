
/*  Definire la classe che modella una biblioteca come insieme di libri. Ciascun libro è definito dagli attributi,
    autore, titolo e prezzo in modo che la coppia (autore , titolo) sia unica per ciascun libro nella biblioteca

    Esercizi :
    1) Definire in biblioteca il metodo che conta il numero di libri con prezzo maggiore di una determinata
    soglia.
    2) Definire in biblioteca metodo che restituisce la mappa con la lista dei libri raggruppati per autore
    3) Definire in biblioteca il metodo che calcola il numero medio di libri scritti da ciascun autore incluso nella biblioteca 
 */


// la traccia specifica che è un insieme, e non è richiesto di ordinamento, dunque dobbiamo usare HashSet,
// essendo che HashSet non ammette duplicati, dobbiamo implementare sulla classe chiave l'interfaccia Comparator, 
// e sovrascrivere i metodi hashCode ed equals di Object

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.HashSet;


public class Libro implements Comparator<Libro>{

    private String autore;
    private String titolo;
    private double prezzo;

    Libro(String autore, String titolo, double prezzo) {
        this.autore=autore;
        this.titolo=titolo;
        this.prezzo=prezzo;

    }

    double getPrezzo() {
        return prezzo;
    }

    String getTitolo() {
        return titolo;
    }

    String getAutore() {
        return autore;
    }


    // è stabilito che 2 libri sono uguali se hanno stesso autore e stesso titolo, il prezzo non è rilevante
    public boolean equals(Object o){
        Libro l = (Libro)o;  // cast da Object a Libro
        return l.autore.equals(this.autore) && l.titolo.equals(this.titolo);
    }

    public int hashCode(){
        return (autore + titolo).hashCode();      // concateniamo autore e titolo e sfruttiamo hashcode della classe Wrapper String
    }

    @Override
    public int compare(Libro o1, Libro o2) {
        return o1.getTitolo().compareTo(o2.getTitolo());
    }

    public String toString() {
        return autore+ " "+ titolo + " "+ prezzo;
    }

}


class Biblioteca extends HashSet<Libro>{   // avremmo potuto anche usare l'aggregazione invece che estendere



    // 1) Definire in biblioteca il metodo che conta il numero di libri con prezzo maggiore di una determinata soglia.

    int conta(double th) {
               
        return (int)(       // cast ad intero  da long restituito da count()               
                this.stream()           // crea lo stream (sequenza di elementi)
                .filter(l->l.getPrezzo()>=th)   // filtra gli elementi, attraverso una lambda espressione
                .map(l->l.getAutore())   // map trasforma gli elementi considerando solo l'autore
                .count());  // metodo terminale che conta gli elementi presenti nello stream rimasti dopo filter e map (restituisce long)
    }

        // conta con reduce 

        int conta_reduce(double th){

            return (int)(
                this.stream()
                .filter(l->l.getPrezzo()>=th)
                .mapToInt(l->(int)l.getPrezzo())   // trasforma lo stream di libri in stream di interi rappresentati i prezzi
                .reduce(0, (a,b)->a+1));  // combina gli elementi dello stram di interi usando un'operazione di accumulazione.
      
        }

    // prova esame

    int conta_prefisso(){

        return (int) (this.stream()
                            .filter(l->l.getTitolo().startsWith("T1"))
                            .map(l->l.getTitolo())
                            .count());

                            
    }



    // reduce : il primo valore (Detto identity) è il valore iniziale (in questo caso della somma), 
    // il secondo paramento è il valore su cui si vuole lavorare ed è formato da 2 parametri,
    // "a" che è il valore del flusso in quel momento (contatore) ed è inizializzato a 0 e 
    // "b" che è il valore successivo da aggiungere alla somma, ovvero l'elemento corrente dello stream


    //  2) Definire in biblioteca metodo che restituisce la mappa con la lista dei libri raggruppati per autore

    Map<String,List<Libro>> groupby(){
        return this.stream()
                .collect(
                    Collectors.groupingBy(Libro::getAutore));
    }


    // 3) Definire in biblioteca il metodo che calcola il numero medio di libri scritti da ciascun autore incluso nella biblioteca 

    double mediaLibiriPerAutore() {
        Map<String,List<Libro>> map = groupby();
        return map.values()
                    .stream()
                    .mapToInt(l->l.size())
                    .average()
                    .getAsDouble();
    }


    public static void main(String[] args) {
        
        Biblioteca b = new Biblioteca();

        b.add(new Libro("AA","T1",10));
        b.add(new Libro("AA","T2",20));
        b.add(new Libro("AA","T3",30));
        b.add(new Libro("AA","T4",30));
        b.add(new Libro("AA","T5",30));

        b.add(new Libro("AA","T5",30));  // duplicato -> non verrà inserito

        b.add(new Libro("BB","T1",50));
        b.add(new Libro("BB","T2",60));

        b.add(new Libro("CC","T1",70));

        System.out.println("\nBiblioteca :\n "+b.toString());

        System.out.println("\nNumero di libri con prezzo maggiore di 40 : " + b.conta(40) );
        System.out.println("Numero di libri con prezzo maggiore di 40 (reduce): " + b.conta_reduce(40) );

        System.out.println("\nMap della lista dei libri per ogni autore : \n"+ b.groupby());

        System.out.println("\nMedia di libri scritti di ciascun autore : "+ b.mediaLibiriPerAutore());

        System.out.println("\nNumero di libri di cui il titolo comincia con T1 : "+ b.conta_prefisso());

    }
}