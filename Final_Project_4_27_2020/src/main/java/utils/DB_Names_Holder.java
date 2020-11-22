package utils;


//database names holder
public class DB_Names_Holder { 

	private static String hs_db_name;
	private static String ci_db_name;
	
	public DB_Names_Holder(String hs_db_name, String ci_db_name) {
		DB_Names_Holder.hs_db_name=hs_db_name;
		DB_Names_Holder.ci_db_name=ci_db_name;
	}

	public static String getHs_db_name() {
		return hs_db_name;
	}

	public static void setHs_db_name(String hs_db_name) {
		DB_Names_Holder.hs_db_name = hs_db_name;
	}

	public static String getCi_db_name() {
		return ci_db_name;
	}

	public static void setCi_db_name(String ci_db_name) {
		DB_Names_Holder.ci_db_name = ci_db_name;
	}
	
}
