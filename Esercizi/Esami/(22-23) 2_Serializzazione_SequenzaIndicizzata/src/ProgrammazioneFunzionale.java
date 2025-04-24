public class ProgrammazioneFunzionale {
    public static void main(String[] args) {
        SequenzaIndicizzata s = new SequenzaIndicizzata();
        s.aggiungi(new Elemento("nome1", 1.0));
        s.aggiungi(new Elemento("nome1", 2.0));
        s.aggiungi(new Elemento("nome1", 3.0));
        s.aggiungi(new Elemento("nome1", 4.0));
        s.aggiungi(new Elemento("nome2", 5.0));
        s.aggiungi(new Elemento("nome2", 6.0));
        s.aggiungi(new Elemento("nome3", 7.0));
        s.aggiungi(new Elemento("nome4", 8.0));
        s.aggiungi(new Elemento("nome4", 9.0));
        s.aggiungi(new Elemento("nome4", 10.0));
        s.aggiungi(new Elemento("nome4", 11.0));

        System.out.println("\nNumero di elementi per ogni gruppo, raggruppati per nome : ");
        s.numerosita_gruppi_per_nome();
    }
}
