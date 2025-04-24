import java.util.Comparator;

    // classe che implementa l'interfaccia Comparator e il metodo compare, per realizzare la relazione d'ordine
    // in base alla media dei voti

public class StudenteComparator2 implements Comparator<Studente>{
    
    public int compare(Studente s1,Studente s2){
        return (int) (s1.get_media_voti()-s2.get_media_voti());  // cast ad int
    }
}
