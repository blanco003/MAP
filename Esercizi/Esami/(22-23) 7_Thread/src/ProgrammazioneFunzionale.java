import java.util.HashMap;
import java.util.Map;

public class ProgrammazioneFunzionale {

    Map<String,Integer> map;

    ProgrammazioneFunzionale(){
        map = new HashMap<>();
    }

    public void aggiungi(String chiave,Integer valore){
        map.put(chiave, valore);
    }

    public String toString(){
        return map.toString();
    }

    /*
    *  Usando la programmazione funzionale scrivere il metodo che realizza l’operatore restituisce la somma dei valori interi contenuti 
    *  un Map<String, Integer>. La specifica sintattica del metodo è  somma(Map< String, Integer >)→Integer.
    *  Mostrare un main che utilizzi tale metodo e commentare il risultato.
    */



    public int somma(){
        return (int) map
                    .values()
                    .stream()
                    .mapToInt(Integer::intValue)     
                    .sum();
    }


    public int somma_reduce(){
        return (int) map
                    .values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .reduce(0, (a,b)->a+b);
    }
   

     public static void main(String[] args) {
        ProgrammazioneFunzionale p = new ProgrammazioneFunzionale();
        p.aggiungi("Prova1", 1);
        p.aggiungi("Prova2", 4);
        p.aggiungi("Prova3", 6);
        p.aggiungi("Prova4", 3);

        System.out.println(p);

        System.out.println("\n Somma interi: "+p.somma());
        System.out.println("\n Somma interi (reduce): "+p.somma_reduce());

        
     }
}
