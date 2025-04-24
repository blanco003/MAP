
public class Studente implements Comparable<Studente>{
    private Integer matricola;
    private String cognome;
    private Integer numero_esami;


    Studente(Integer matricola, String cognome, Integer numero_esami){
        this.matricola = matricola;
        this.cognome = cognome;
        this.numero_esami = numero_esami;
    }

    public Integer get_matricola(){
        return this.matricola;
    }

    public String get_cognome(){
        return this.cognome;
    }

    public Integer get_numero_esami(){
        return this.numero_esami;
    }

    public String toString(){
        String str;
        str = "matricola : "+matricola.toString() + " , cognome : "+cognome+ " , num_esami : "+numero_esami.toString();
        return str;
    }

    // (usato per HashSet, HashMap) stabiliamo che 2 studenti sono la stessa persona se hanno la stessa matricola
    public boolean equals(Object o){
        return ((Studente)o).get_matricola().equals(this.matricola);
    }

    // (usato per HashSet, HashMap) implementiamo hashCode sfruttando hashCode di una delle classi Wrapper in modo da non doverlo implementare noi
    public int hashCode(){
        return this.matricola.hashCode();
    }

    //  (usato per TreeSet, TreeMap) implementiamo il metodo compareTo che confronta 2 studenti sulla base della matricola e restituisce un valore positivo se la prima è maggiore,
    // un valore negativo se minore, e 0 se coincidono
    public int compareTo(Studente s){
        return this.matricola-s.get_matricola();
    }
}