import java.util.Comparator;

    // classe che implementa l'interfaccia Comparator e il metodo compare, per realizzare la relazione d'ordine
    // in base al numero di esami

public class StudenteComparator1 implements Comparator<Studente>{
    
    public int compare(Studente s1,Studente s2){
        return s1.get_numero_esami()-s2.get_numero_esami();
    }
}
