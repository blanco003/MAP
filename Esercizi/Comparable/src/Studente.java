
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

    public int compareTo(Studente s){
        return this.numero_esami - s.get_numero_esami();
    }


}
