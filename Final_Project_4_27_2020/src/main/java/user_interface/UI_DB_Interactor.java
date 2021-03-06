package user_interface;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DB_Names_Holder;

import data_source_mgr_pac.Data_Src_Mgr;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//singleton
public class UI_DB_Interactor {

	private static UI_DB_Interactor db_interactor;

	private DatabaseMetaData meta;
	private Connection conn; // created this variable, so we can close the connection after we finish with
								// it.

	private UI_DB_Interactor() {
		try {
			conn = Data_Src_Mgr.get_Serv_Con();
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

	/*
	 * get all legal HS_databases (legal means that it has all HS_tables , if it
	 * doesn't have the hs tables or it has some but not all of the HS_tables the
	 * database will not be included in the Map that will be returned)
	 */
	public ObservableList<String> get_All_HS_Databases() {

		ObservableList<String> dbNames = FXCollections.observableArrayList();
		ResultSet res_1 = null;
		String theDB = "";
		try {
			// get database names
			res_1 = meta.getCatalogs();
			// while the list of result set has stuff, move the cursor forward.
			while (res_1.next()) {

				// get the name of the database the cursor is on.
				theDB = res_1.getString("TABLE_CAT");
				// check if the database is legal
				if (check_if_the_db_has_all_hs_tables(theDB))
					// add it.

					dbNames.add(theDB);
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
		return dbNames;
	}

	/*
	 * returns true if the database has all HS_tables, else returns false.
	 */
	private boolean check_if_the_db_has_all_hs_tables(String theDB) {
		ResultSet res_2 = null;
		List<String> table_names = new ArrayList<>();
		// HS_tables_names is a list that contain all hs_tables names.
		List<String> HS_tables_names = HS_DB_Vars.HS_tables_names;
		try {

			for (int i = 0; i < HS_tables_names.size(); i++) {
				/*
				 * getTables has 4 parameters (databaseName, schemaPattern, tableNamePattern,
				 * String[] types) Here I am specifying the database, and the table name, and
				 * the type, so if the table is in the database, the result set will return the
				 * table.
				 */
				res_2 = meta.getTables(theDB, null, HS_tables_names.get(i), new String[] { "TABLE" });

				// res_2 will have either one result or zero.
				while (res_2.next()) { // if there is something in res2, proceed to add it to the list, else skip.
					table_names.add(res_2.getString("TABLE_NAME"));
				}
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
		// if the number of hs_tables in the database == number of hs_tables required
		if (table_names.size() == HS_tables_names.size())
			return true;
		else
			return false;
	}

	public ObservableList<String> get_states() {

		ObservableList<String> states = FXCollections.observableArrayList();

		String query = String.format("SELECT DISTINCT STATE1 FROM %s.HS_CUST ORDER BY STATE1 ASC",
				DB_Names_Holder.getHs_db_name());

		// System.out.println(query);

		ResultSet rs = null;

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			rs = ps.executeQuery();

			while (rs.next()) {
				states.add(rs.getString("STATE1"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return states;
	}
	/*
	 * Return a list of all unique special uses.
	 */

	public ObservableList<String> get_special_uses() {

		ObservableList<String> special_uses = FXCollections.observableArrayList();

		String query = String.format(
				"SELECT DISTINCT SPECUSE FROM %s.ConsumerInfo CI JOIN %s.HS_CUST CU ON CI.CIF = CU.CIF WHERE SPECUSE IS NOT NULL AND SPECUSE != '' ORDER BY SPECUSE ASC",
				DB_Names_Holder.getCi_db_name(), DB_Names_Holder.getHs_db_name());

		ResultSet rs = null;

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			rs = ps.executeQuery();

			while (rs.next()) {
				special_uses.add(rs.getString("SPECUSE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return special_uses;
	}

}
