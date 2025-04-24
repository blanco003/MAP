import java.util.ArrayList;
import java.util.HashMap;

class Pet { }
class Dog extends Pet { }
class Pug extends Dog { }
class Counter { int i; }

public class PetCount {

    static String[] typename = {"Pet", "Dog", "Pug"};     

    public static void main(String[] args) {
        
        ArrayList pets = new ArrayList();                  
        
        try {
            
            Class[] petTypes = {
                Class.forName("Dog"), 
                Class.forName("Pug")}; 

                for (int i = 0; i < 5; i++) {
                    pets.add((Pet) petTypes[(int) (Math.random() * petTypes.length)].newInstance());    
                }

        } catch (ClassNotFoundException e) {
            System.err.println("Classe non trovata");
            return;
        } catch (InstantiationException e) {
            System.err.println("Non è possibile istanziare");
            return;
        } catch (IllegalAccessException e) {
            System.err.println("Non è possibile accedere");
            return;
        }

        HashMap h = new HashMap<>();            

        for (int i = 0; i < typename.length; i++) {
            h.put(typename[i], new Counter() );
        }

        for (int i = 0; i < pets.size(); i++) {
            Object o = pets.get(i);
            if (o instanceof Pet) {
                ((Counter)h.get("Pet")).i++;
            } 
            if (o instanceof Dog) {
                ((Counter)h.get("Dog")).i++;
            } 
            if (o instanceof Pug) {
                ((Counter)h.get("Pug")).i++;
            }
        }

        for (int i = 0; i < pets.size(); i++) {                                 
            System.out.println(pets.get(i).getClass());
        }

        for (int i = 0; i < typename.length; i++) {                            
            System.out.println(typename[i] + " quantity : " + ((Counter)h.get(typename[i])).i);
        }
    }
}