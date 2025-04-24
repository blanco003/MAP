import java.util.Comparator;
import java.util.TreeSet;

public class InsiemeProdottiOrdinato {
    // un insieme di Prodotti distinti e ordinati rispetto a un criterio (InsiemeProdottiOrdinato) 

    // dobbiamo memorizzare singoli elementi, dunque è un Set
    // l'ordine è importante, dunque è un TreeSet

    // per verificare l'univocità dobbiamo implementare nella classe Prodotto i metodi
    // hashCode ed equals, altrimenti vengono presi quelli di Object che confrontano i riferimenti
    // e non i valori


    // I criteri per l'ordinamento possibili sono due: ordinare rispetto a nome oppure ordinare rispetto a codice prodotto.  


    // abbiamo 2 scelte : 
    // 1) ignorare Comparable e scrivere 2 classi Comparator
    // 2) usare il metodo compareTo() di Comparable per implementare la relazione d'ordine usata più frequentemente
    //    e scrivere una classe Comparator per la restante relazione d'ordine

    // scegliamo la 2.

    private TreeSet<Prodotto> insieme_ordinato;

    InsiemeProdottiOrdinato(){
        insieme_ordinato = new TreeSet<>();  // usera la relazione d'ordine di Comparable (sul codice)
    }

    InsiemeProdottiOrdinato(Comparator<Prodotto> c){
        insieme_ordinato = new TreeSet<>(c);   // usera la relazione d'ordine di Comparator (sul nome)
    }

    public void aggiungi(Prodotto p){
        insieme_ordinato.add(p);
    }

    public String toString(){
        return insieme_ordinato.toString();
    }

    public static void main(String[] args) {

        InsiemeProdottiOrdinato ins_ord_comparable = new InsiemeProdottiOrdinato();  // senza argomenti usa la relazione d'ordine di Compare

        ins_ord_comparable.aggiungi(new Prodotto(4, "nome4", 2.0));
        ins_ord_comparable.aggiungi(new Prodotto(5, "nome5", 2.0));
        ins_ord_comparable.aggiungi(new Prodotto(1, "nome1", 1.0));
        ins_ord_comparable.aggiungi(new Prodotto(1, "nome2", 2.0));
        ins_ord_comparable.aggiungi(new Prodotto(2, "nome2", 2.0));
        ins_ord_comparable.aggiungi(new Prodotto(3, "nome3", 2.0));

        System.out.println("Insieme ordinato per codice: \n"+ins_ord_comparable.toString());


        InsiemeProdottiOrdinato ins_ord_comparator = new InsiemeProdottiOrdinato(new ProdottoComparator1()); 

        ins_ord_comparator.aggiungi(new Prodotto(4, "2", 2.0));
        ins_ord_comparator.aggiungi(new Prodotto(5, "1", 2.0));
        ins_ord_comparator.aggiungi(new Prodotto(1, "3", 1.0));
        ins_ord_comparator.aggiungi(new Prodotto(1, "4", 2.0));
        ins_ord_comparator.aggiungi(new Prodotto(2, "5", 2.0));
        ins_ord_comparator.aggiungi(new Prodotto(3, "6", 2.0));

        System.out.println("\n\nInsieme ordinato per nome : \n"+ins_ord_comparator.toString());
    }
    
}
