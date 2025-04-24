import java.util.ArrayList;

class Cat{ 
    public void print(){
        System.out.println("Cat");
    }
}

class Dog{ 
    public void print(){
        System.out.println("Dog");
    }
}

public class Test {
    public static void main(String[] args) throws Exception {

        // creiamo un ArrayList (non parametrizzato) ed inseriamo dei Cat
        ArrayList a = new ArrayList();

        
        for(int i = 0; i < 3; i++){
            a.add(new Cat());
        }

        // non ci sono problemi ad insirire anche un Dog, il compilatore lo permette
        a.add(new Dog());


        // tuttavia la presenza del Dog è rilevata a run time

        /* 
        for(int i=0 ; i< a.size(); i++){
            ((Cat)a.get(i)).print();
            // quando si arriva all'istanza Dog non si riesce ovviamente a fare il cast a Cat e viene generata un'eccezione ClassCastException
        }
        */

        // dovremmo dunque effettuare il tipo di cast corretto in base all'istanza di Cat/Dog che leggiamo in quel momento

        /* un metodo è quello di usare i metodi getClass() e getName() :
           - getClass() è un metodo della classe Object, che chiamato su un oggetto restituisce il riferimento all'object class di cui l'oggetto è istanza
           - getName() restituisce il nome della classe come stringa

           confrontando il risultato di getName con i nomi delle classi di cui abbiamo dubbi sui tipi di cast, riusciamo a capire il cast corretto da fare
         
         */

        System.out.println("\nMedoto getClass e getName : ");

        for(int i=0 ; i< a.size(); i++){

            Object o = a.get(i);   // get(i) restituisce il riferimento all'i-esimo oggetto contenuto nell'arraylist
            Class c = o.getClass();

            if(c.getName().equals("Cat")){
                ((Cat)o).print();
            }

            if(c.getName().equals("Dog")){
                ((Dog)o).print();
            }
        }


        /* un altro metodo è quello di usare la parola chiave instanceOf che indica se l'oggetto è istnza di un particolare tipo e 
           restituisce un boolean
        */

        System.out.println("\nMetodo instanceOf : ");

        for(int i=0 ; i< a.size(); i++){

            Object o = a.get(i);

            if(o instanceof Cat){
                ((Cat)o).print();
            }

            if(o instanceof Dog){
                ((Dog)o).print();
            }
        }
    }
}


