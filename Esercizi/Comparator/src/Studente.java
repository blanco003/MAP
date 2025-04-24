
public class Studente {
    private Integer matricola;
    private String cognome;


    Studente(Integer matricola, String cognome){
        this.matricola = matricola;
        this.cognome = cognome;
    }

    public Integer get_matricola(){
        return this.matricola;
    }

    public String get_cognome(){
        return this.cognome;
    }

    public String toString(){
        String str;
        str = "matricola : "+matricola.toString() + " , cognome : "+cognome;
        return str;
    }

}
