package data_source_mgr_pac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class Data_Src_Mgr {

	private static Connection singleton_con = null;

	private Data_Src_Mgr() {

	}

	public synchronized static Connection get_Serv_Con() {
		if (singleton_con == null) {
			try {
				DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

				singleton_con = DriverManager.getConnection(Server_Connection_Vars.url, Server_Connection_Vars.username,
						Server_Connection_Vars.password);

				singleton_con.setAutoCommit(true);
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return singleton_con;
	}

}
