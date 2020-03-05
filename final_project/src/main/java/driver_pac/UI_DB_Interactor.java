package driver_pac;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//singleton
public class UI_DB_Interactor {

	private static UI_DB_Interactor db_interactor;

	private DatabaseMetaData meta;
	private Connection conn; // created this variable, so we can close the connection after we finish with
								// it.

	private UI_DB_Interactor() {
		try {

			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			conn = DriverManager.getConnection(ConnectionVars.url, ConnectionVars.username, ConnectionVars.password);
			meta = conn.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static UI_DB_Interactor getInstance() {
		if (db_interactor == null)
			db_interactor = new UI_DB_Interactor();
		return db_interactor;
	}

	protected Map<Integer, String> getAllDatabases() {
		Map<Integer, String> databaseNames = new HashMap<Integer, String>();
		Integer count = -1;
		ResultSet res_1 = null;
		try {
			res_1 = meta.getCatalogs();
			while (res_1.next()) {
				count++;
				databaseNames.put(count, res_1.getString("TABLE_CAT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				res_1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return databaseNames;
	}

	protected void listDatabaseTables(String dbName) {
		ResultSet res_2 = null;

		try {
			res_2 = meta.getTables(dbName, null, null, new String[] { "TABLE" });
			while (res_2.next()) {
				System.out.println("\t" + res_2.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				res_2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected void close_connection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
