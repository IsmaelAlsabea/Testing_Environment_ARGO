package user_interface;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


//singleton
public class User_Interface {

	private static User_Interface ui;

	private User_Interface() {
	}

	public static User_Interface getInstance() {
		if (ui == null)
			ui = new User_Interface();
		return ui;
	}
	

	/*
	 * no user interaction needed here because only one database that holds the consumer info table 
	 */
	public Map<DB_INFO,String> get_Consumer_Info_DB_info(){
		
		Map<DB_INFO, String> theMap= new HashMap<>();
		
		/*
		 * attach database name to the url of the server and pass it along the username and password of the server.
		 */
		theMap.put(DB_INFO.URL, Server_Connection_Vars.url + ";DatabaseName=" + Consumer_Info_DB_Vars.db_name);
		theMap.put(DB_INFO.USERNAME, Server_Connection_Vars.username);
		theMap.put(DB_INFO.PASSWORD, Server_Connection_Vars.password);

		return theMap;
	}
	
	/*
	 * get the connection information for chosen HS databases to connect to it.  (URL, Username, Password)
	 */
	public Map<DB_INFO, String> get_HS_DB_info() {
		/*
		 * get all legal HS_database
		 */
		UI_DB_Interactor dumm = UI_DB_Interactor.getInstance();
		Map<Integer, String> databaseNames = dumm.get_All_HS_Databases();
		dumm.close_connection();
		
		Scanner reader = new Scanner(System.in);
		
		int db_choice=-1;
		Map<DB_INFO, String> theMap = new HashMap<>();
		String theChosenDB = "";

		/*
		 * show it to the user
		 */
		for (int i = 0; i < databaseNames.size(); i++) {
			System.out.println(i + ") " + databaseNames.get(i));
		}

		/*
		 * get user selection
		 */
		db_choice = make_a_right_selection("Please select the HS database", 0,
				databaseNames.size() - 1, reader);
		theChosenDB = databaseNames.get(db_choice);
		
		/*
		 * attach the name of the chosen database to the URL of the server and pass it along the username and password
		 * for the server to the driver.
		 */
		theMap.put(DB_INFO.URL, Server_Connection_Vars.url + ";DatabaseName=" + theChosenDB);
		theMap.put(DB_INFO.USERNAME, Server_Connection_Vars.username);
		theMap.put(DB_INFO.PASSWORD, Server_Connection_Vars.password);

		return theMap;
	}

	/*
	 * makes sure that the user selection is within legal boundaries of the list of selections.
	 */
	private int make_a_right_selection(String question, int lowestValidVal, int highestValidVal, Scanner reader) {

		int user_choice = -1;
		while (true) {
			System.out.println(question);
			user_choice = readAnInt(reader);

			if (user_choice > highestValidVal || user_choice < lowestValidVal)
				System.out.println("wrong entry please enter a valid number.");
			else
				break;
		}

		return user_choice;
	}


	private int readAnInt(Scanner reader) {
		int x = -1; //flag

		while (true) {
			try {
				x = reader.nextInt();
				if (x != -1)
					break;
			} catch (InputMismatchException e) {
				System.out.println("Please input a number");
				reader.nextLine();
			} catch (Exception e) {
				e.toString();
				e.printStackTrace();
				System.out.println("Unhandled problem");
				System.exit(5);
			}
		}
		return x;
	}

}
