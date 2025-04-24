import java.util.Arrays;


/*  Vogliamo stabilire un ordinamento tra gli studenti, scegliamo di seguire la strada dell'interfaccia Comparator,
    possiamo scrivere quante classi comparator vogliamo in base al tipo di ordinamento che vogliamo effettuare, in ognuna delle quali dobbiamo implementare
    i metodi compare ed equals.
     
    Al momento dell'ordinamento passeremo come parametro di input della funzione di ordinamento 
    la classe Comparator che implementa la scelta di ordinamento che desideriamo.
 */

public class Tester {
         public static void main(String[] args){

        Studente[] studenti = new Studente[6];

        studenti[0] = new Studente(333, "Rossi");
        studenti[1] = new Studente(111, "Verdi");
        studenti[2] = new Studente(555, "Bianchi");
        studenti[3] = new Studente(777, "Blui");
        studenti[4] = new Studente(888, "Zeta");
        studenti[5] = new Studente(222, "Alpha");

       for(int i=0; i < studenti.length; i++){
            System.out.println(studenti[i].toString());
       }

        // ordinamento per matricola : 
        Arrays.sort(studenti, new StudenteComparator1());   // gli passo come parametro l'oggetto delle classe Comparatore che contiene la relazione d'ordine che voglio usare

        System.out.println("\nStudenti ordinati per matricola : ");
        for(int i=0; i < studenti.length; i++){
            System.out.println(studenti[i].toString());
       }

        // ordinamento per cognome : 
        Arrays.sort(studenti, new StudenteComparator2());

        System.out.println("\nStudenti ordinati per cognome : ");
        for(int i=0; i < studenti.length; i++){
            System.out.println(studenti[i].toString());
        }

    }
}
