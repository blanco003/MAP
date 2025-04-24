import java.util.Arrays;

public class Libretto {
    private Esame c[];

    Libretto(int dim){
        c = new Esame[dim];
    }


    Esame min(){
        Arrays.sort(c);
        return c[0];
    }

    Esame min_cfu(){
        Arrays.sort(c, new EsameComparator1());
        return c[0];
    }

    public String toString(){
        String res = "\nLibretto : \n";
        for(int i=0;i<c.length;i++){
            res += c[i].toString()+"\n";
        }
        return res;
    }

    /*  Descrivere l’operazione di riduzione reduce nella estensione funzionale di Java. Scrivere il metodo
        di Libretto che usi una pipeline con reduce per contare il numero di esami con voto maggiore di 28.
        Commentare il codice scritto
    */


    // osserviamo che la traccia richiedeva specificamente un array e non un ArrayList, ma il metodo stream non è applicabile direttamente su un array
    // dunque sfruttiamo il metodo stream() di Arrays che ha in input un array e restituisce uno stream equiavalente


    int conta_esami(){

        return (int)
                Arrays.stream(c)
                            .filter(e->e.get_voto()>28)   
                            .map(e->e.get_voto())
                            .count();
    }

    int conta_esami_reduce(){

        return (int)
                Arrays.stream(c)
                            .filter(e->e.get_voto()>28)
                            .mapToInt(e->e.get_voto())
                            .reduce(0, (a,b)->a+1);
    }

   
    public static void main(String[] args) {
        Libretto l = new Libretto(5);
        l.c[0] = new Esame(1, 24, 6);
        l.c[1] = new Esame(2, 30, 9);
        l.c[2] = new Esame(3, 22, 12);
        l.c[3] = new Esame(4, 29, 12);
        l.c[4] = new Esame(5, 29, 9);

        System.out.println(l.toString());

        System.out.println("\nEsame con voto più basso (Comparable) : " + l.min());
        System.out.println("Esame con cfu più bassi (Comparator) : " + l.min_cfu());

        System.out.println("\n\nProgrammazione Funzionale, esami con voto > 28: " + l.conta_esami());

    }
}
