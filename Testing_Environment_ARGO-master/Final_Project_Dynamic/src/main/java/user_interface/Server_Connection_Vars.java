package user_interface;


/*
 * holder of Server Values that are not to change.
 */

 class Server_Connection_Vars {

	final static String url="jdbc:sqlserver://localhost\\SQL_SERVER_1";
	final static String username="sa";
	final static String password="12345";
	
	protected Server_Connection_Vars() {
		//protected so we can extend it.
	}
}
