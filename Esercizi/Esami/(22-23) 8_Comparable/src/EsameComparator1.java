import java.util.Comparator;

/*  Per implementare l'interfaccia Compartor dobbiamo implementare i metodi compare(), il quale ha in input 2 oggetti e restitusice un valore negativo, positivo o 0
 *  in base al risultato del confronto, ed equals() che stabilisce quando 2 esami sono considerati lo stesso esame, assumo che 2 esami sia uguali se hanno stesso codice
 */

public class EsameComparator1 implements Comparator<Esame>{
    
    public int compare(Esame e1,Esame e2){
        return e1.get_cfu()-e2.get_cfu();
    }

    public boolean equals(Esame e1,Esame e2){
        return e1.get_codice() == e2.get_codice();
    }
}
