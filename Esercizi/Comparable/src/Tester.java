import java.util.Arrays;


/*  Vogliamo stabilire un ordinamento tra gli studenti, scegliamo di seguire la strada dell'interfaccia Comparable.
    Osserviamo che possiamo implementare una sola volta il metodo compareTo, ovvero possiamo stabilire solo un tipo di ordinamento tra gli studenti,
    se necessitassimo di più tipi di ordinamento (oltre a quello stabilito) dovremmo ricorrere all'interfaccia Comparator.
    Scegliamo di ordinare gli studenti in ordine crescente di esami fatti.
 */

public class Tester {
         public static void main(String[] args){

        Studente[] studenti = new Studente[6];

        studenti[0] = new Studente(333, "Rossi",4);
        studenti[1] = new Studente(111, "Verdi",0);
        studenti[2] = new Studente(555, "Bianchi",10);
        studenti[3] = new Studente(777, "Blui",2);
        studenti[4] = new Studente(888, "Zeta",8);
        studenti[5] = new Studente(222, "Alpha",3);

       for(int i=0; i < studenti.length; i++){
            System.out.println(studenti[i].toString());
       }

        // ordinamento per numero esami crescente: 
        Arrays.sort(studenti);  // sfrutterà il metodo compareTo implementato in Studente

        System.out.println("\nStudenti ordinati per cognome : ");
        for(int i=0; i < studenti.length; i++){
            System.out.println(studenti[i].toString());
        }

    }
}
