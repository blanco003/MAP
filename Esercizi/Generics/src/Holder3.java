
  //ora vogliamo che una volta specificato ed inizializzato il tipo di oggetto contenuto in Holder non cambi più durante il suo tempo di vita

public class Holder3<T> {         // T parametro di tipo generico
    
    private T a;

    public Holder3(T a){
      this.a = a;
    }

    public void set(T a){
      this.a = a;
    }

    public T get(){
      return a;
    }

    // è anche possibile definire metodi che prendono in input e/o restituiscono tipi generici
    public <T> void f(T x){
      System.out.println(x.getClass().getName());
    }


    public static void main(String[] args) {

      Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
      Automobile a = h3.get();   // non c'è più bisogno di fare il cast poichè il tipo è stato già definito all'inizializzazione

      // h3.set("Non è un automobobile")  // non è possibile cambiare più il tipo da Automobile a String

      Holder3<String> h4 = new Holder3<String>("Non è un automobile");
      String b = h4.get();

      //Holder3<int> h5 = new Holder3<int>(); //Errore perchè non si può inizializzare un tipo di dato primitivo
    
      // se il tipo non viene specificato all'inzializzazione (<>) il compilatore lo assume di tipo Object (principio di sostituibilità all'indietro)

      h3.f(1);  
      h3.f("1");


      /* Osserviamo che non è disponibile alcuna informazione sui tipi di parametri generici all'interno del codice generico,
       Le generics di java sono state implementate usando l'erasure (cancellazione), questo significa che ogni informazione di tipo
       è cancellata quando si ricorre all'astrazione generica.
     */

     System.out.println(h3.getClass() == h4.getClass());  // mi aspetto true

     // non si ha alcuna informazione sul tipo di parametro genericio delle classi, quindi Holder3<Automobile> e Holder3<String> sono di fatto,
     // a run time, dello stesso tipo, ovvero Holder3
  
    }
    
}
