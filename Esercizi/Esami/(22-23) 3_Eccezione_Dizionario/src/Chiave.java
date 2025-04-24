public class Chiave {
    private String id;

    Chiave(String id){
        this.id = id;
    }

    public String get_id(){
        return this.id;
    }

    public int hashCode(){
        return id.hashCode();
    }

    public boolean equals(Object o){
        return id.equals(((Chiave)o).get_id());
    }

    public String toString(){
        return this.id;
    }
}
