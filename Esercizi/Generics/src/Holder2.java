public class Holder2 {

    private Object a;  // essendo che ogni classe è sottoclasse di Object, a può essere rimpiazzato con qualsiasi classe diamo in input (principio di sostitubilità)

    public Holder2(Object a){
        this.a = a;
    }

    public void set(Object a){
        this.a = a;
    }

    public Object get(){
        return this.a;
    }

    public static void main(String[] args) {
        
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile) h2.get();  // get() restituisce un Object ma noi vogliamo assegnarlo ad un Automobile dunque dobbiamo effettuare il cast

        // se non faceesimo il cast il compilatore darebbe errore

        h2.set("Non è un automobile");  // possiamo sovrascrivere l'oggetto contenuto in Holder2 con qualsiasi altro oggetto di classe diversa (in questo caso String)
        String s = (String) h2.get();

        h2.set(1);  // possiamo passare in input anche tipi primitivi, sarà poi effettuato l'autoboxing alla classe Wrapper corrispondente
        Integer x = (Integer) h2.get();

        // in definitiva l'oggetto contentuto in Holder2 può cambiare tipo di classe un numero infito di volte durante il suo tempo di vita
        // finchè effettuiamo il cast correttamente non sorgono problemi
    }

}

 
