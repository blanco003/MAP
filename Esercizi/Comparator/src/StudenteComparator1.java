import java.util.Comparator;

public class StudenteComparator1 implements Comparator<Studente>{

    /* supponiamo di voler ordinare gli studenti in base alla loro matricola, 
        cerchiamo di ricondurci a metodi compare e equals delle classi Wrapper (in questo caso Integer) */
        
    public int compare(Studente s1, Studente s2){
        return s1.get_matricola().compareTo(s2.get_matricola());
    }

    public boolean equals(Studente s1, Studente s2){
        if (s1.get_matricola().equals(s2.get_matricola())){
            return true;
        }
        return false;
    }

}
