import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

 // HashMap : contiene elementi che sono copie (Chiave,Valore), inoltre non sono ammessi duplicati e non è stabilita una relazione d'ordine
 // per garantire l'assenza di duplicati dobbiamo andare nella classe Chiave ed implementare i metodi hashCode ed equals

 // se non implementassi i metodi hashCode ed equals per controllare se la chiave è un duplicato, verrebbero utilizzati quelli di Object che confrontano
 // i riferimenti e non i valori, dunque nel dizionario si sarebbero potute registrare chiavi uguali

 // ora non sono ammesse chiavi duplicate, tuttavia se provassimo ad inserire una chiave già presente per definizione viene rimpiazzato il valore corrispodente
 // con il nuovo valore in input

public class Dizionario implements Serializable{ 
    private HashMap<Chiave,Valore> d;

    Dizionario(){
        d = new HashMap<Chiave,Valore>();
    }

    public void registra(Chiave k,Valore v){
        d.put(k, v);
    }

    public void rimpiazza(Chiave k,Valore new_v) throws ChiaveNonPresenteException{
        if(d.containsKey(k)){
            d.put(k, new_v);
        }else{
            throw new ChiaveNonPresenteException("La chiave "+k+" non è presente nel dizionario");
        }
    }

    public String toString(){
        return d.toString();
    }

    // serializzazione

    public void salva() throws IOException, FileNotFoundException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("prova.dat"));
        out.writeObject(this);
        out.close();
    }

    // de-serializzazione

    public static Dizionario carica() throws IOException, FileNotFoundException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("prova.dat"));
        Dizionario d = (Dizionario) in.readObject();
        in.close();
        return d;
    }


    // PROGRAMMAZIONE FUNZIONALE :
    // Realizzare l’operatore conta di Dizionario usando la programmazione funzionale commentando le decisioni prese.


    /*  ! ! osserviamo che Dizionario fa parte dei Map, tuttavia la sorgente della pipeline non può essere un Map ma solo una Collection,
            dunque se ci serve effettuare delle operazioni solo sui Valori del dizionario 
            estraiamo dal Dizionario solo la Collection dei Valori con .values(),
            viceversa se ci serve effettuare delle operazioni solo sulle Chiavi del dezionario
            estraiamo dal Dizionario solo la Collection delle Chiavi con .keySet()
    */

    int conta(){
        return (int)      // count restituisce un long, dunque facciamo il cast ad int
            d.values()    // consideriamo solo la Collection dei valori
            .stream()
            .count();
    }

    int conta_reduce(){
        return (int)        // reduce restituisce un double, dunque facciamo il cast ad int
                d.values()
                .stream()
                .mapToDouble(v->v.get_val())
                .reduce(0,(a,b)->a+1);
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException{      // o propaghiamo le eccezioni e mettiamo salva e carica in un try catch

        Dizionario d = new Dizionario();
        d.registra(new Chiave("chiave 1"), new Valore(1.0));
        d.registra(new Chiave("chiave 2"), new Valore(2.0));
        d.registra(new Chiave("chiave 3"), new Valore(3.0));
        d.registra(new Chiave("chiave 3"), new Valore(4.0));  // verrà rimpiazzato il vecchio valore perchè la chiave è già presente
        d.registra(new Chiave("chiave 4"), new Valore(5.0));

        System.out.println("\nDizionario che stiamo salvando su file: \n"+d.toString());

        d.salva();

        Dizionario d_letto = carica();
        System.out.println("\nDizionario letto da file : \n"+d_letto.toString());

        System.out.println("\nConta : "+d.conta());
        System.out.println("Conta (reduce): "+d.conta_reduce());



    }
}
