public class EccezioneNonControllata {
    public static void main(String[] args) {

        
        // Esempio eccezione non controllata ArrayIndexOutOfBoundsException : stiamo accedendo ad una posizione non valida dell'array

        try{
            int array[] = {1,2,3,4};
            int a = array[10];               
            System.out.println(a);
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }


        // Esempio eccezione non controllata ArithmeticException  : divisione per 0

        try {
            int x = 10 / 0;
            System.out.println(x);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
       
    }
}
