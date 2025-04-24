
import java.sql.*;

class DatabaseConnectionException extends Exception{}

public class DbAccess {

	private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";  // il driver è l'oggetto che permette la corretta comunicazione con il dbms	
	private final String DBMS = "jdbc:mysql";
	private final String SERVER = "localhost";
	private final String DATABASE = "MapDB";   // nome database
	private final int PORT = 3306;
	private final String USER_ID = "MapUser";  // da parametrizzare
	private final String PASSWORD = "map";
	
	private Connection conn;   // //Oggetto per la connessione attiva al dbms
	
	public DbAccess() throws DatabaseConnectionException		
	{
		try {
			Class.forName(DRIVER_CLASS_NAME).newInstance();  // (Class) chiama il costruttore a 0 argomenti della classe Driver per istanziarla
		} catch(ClassNotFoundException e) {
			System.out.println("[!] Driver not found: " + e.getMessage());
			throw new DatabaseConnectionException();
		} catch(InstantiationException e){
			System.out.println("[!] Error during the instantiation : " + e.getMessage());
			throw new DatabaseConnectionException();
		} catch(IllegalAccessException e){
			System.out.println("[!] Cannot access the driver : " + e.getMessage());
			throw new DatabaseConnectionException();
		}

        // creo la stringa per la connessione al db
		
		String connectionString = DBMS + "://" + SERVER + ":" + PORT + "/" + DATABASE
					+ "?user=" + USER_ID + "&password=" + PASSWORD + "&serverTimezone=UTC";
			
		System.out.println("Connection's String: " + connectionString);
			
			
		try {			
			conn = DriverManager.getConnection(connectionString);   //effettuo la connessione
		} catch(SQLException e) {
			System.out.println("[!] SQLException: " + e.getMessage());
			System.out.println("[!] SQLState: " + e.getSQLState());
			System.out.println("[!] VendorError: " + e.getErrorCode());
			throw new DatabaseConnectionException();
		}
	}

	
	
	public void closeConnection() throws SQLException{
		conn.close();   // chiusura del dbms
	}
	
	public void exampleQuery() {
		try{
			Statement s = conn.createStatement();

			// codice SQL: può generare l’eccezione SQLException

            // seleziona tutte le persone aventi cognome "map" e con email non nulla

			ResultSet r = s.executeQuery(   
			"SELECT FIRST, LAST, EMAIL " +
			"FROM peoplecsv as people " +
			"WHERE " +
			"(LAST='map') " +
			" AND (EMAIL Is Not Null) " +
			"ORDER BY FIRST");

			while(r.next()) {   //next restituisce true se c'è una tupla da leggere, e fa spostare il cursore sul dbms
				
				// Capitalization doesn't matter:

				System.out.println(
				r.getString("Last") + ", "   // se non conosciamo il tipo getObejct() dopo in java 
				+ r.getString("fIRST")
				+ ": " + r.getString("EMAIL") );

				// In alternativa: accesso posizionale

				/*System.out.println(
				r.getString(2) + ", "
				+ r.getString(1)
				+ ": " + r.getString(3) );
							
				NB: nell’accesso posizionale, gli indici delle colonne del ResultSet partono da 1 */
			}
			r.close();
			s.close(); // Also closes ResultSet

		} catch (SQLException ex) {
						// handle any errors
						System.out.println("SQLException: " + ex.getMessage());
						System.out.println("SQLState: " + ex.getSQLState());
						System.out.println("VendorError: " + ex.getErrorCode());
		}
		 

	
	}
	
	public static void main (String args[]){
		try{
			DbAccess db=new DbAccess();    // creo la connessione al dbms
			db.exampleQuery();             // creo la query e la eseguo sul dbms e visualizzo il risultato
			db.closeConnection();          // chiusura connessione dbms
		
		}
		catch(DatabaseConnectionException e){
			System.out.println(e.getMessage());
		} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}
	
	
}
