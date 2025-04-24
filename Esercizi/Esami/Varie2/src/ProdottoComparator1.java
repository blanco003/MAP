import java.util.Comparator;

public class ProdottoComparator1 implements Comparator<Prodotto>{

    // supponiamo la relazione d'ordine meno usata sia quella sul nome
    
    public int compare(Prodotto p1, Prodotto p2){
        return p1.get_nome().compareTo(p2.get_nome());
    }
}
