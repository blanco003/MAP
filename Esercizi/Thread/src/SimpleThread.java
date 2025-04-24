
/* Se scelgo di realizzare il thread estendendo la classe Thread devo necessariamente sovrascrivere il metodo run().
 * Per poi far partire il thread devo invocare su di esso il metodo start() il quale come ultima operazione invocherà run(), 
 * se lo eseguissi direttamente con run() non verebbe eseguito in un thread separato ma in quello del main.
 */

public class SimpleThread extends Thread{
	
	private int countDown = 5;
	private static int threadCount = 0;
	private int threadNumber = ++threadCount;

	public SimpleThread(){
		System.out.println("Making " + threadNumber);
	}

	public void run(){
		while(true){
			System.out.println("Thread " + threadNumber + "(" + countDown + ")" );
			if ( --countDown == 0 ) return; 
		}
	}

	public static void main(String[] args){
		for(int i = 0; i < 5 ; i++){
			new SimpleThread().start();
		}
		System.out.println("All threads started");
	}
}