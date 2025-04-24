import java.util.Comparator;

public class StudenteComparator2 implements Comparator<Studente>{

    /* supponiamo di voler ordinare gli studenti in base al cognome, 
        cerchiamo di ricondurci a metodi compare e equals delle classi Wrapper (in questo caso String) */
        
    public int compare(Studente s1, Studente s2){
        return s1.get_cognome().compareTo(s2.get_cognome());
    }

    public boolean equals(Studente s1, Studente s2){
        if (s1.get_cognome().equals(s2.get_cognome())){
            return true;
        }
        return false;
    }

}