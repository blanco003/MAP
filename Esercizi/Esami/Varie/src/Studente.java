import java.io.Serializable;

public class Studente implements Serializable{
    private transient String genere;   // la traccia chiede di non salvarlo -> modificatore transient
    private int numero_esami;
    private double media_voti;

    Studente(String genere, int numero_esami, double media_voti){
        this.genere = genere;
        this.numero_esami = numero_esami;
        this.media_voti = media_voti;
    }

    public String get_genere(){
        return this.genere;
    }

    public int get_numero_esami(){
        return this.numero_esami;
    }

    public double get_media_voti(){
        return this.media_voti;
    }

    public String toString(){
        return "Genere : "+genere+" , Numero esami : "+numero_esami+ " , Media voti : "+media_voti; 
    }
}
