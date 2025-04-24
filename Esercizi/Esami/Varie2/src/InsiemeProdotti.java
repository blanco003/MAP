import java.util.HashSet;

public class InsiemeProdotti {
    // un insieme di Prodotti distinti e non necessariamente ordinati (InsiemeProdotti). 

    // dobbiamo memorizzare singoli elementi, dunque è un Set
    // l'ordine non è importante, dunque è un HashSet

    // per verificare l'univocità dobbiamo implementare nella classe Prodotto i metodi
    // hashCode ed equals, altrimenti vengono presi quelli di Object che confrontano i riferimenti
    // e non i valori

    private HashSet<Prodotto> insieme;

    InsiemeProdotti(){
        insieme = new HashSet<>();
    }

    public void aggiungi(Prodotto p){
        insieme.add(p);
    }

    public String toString(){
        return insieme.toString();
    }

    public static void main(String[] args) {

        InsiemeProdotti i = new InsiemeProdotti();

        i.aggiungi(new Prodotto(1, "nome1", 1.0));
        i.aggiungi(new Prodotto(1, "nome2", 2.0));
        i.aggiungi(new Prodotto(2, "nome2", 2.0));
        i.aggiungi(new Prodotto(3, "nome3", 2.0));

        System.out.println("Insieme : \n"+i.toString());
    }
}
