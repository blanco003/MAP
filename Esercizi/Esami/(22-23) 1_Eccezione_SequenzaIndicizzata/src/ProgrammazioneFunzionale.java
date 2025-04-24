public class ProgrammazioneFunzionale {
    public static void main(String[] args) {
        SequenzaIndicizzata s = new SequenzaIndicizzata();
        s.aggiungi(new Elemento("nome1", 4));
        s.aggiungi(new Elemento("nome1", 5));
        s.aggiungi(new Elemento("nome1", 11));
        s.aggiungi(new Elemento("nome2", 4));
        s.aggiungi(new Elemento("nome3", 10));
        s.aggiungi(new Elemento("nome3", 3));
        s.aggiungi(new Elemento("nome4", 7));
        s.aggiungi(new Elemento("nome4", 9));

        System.out.println(s.toString());


        System.out.println("\nMedia per gruppi in base al nome : ");

        /* 
        System.out.println(s.groupby());
        System.out.println("\n\n"+s.media_per_gruppo());
        */

        s.stampaMediaPerGruppo();
    }
}
