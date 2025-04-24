
import java.util.HashMap;

public class Dizionario {
    private HashMap<Chiave,Valore> diz;
    
    Dizionario(){
        diz = new HashMap<>();
    }

    public void aggiungi(Chiave k,Valore v){
        diz.put(k, v);
    }

    public boolean appartiene(Chiave k) throws DizionarioVuotoException{
        if(diz.isEmpty()){
            throw new DizionarioVuotoException("Dizionario vuoto");
        }
        if(diz.containsKey(k)){
            return true;
        }
        return false;
    }

    public String toString(){
        return diz.toString();
    }


    // Programmazione funzionale
    // Usando la programmazione funzionale scrivere il metodo che, in Dizionario, realizza l’operatore
    // conta(Dizionario, Valore)→Intero che conta le occorrenze di valore nel dizionario. Commentare le scelte fatte.

    int conta(Valore val){

        return (int) 
                diz.values()
                        .stream()
                        .filter(v->v.get_val().equals(val.get_val()))
                        .count();
    }


    int conta_reduce(Valore val){
        return diz.values()
                        .stream()
                        .filter(v->v.get_val().equals(val.get_val()))
                        .map(v->1)
                        .reduce(0,(a,b)->a+1);
    }


    public static void main(String[] args) {
        Dizionario d = new Dizionario();

        try{
            System.out.println("Controllo se id3 è presente :  "+d.appartiene(new Chiave("id3")));
            
        }catch(DizionarioVuotoException e){
            e.printStackTrace();
        }

        d.aggiungi(new Chiave("id1"),new Valore("val1"));
        d.aggiungi(new Chiave("id2"),new Valore("val2"));  
        d.aggiungi(new Chiave("id3"),new Valore("val3")); 
        d.aggiungi(new Chiave("id4"),new Valore("val3")); 
        d.aggiungi(new Chiave("id5"),new Valore("val3")); 

        System.out.println("Dizionario : \n "+d.toString());

        try{
            System.out.println("Ricontrollo se id3 è presente :  "+d.appartiene(new Chiave("id3")));
            
        }catch(DizionarioVuotoException e){
            e.printStackTrace();
        }

        System.out.println("\n\nConta id3 : "+d.conta(new Valore("val3")));
        System.out.println("Conta id3 (reduce): "+d.conta_reduce(new Valore("val3")));
    }
}

