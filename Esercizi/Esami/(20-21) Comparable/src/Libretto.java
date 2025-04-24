import java.util.Arrays;

public class Libretto {
    
    private Esame[] lib;

    Libretto(Integer dim){
        lib = new Esame[dim];
    }

    public Esame mediana(){
        Arrays.sort(lib);
        int len = lib.length;
        if (len % 2 == 0){
            return lib[(len/2) - 1];
        } else {
            return lib[(len - 1) / 2];
        }
    }

    public String toString(){
        String res = "";
        for (Esame esame : lib) {
            res+=esame.toString()+"\n";
        }
        return res;
    }


    /* Programmazione Funzionale : 
        Descrivere l’operazione di riduzione reduce nella estensione funzionale di Java. 
        Scrivere il metodo di Libretto che usi una pipeline con reduce per contare il numero di esami con voto maggiore di 25.
        Commentare il codice scritto
    */

    int conta_voto_maggiore(){
        return Arrays.stream(lib)
                .filter(e->e.get_voto() > 25)
                .mapToInt(e->e.get_voto())
                .reduce(0,(a,b)->a+1);
    }

    public static void main(String[] args) {
        
        Libretto l = new Libretto(5);

        l.lib[0] = new Esame(1, 20);
        l.lib[1] = new Esame(2, 22);
        l.lib[2] = new Esame(3, 24);
        l.lib[3] = new Esame(4, 26);
        l.lib[4] = new Esame(5, 28);

        System.out.println("Libretto : \n"+l.toString());

        System.out.println("\nEsame mediana : "+l.mediana().toString());

        System.out.println("\nEsami con voto > 25 : "+l.conta_voto_maggiore());



    }
}
