import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class Test {
    public static void main(String[] args){
 
         /* I contenitori in Java si basano su 2 distinti concetti : 
            - Collection : gruppo di singoli elementi a cui spesso sono applicati dei vincoli (Interfacce List e Set)
            - Map : grippo di coppie (chiave, valore)
         */   


        /*Interfaccia List : Mantiene gli elementi nell'ordine in cui sono inseriti, fornisce metodi per l'inserimento e l'eliminazione dei suoi elementi.
                            Sono ammessi duplicati. Per specializzare il comportamento di List sono disponibili le sottoclassi ArrayList e LinkedList.
         
         */

        /* ArrayList : gli elementi vengono memorizzati in un'area di memoria contigua, si accede agli elementi tramite il loro indice,
                       permettete un accesso rapido agli elementi ma risulta lento nell'inserire o rimuovere gli elementi 
                       (specialemente al centro del contenitore) poichè sono richiesti shift. 
                       Se l'array si riempie, viene creato un nuovo array di dimensioni maggiori e gli elementi vengono copiati nel nuovo array.
         */

        ArrayList<Studente> studenti_array = new ArrayList<>();

        studenti_array.add(new Studente(111,"Rossi", 5));
        studenti_array.add(new Studente(222,"Verdi", 15));
        studenti_array.add(new Studente(333,"Bianchi", 25));

        System.out.println("\nArrayList : ");
        //System.out.println(studenti_array);

        Iterator<Studente> it = studenti_array.iterator(); 
        while(it.hasNext()){
            System.out.println(((Studente)it.next()).toString());
        }
        
        /* LinkedList : basata sull'utilizzo di una lista collegata, ovvero ogni elemento è memorizzato in un nodo che oltre al valore contiene
                        il riferimento al nodo successivo. Fornisce un ottimo accesso sequenziale con inserimenti ed eliminazioni poco costosi (anche al centro delle List). 
                        Risulta relativamente lenta negli accessi diretti. 
         
         */

        LinkedList<Studente> studenti_linked = new LinkedList<>();

        studenti_linked.add(new Studente(444,"Rossi", 5));
        studenti_linked.add(new Studente(555,"Verdi", 15));
        studenti_linked.add(new Studente(666,"Bianchi", 25));

        System.out.println("\nLinkedList : ");
        //System.out.println(studenti_linked);

        Iterator<Studente> it2 = studenti_linked.iterator(); 
        while(it2.hasNext()){
            System.out.println(((Studente)it2.next()).toString());
        }


        /* Interfaccia Set : contiene elementi (solo un istanza di ogni valore), non garantisce l'ordine degli ogetti inseriti. 
                             Rappresenta quindi un insieme, ovvero non sono ammessi valori duplicati.
                             L’univocità degli elementi è stabilita mediante il metodo equals() (!! che dobbiamo sovrascrivere noi, altrimenti viene considerato quello di Object,
                             il quale confronta i riferimenti e non i valori)
                             Per specializzare il comportamento di List sono disponibili le sottoclassi HashSet e TreeSet.
         */


        /* HashSet : insieme basato sull'utilizzo di una tavola hash. Tempi di accesso brevi. Per calcolare la posizione in cui memorizzare l'elemento nella tavola hash, 
                      viene chiamata la funzione hashCode(), che è stata implementata in Object ma che noi dobbiamo sovrascire in quanto viene calcolata sui riferimenti e non sui valori.
        */

        HashSet<Studente> studenti_hashset = new HashSet<>();
        //  andiamo ad implementare in Studente i metodi hashCode ed equals

        studenti_hashset.add(new Studente(444,"Rossi", 5));
        studenti_hashset.add(new Studente(555,"Verdi", 15));
        studenti_hashset.add(new Studente(666,"Bianchi", 25));
        studenti_hashset.add(new Studente(666,"Verdi", 12)); // non dovrebbe essere aggiunto

        System.out.println("\nHashSet : ");
        //System.out.println(studenti_hashset);

        Iterator<Studente> it3 = studenti_hashset.iterator();
        while(it3.hasNext()){
            System.out.println(((Studente)it3.next()).toString());
        }


        /* TreeSet : insieme ordinato attraverso un albero binario, per garantire la relazione d'ordine tra gli elementi è necessario implementare Comparable o Comparator.
                       La ricerca degli elementi e le operazioni sono efficienti.
           
        */

        TreeSet<Studente> studenti_treeset = new TreeSet<>();
        // dobbiamo implementare una delle interfacce per confrontare gli studenti tra loro
        // scegliamo Comparable, quindi andiamo in Studente per implementare il metodo compareTo

        studenti_treeset.add(new Studente(444,"Rossi", 5));
        studenti_treeset.add(new Studente(555,"Verdi", 15));
        studenti_treeset.add(new Studente(666,"Bianchi", 25));
        studenti_treeset.add(new Studente(666,"Verdi", 12)); // non dovrebbe essere aggiunto


        // osserviamo che gli elementi memorizzati sono uguali come nel caso di HashSet ma qui saranno ordinati in base al criterio scelto da noi (matricola crescente)

        System.out.println("\nTreeSet : ");
        //System.out.println(studenti_treeset);

        Iterator<Studente> it4 = studenti_treeset.iterator();
        while(it4.hasNext()){
            System.out.println(((Studente)it4.next()).toString());
        }



        /* Interfaccia Map : contieme elementi formati dalla coppia (Chiave, Valore). Permette di accedere agli oggetti di un contenitore attraverso 
                             un altro oggetto (Chiave) (contrariamente a quanto accadeva negli ArrayList, dove serviva un numero (indice)).
                             A tale scopo abbiamo i seguenti metodi:
                             - put (Object key, Object value): aggiunge un valore e lo associa con una chiave, se la chiave è già presente viene aggioranto il valore corrispondente
                             - get(Object key): restituisce il valore corrispondente alla chiave; 
                             - containsKey(Object key), containsValue(Object value): verifica se Map contiene un valore o una chiave.
                             La libreria standard di Java include due tipi differenti di Map: HashMap e TreeMap
        */


        /* HashMap : garantisce elevate prestazioni per la ricerca di una chiave perché è una implementazione basata sulla tabella hash. Infatti ogni oggetto Java può 
                     produrre un codice hash (di tipo int) attraverso il metodo hashCode() definito nella classe Object. HashMap utilizza tale codice per effettuare 
                     una ricerca efficiente sugli elementi.

                    !! i metodi hashCode ed equals devono essere sovrascritti solo nella classe che fa da Chiave, non ha senso sovrascriverli anche nella classe Valore
        */


        HashMap<Studente,Counter> studenti_hashmap = new HashMap<>();
        //  andiamo ad implementare nella classe Chiave (Studente) i metodi hashCode ed equals

        studenti_hashmap.put(new Studente(555,"Rossi", 5), new Counter(1));
        studenti_hashmap.put(new Studente(111,"Blui", 15), new Counter(2));
        studenti_hashmap.put(new Studente(333,"Bianchi", 25), new Counter(3));
        studenti_hashmap.put(new Studente(333,"Verdi", 45), new Counter(7));  //non verrà inserito tuttavia aggiornerà il counter della chiave corrispondentente

        System.out.println("\nHashMap :");
        //System.out.println(studenti_hashmap);

        Iterator<Map.Entry<Studente, Counter>> it5 = studenti_hashmap.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry<Studente, Counter> entry = it5.next();
            System.out.println("Studente: " + entry.getKey().toString() + ",     Counter : " + entry.getValue().toString());
        }
    
        /* TreeMap : le coppie (Chiave, Valore) sono ordinate secondo un criterio da noi definito (Comparable o Comparator)  */

        TreeMap<Studente,Counter> studenti_treemap = new TreeMap<>();
        // scegliamo di usare Comparable, dunque andiamo nella classe Chiave (Studente) ad implementare il metodo compareTo

        studenti_treemap.put(new Studente(555,"Rossi", 5), new Counter(1));
        studenti_treemap.put(new Studente(111,"Blui", 15), new Counter(2));
        studenti_treemap.put(new Studente(333,"Bianchi", 25), new Counter(3));
        studenti_treemap.put(new Studente(333,"Verdi", 45), new Counter(7));  //non verrà inserito tuttavia aggiornerà il counter della chiave corrispondentente

        // osserviamo che gli elementi memorizzati sono uguali come nel caso di HashMap ma qui saranno ordinati in base al criterio scelto da noi (matricola crescente)

        System.out.println("\nTreeMap : ");
        //System.out.println(studenti_treemap);
        
        Iterator<Map.Entry<Studente, Counter>> it6 = studenti_treemap.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry<Studente, Counter> entry = it6.next();
            System.out.println("Studente: " + entry.getKey().toString() + ",     Counter : " + entry.getValue().toString());
        }


    }

    


}
