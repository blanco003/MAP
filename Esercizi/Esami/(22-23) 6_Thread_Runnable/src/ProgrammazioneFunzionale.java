import java.util.HashMap;
import java.util.Map;

public class ProgrammazioneFunzionale {
    Map<Integer,String> map;

    ProgrammazioneFunzionale(){
        map = new HashMap<>();
    }

    public void aggiungi(Integer k,String v){
        map.put(k,v);
    }

    public String toString(){
        return map.toString();
    }

    /*  Usando la programmazione funzionale scrivere il metodo che realizza l’operatore restituisce la somma del valore delle chiavi
        contenute un Map<Integer, String>. La specifica sintattica del metodo è somma(Map<Integer, String>)→Integer
    */

    int somma(){
        return  map.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    int somma_reduce(){
        return map.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .reduce(0, (a,b)->a+b);
    }

    public static void main(String[] args) {
        ProgrammazioneFunzionale p = new ProgrammazioneFunzionale();
        p.aggiungi(1, "prova1");
        p.aggiungi(3, "prova2");
        p.aggiungi(2, "prova3");
        p.aggiungi(4, "prova4");
        p.aggiungi(5, "prova5");

        System.out.println("Map : \n"+p.toString());

        System.out.println("\nSomma delle chiavi : "+p.somma());
        System.out.println("Somma delle chiavi (reduce): "+p.somma_reduce());

    }
}
