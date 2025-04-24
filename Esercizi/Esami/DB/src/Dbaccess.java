import java.sql.*;


class DatabaseConnectionException extends Exception{}

public class Dbaccess {

	private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";  
	private final String DBMS = "jdbc:mysql";
	private final String SERVER = "localhost";
	private final String DATABASE = "esempioDB";   
	private final int PORT = 3306;
	private final String USER_ID = "root";  
	private final String PASSWORD = "admin";
	
	private Connection conn;  
	

	public Dbaccess() throws DatabaseConnectionException{

        // PASSO 1 : Trovare il driver JDBC

		try {
			Class.forName(DRIVER_CLASS_NAME).newInstance(); 
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

        // PASSO 2 : Configurazione della connessione al DB
		
        // creo la stringa url della connessione

		String connectionString = DBMS + "://" + SERVER + ":" + PORT + "/" + DATABASE
					+ "?user=" + USER_ID + "&password=" + PASSWORD + "&serverTimezone=UTC";
			
		System.out.println("Stringa di connessione: " + connectionString);
			
			
		try {			
			conn = DriverManager.getConnection(connectionString);   //effettuo la connessione al DB
		} catch(SQLException e) {
			System.out.println("[!] SQLException: " + e.getMessage());
			System.out.println("[!] SQLState: " + e.getSQLState());
			System.out.println("[!] VendorError: " + e.getErrorCode());
			throw new DatabaseConnectionException();
		}
	}

	
    // chiude la connessione al DB
	
	public void closeConnection() throws SQLException{
		conn.close();  
	}
	

    // PASSO 3 : Generare le query


	public void exampleQuery() {

		try{
			Statement s = conn.createStatement();

			// codice SQL: può generare l’eccezione SQLException

            // seleziona codice fiscale e reddito dai clienti

			ResultSet r = s.executeQuery(   
			"SELECT CF,REDDITO " +
			"FROM clienti;");


			while(r.next()) {   //next restituisce true se c'è una tupla da leggere, e fa spostare il cursore sul dbms
				
				// Capitalization doesn't matter:

				System.out.println(
				r.getString("CF") + ", "   // se non conosciamo il tipo getObejct() dopo in java 
				+ r.getInt("REDDITO"));

				// In alternativa: accesso posizionale

				/*System.out.println(
				r.getString(1) + ", "
				+ r.getInt(2) );
							
				NB: nell’accesso posizionale, gli indici delle colonne del ResultSet partono da 1 */
			}

           
			r.close();
			s.close(); 

		} catch (SQLException ex) {
						// handle any errors
						System.out.println("SQLException: " + ex.getMessage());
						System.out.println("SQLState: " + ex.getSQLState());
						System.out.println("VendorError: " + ex.getErrorCode());
		}
	
	}


	public void insertValues(String NOME, String COGNOME,String CF,int REDDITO){
		try{
			Statement s = conn.createStatement();

		

			s.executeUpdate( 
				"INSERT INTO clienti (NOME,COGNOME,CF,REDDITO) " +
				"VALUES ('"+NOME.toString()+"','"+COGNOME.toString()+"','"+CF.toString()+"',"+REDDITO+");" );

			
			s.close();


		}catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
}
	}
	
	public static void main (String args[]){
		try{
			Dbaccess db=new Dbaccess();    // creo la connessione al dbms

			// query di inserimento
			db.insertValues("nome da tastietra", "cognome da tastiera", "cf da tastiera", 999);

			// query di selezione
			db.exampleQuery();             

			// chiusura connessione dbms
			db.closeConnection();          
		
		}
		catch(DatabaseConnectionException e){
			System.out.println(e.getMessage());
		} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}
	
	
}
