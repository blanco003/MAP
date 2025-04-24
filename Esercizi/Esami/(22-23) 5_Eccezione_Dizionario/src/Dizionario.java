import java.util.TreeMap;

public class Dizionario {

    // scelta del contenitore : 
    // bisogna memorizzare coppie <Chiave,Valore> dunque è un Map
    // l'ordine è importanten dunque è un TreeMap (se non fosse stato importante HashMap)

    // Non è vero. Vale solo per HashMao : Per evitare duplicati dobbiamo andare nella classe Chiave ed implementare hashCode() ed equals() altrimenti
    // vengono presi quelli di Object che lavorano sui riferimenti e non sui valori

    // per implementare la relazione d'ordine dobbiamo andare nella classe Chiave ed implementare l'interfaccia Comparable
    // dunque dobbiamo implementare i metodi equals() e comparTo() 

    TreeMap<Chiave,Valore> diz;

    public Dizionario(){
        diz = new TreeMap<>();
    }

    public void registra(Chiave k,Valore v){
        diz.put(k, v);
    }

    public void rimpiazza(Chiave k,Valore new_v) throws ValoreAssenteException{
        if(!diz.containsKey(k)){
            throw new ValoreAssenteException("La chiave "+k+" non è presente nel Dizionario");
        }
        diz.replace(k, new_v);
    }

    public String toString(){
        return diz.toString();
    }


    // Programmazione funzionale :
    // Realizzare l’operatore somma di Dizionario usando la programmazione funzionale 
    // somma(Dizionario) → Intero // restituisce la somma delle chiavi memorizzate nel dizionario

    // diz è un Map dunque non possiamo applicare .stream(), ma tramite .keySet() possiamo estrarre solo il Set
    // delle chiavi ed applicare .stream()

    int somma(){
        return (int)
                diz.keySet()
                    .stream()
                    .mapToInt(k->k.get_val())
                    .sum();
    }

    // variante con reduce

    int somma_reduce(){
        return diz.keySet()
                    .stream()
                    .mapToInt(k->k.get_val())
                    .reduce(0, (a,b)->a+b);
    }


    public static void main(String[] args) {
        Dizionario d = new Dizionario();
        d.registra(new Chiave(1),new Valore(1.0));
        d.registra(new Chiave(2),new Valore(2.0));
        d.registra(new Chiave(3),new Valore(3.0));
        d.registra(new Chiave(4),new Valore(4.0));


        // riampazza potrebbe restiture un eccezione del tipo ValoreAssenteException
        // dunque o la gestiamo con un try-catch o la continuiamo a propagare 

        try{
            d.rimpiazza(new Chiave(4), new Valore(5.0));  // non si verifica
        }catch(ValoreAssenteException e){
            e.printStackTrace();
        }

        try{
            d.rimpiazza(new Chiave(5), new Valore(5.0));  // si verifica l'eccezione e viene gestita, l'esecuzione continua
        }catch(ValoreAssenteException e){
            e.printStackTrace();
        }


        System.out.println("Dizionario : \n"+d.toString());

        System.out.println("\n\nSomma chiavi : "+d.somma());
        System.out.println("Somma chiavi (reduce): "+d.somma_reduce());

    }
}
