
/* Per copia di un oggetto significa copia dello stato (deep coopy), tuttavia l'operatore = non effettua una copia dei valori ma bensì dei riferimenti.
   Per effettuare una deep copy dobbiamo implementare Clonable nella classe di cui desideriamo clonare un'istanza, ed implementare il metodo clone().
 */

public class Tester {
    public static void main(String[] args) {
        try {
            Studente s1 = new Studente(111, "Rossi");
            Studente s2 = (Studente) s1.clone();   // restituirà un Object , dobbiamo quindi fare il cast a Studente

            System.out.println("Studente 1: " + s1.toString());
            System.out.println("Studente 2: " + s2.toString());

            // stabiliamo che 2 studenti sono la stessa persona se hanno la stessa matricola (sovrascriviamo equals di Studente)

            // confrontando i riferimenti (==) dovremmo ottenere che non sono lo stesso studente poichè sono in effetti 2 oggetti distinti            
            System.out.println("s1 == s2: " + (s1 == s2));

            // confrontando però sulla base dei valori (quindi sulla matricola, equals sovrascritto) dovremmo ottenere che sono lo stesso studente poichè le matricole coincidoni
            System.out.println("s1.equals(s2): " + s1.equals(s2)); 

        } catch (CloneNotSupportedException e) {        // se la classe non implementa Clonable viene generata l'eccezione CloneNotSupported
            e.printStackTrace();
        }
    }
}
