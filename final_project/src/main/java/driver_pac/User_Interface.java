package driver_pac;

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
	 * get the information for all needed databases to connect to them.
	 */
	protected Map<DATABASE, Map<DB_INFO, String>> get_the_DBS_INFO() {

		UI_DB_Interactor dumm = UI_DB_Interactor.getInstance();
		Scanner reader = new Scanner(System.in);

		Map<DATABASE, Map<DB_INFO, String>> finalMap = new HashMap<>();

		Map<Integer, String> databaseNames = dumm.getAllDatabases();

		finalMap.put(DATABASE.HS_DB, get_one_DB_Info("HS", dumm, databaseNames, reader));
		finalMap.put(DATABASE.CONSUMER_INFO_DB, get_one_DB_Info("Consumer_Info", dumm, databaseNames, reader));

		// very important. if it is not done, future problems may occur.
		dumm.close_connection();

		return finalMap;

	}
	

	/*
	 * get the connection information for one databases to connect to it.  (URL, Username, Password)
	 */
	private Map<DB_INFO, String> get_one_DB_Info(String requestedDB, UI_DB_Interactor dumm,
			Map<Integer, String> databaseNames, Scanner reader) {

		int db_choice, selectOrPreview;
		Map<DB_INFO, String> theMap = new HashMap<>();
		String theChosenDB = "";

		while (true) {
			db_choice = -1;
			selectOrPreview = -1;

			for (int i = 0; i < databaseNames.size(); i++) {
				System.out.println(i + ") " + databaseNames.get(i));
			}

			db_choice = make_a_right_selection("Please select the " + requestedDB + " database", 0,
					databaseNames.size() - 1, reader);

			selectOrPreview = make_a_right_selection("Please choose whether you want to connect "
					+ "to the database or preivew its tables\n" + "1) connect\n" + "2) preview", 1, 2, reader);
			if (selectOrPreview == 1)
				break;
			else if (selectOrPreview == 2) {
				dumm.listDatabaseTables(databaseNames.get(db_choice));
				System.out.println("\n____________________________________\n");
			}

		}

		theChosenDB = databaseNames.get(db_choice);
		theMap.put(DB_INFO.URL, ConnectionVars.url + ";DatabaseName=" + theChosenDB);
		theMap.put(DB_INFO.USERNAME, ConnectionVars.username);
		theMap.put(DB_INFO.PASSWORD, ConnectionVars.password);

		return theMap;
	}

	/*
	 * makes sure that the user selection is within legal boundaries of the menu.
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
		int x = -1;

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
