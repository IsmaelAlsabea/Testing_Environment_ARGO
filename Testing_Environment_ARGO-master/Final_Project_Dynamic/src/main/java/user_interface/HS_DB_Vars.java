package user_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class HS_DB_Vars { // default only visible to the package.
	

	//database name is chosen by the user, so no variable to hold it in.
	
	final static List<String> HS_tables_names = new ArrayList<>(
			Arrays.asList("HS_ACCT", "HS_ACCT_HOLD", "HS_ACCT_NOTE",
			"HS_ACCT_STOP", "HS_CUAC", "HS_CUST"));

	private HS_DB_Vars() {
		//creates no instances.
	}
	
}
