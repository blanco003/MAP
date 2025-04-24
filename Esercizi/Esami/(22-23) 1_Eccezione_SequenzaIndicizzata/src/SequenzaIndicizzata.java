import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;


public class SequenzaIndicizzata {
    private LinkedList<Elemento> sequenza;

    public SequenzaIndicizzata(){
        sequenza = new LinkedList<>();
    }

    public void aggiungi(Elemento e){
        sequenza.addFirst(e);
    }

    public Elemento leggi(int index){
        return sequenza.get(index);
    }

    /*  scambia(SequenzaIndicizzata, Intero, Intero)→ SequenzaIndicizzata // scambia gli elementi della
        SequenzaIndicizzata (primo argomento) che occupano le posizioni definite dagli interi specificati come
        secondo e terzo argomento, genera errore se gli interi non sono posizioni valide
    */

    public void scambiaNonControllata(int index1,int index2){
        Elemento temp = sequenza.get(index1);
        sequenza.set(index1, sequenza.get(index2));
        sequenza.set(index2,temp);
    }

    public void scambiaControllata(int index1,int index2) throws IndiciNonValidiException{
        if((index1 < 0 || index1 > sequenza.size()) || (index2 < 0 || index2 > sequenza.size())){
            throw new IndiciNonValidiException("Indici non corretti");
        }
        Elemento temp = sequenza.get(index1);
        sequenza.set(index1, sequenza.get(index2));
        sequenza.set(index2,temp);
    }

    public String toString() {
        return "SequenzaIndicizzata{" + "elementi=" + sequenza+ '}';
    }



    /*  Usando la programmazione funzionale scrivere il metodo della classe SequenzaIndicizzata che
        raggruppa le istanze di Elemento in essa archiviate per nome e stampa a video la media dei valori nei
        gruppi costruiti.
    */

    /* SBAGLIATO : calcola il numero medio di valori, non la media dei valori

    // sciviamo una funzione che divide in gruppi la sequenza in base ai nomi degli elementi uguali
    Map<String,List<Elemento>> groupby(){
        return sequenza.stream().collect(Collectors.groupingBy(Elemento::get_nome));
   
    } 

    double media_per_gruppo(){
        Map<String,List<Elemento>> gruppi = groupby();
        return gruppi.values().stream().mapToDouble(l->l.size()).average().getAsDouble();
    }

     */

    public void stampaMediaPerGruppo() {
        Map<String, Double> mediaPerGruppo = sequenza.stream()
                .collect(Collectors.groupingBy(Elemento::get_nome,
                        Collectors.averagingDouble(Elemento::get_valore)));
    
        mediaPerGruppo.forEach((nome, media) -> System.out.println(nome + ": " + media));
    }


    public static void main(String[] args) {
        SequenzaIndicizzata s = new SequenzaIndicizzata();
        s.aggiungi(new Elemento("nome1", 1));
        s.aggiungi(new Elemento("nome2", 2));
        s.aggiungi(new Elemento("nome3", 3));
        s.aggiungi(new Elemento("nome4", 4));
        System.out.println(s.toString());


        System.out.println("\nProva scambia controllato con eccezione: ");

        /* L'eccezione controllata è rilevata dal compilatore a compile time , dunque dobbiamo per forza inserirla in un try catch 
         * poichè il metodo potrebbe restituire una eccezione IndiciNonValidiException
         * in caso si verificasse l'eccezione, essa viene intercetta e gestita correttamente, duqnque il programma potrà continuare successivamente
         * la sua esecuzione normale
         */ 

         try{
            s.scambiaControllata(1, 10);  
        }catch(IndiciNonValidiException e){
            e.printStackTrace();
        }

        System.out.println("\n"+s.toString());


        System.out.println("\nProva scambia non controllato con eccezione: ");

        /* L'eccezione non controllata non è rilevata dal compilatore a compile time ma si verifica solamente a run time,
         * e poichè il compilatore non la rileva non ci obbliga a gestirla o propagarla, dunque se si verifica a run time l'eccezione
         * semplicemente il programma non sa come gestirla e termina eccezionalemente bloccando la normale esecuzione.
         */

        s.scambiaNonControllata(1, 10);
    
        System.out.println("\n"+s.toString());

    }

    
}
