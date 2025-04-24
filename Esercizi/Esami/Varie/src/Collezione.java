import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Collezione implements Serializable{
    
    // sono contenuti elementi singoli ovvero Studenti (dunque non è un Map)
    // osserviamo che sono ammessi duplicati (dunque non è un Set) 
    // l'operazione più frequente è la stampa dello Studente tramite la sua posizione,
    // questo ci porta a scegliere il contenitore ArrayList in quanto permette un accesso più rapido 
    // ai suoi elementi tramite indice, rispetto alla LinkedList che risulta "relativamente" lenta negli accessi.
    // (se fosse stato più importante l'inserimento e cancellazione avremmo scelto LinkedList)

    private ArrayList<Studente> collezione;

    Collezione(){
        collezione = new ArrayList<>();
    }

    public void aggiungi(Studente s){
        collezione.add(s);
    }

    Studente max(Comparator<Studente> c){   // gli passiamo un oggetto Comparator del quale vogliamo usare la relazione d'ordine
        collezione.sort(c);
        return collezione.getLast();  // l'ultimo nell'ArrayList è il massimo
    }

    public String toString(){
        return collezione.toString();
    }


    // serializzazione
    public void salva() throws IOException,FileNotFoundException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("prova.dat"));
        out.writeObject(this);
        out.close();
    }

    // de-serializzazione
    public static Collezione carica() throws IOException, FileNotFoundException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("prova.dat"));
        Collezione c = (Collezione) in.readObject();
        in.close();
        return c;
    }

    // Programmazione funzionale : 
    // scrivere il metodo di Collezione che usi una pipeline con reduce per restituire 
    // lo studente di genere “female” nella collezione che ha sostenuto il più alto numero di esami

    Studente female_piu_esami(){
        return collezione
                    .stream()
                    .filter(s->s.get_genere().equals("female"))
                    .reduce((s1, s2) -> {
                        if (s1.get_numero_esami() > s2.get_numero_esami()) {
                            return s1;
                        } else {
                            return s2;
                        }
                    }).orElse(null);
    }


    public static void main(String[] args) throws IOException,FileNotFoundException,ClassNotFoundException{

        Collezione c = new Collezione();
        
        c.aggiungi(new Studente("male", 4, 22));
        c.aggiungi(new Studente("female", 5, 20));
        c.aggiungi(new Studente("male", 6, 24));
        c.aggiungi(new Studente("female", 3, 30));

        System.out.println("Collezione : \n"+c.toString());

        System.out.println("\nStudente con numero di esami max : "+c.max(new StudenteComparator1()).toString());
        System.out.println("Studente con media voti max : "+c.max(new StudenteComparator2()).toString());

        System.out.println("\nscrivo su file.....");
        c.salva();

        System.out.println("\nleggo da file.....");
        Collezione c_letta = Collezione.carica();

        System.out.println("\n\nCollezione letta da file : \n"+c_letta.toString());
        // osserviamo che l'attributo sarà sempre null perchè abbiamo scelto di non memorizzarlo (transient)

        System.out.println("\n\nFemale con numero esami max : "+c.female_piu_esami().toString());

        
    }
}
