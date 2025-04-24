import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;


public class SequenzaIndicizzata implements Serializable{    // la classe da serializzare e tutte le classi collegate ad essa devono implementare Serializable
    private ArrayList<Elemento> sequenza;

    SequenzaIndicizzata(){
        sequenza = new ArrayList<>();
    }

    public void aggiungi(Elemento e){
        this.sequenza.add(e);
    }
    
    public void salva() throws IOException,FileNotFoundException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("prova.dat"));
        out.writeObject(this);
        out.close();

    }

    public static SequenzaIndicizzata carica() throws IOException, FileNotFoundException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("prova.dat"));
        SequenzaIndicizzata s  = (SequenzaIndicizzata) in.readObject();
        in.close();
        return s;
        
    }



    public String toString(){
        String res = "";
        Iterator<Elemento> it = sequenza.iterator();
        while(it.hasNext()){
            res += ((Elemento)it.next()).toString()+"\n";
        }
        return res;
        
    }


    /* Programmazione funzionale : Usando la programmazione funzionale scrivere il metodo della classe SequenzaIndicizzata che
                                   raggruppa le istanze di Elemento in essa archiviate per nome e stampa a video la numerosità nei gruppi
                                   costruiti.
    */ 

    void numerosita_gruppi_per_nome(){
        
        // divide lo stream in gruppi in base al nome
        Map<String,List<Elemento>> map = sequenza.stream().collect(Collectors.groupingBy(Elemento::get_nome));

        // conta gli elementi di ogni gruppo e gli stampa
        map.forEach((nome, listaElementi) -> System.out.println(nome + ": " + listaElementi.size()));
        
    }



    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        SequenzaIndicizzata s = new SequenzaIndicizzata();

        s.aggiungi(new Elemento("nome1", 1.0));
        s.aggiungi(new Elemento("nome2", 2.0));
        s.aggiungi(new Elemento("nome3", 3.0));

        System.out.println("\n\nSequenzaIndicizzata che stiamo scrivendo sul file : ");
        System.out.println(s.toString());
        s.salva();
        
    
        
        SequenzaIndicizzata s_letta = SequenzaIndicizzata.carica();
        
        System.out.println("\nSequenza indicizzata letta dal file : ");
        System.out.println(s_letta.toString());
      
        
    }
}
