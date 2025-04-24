public class TestMyException {
    

    // Esempio eccezione controllata personalizzata

    public static void f() throws MyException {   // metodo che potrebbe espellere un'eccezione MyException
        throw new MyException("Lancio l'eccezione personalizzata da f()");
    }

    public static void g() throws MyException {
        throw new MyException("Lancio l'eccezione personalizzata da g()");
    }

    public static void main(String[] args) {

        // sezione di codice dove si potrebbe generare un'eccezione MyException
        try{
            f();
        }catch(MyException e){  // gestore dell'eccezione
            e.printStackTrace(System.err);
        }
        
        try{
            g();
        }catch(MyException e){
            System.err.println(e);
        }
    }
}
