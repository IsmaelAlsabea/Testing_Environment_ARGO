package user_interface;


/*
 * Enum, to distinguish the needed variables for a server connection.
 * this enum works as a shared lingo between the driver class and the user interface.
 * so, the user interface sends the database information (url, username, password) using a map <DB_INFO, String>
 * to the driver and the driver knows which one is URL and which one is a username using 
 * also this Enum.
 */

public enum DB_INFO {

	URL,
	USERNAME,
	PASSWORD;
}
