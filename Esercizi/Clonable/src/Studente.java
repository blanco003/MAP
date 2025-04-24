class Studente implements Cloneable {
    private Integer matricola;
    private String cognome;

    public Studente(Integer matricola, String cognome) {
        this.matricola = matricola;
        this.cognome = cognome;
    }

    public Integer getMatricola() {
        return this.matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public boolean equals(Studente p){
        return (p.getMatricola().equals(this.matricola));
    }


    @Override
    public String toString() {
        return "matricola : " + matricola.toString() + ", cognome : " + cognome ;
    }
}