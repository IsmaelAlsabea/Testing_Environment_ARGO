package sample;

import java.io.IOException;

import entities.front_end_entities.Acct_View;
import entities.front_end_entities.State;
import gui_entities_to_hs_tables_mapper.Account_To_Hs_Mapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.gui_utils.Controller_Helper;
import services.front_end_services.Acct_View_Services;
import utils.Date_Handler;

public class AccountViewController {

	private AnchorPane accountAnchorPane;

	@FXML
	public TextField acctTitle1 = new TextField();
	@FXML
	public TextField numAcct = new TextField();
	@FXML
	public TextField typeAcct = new TextField();

	@FXML
	public TextField prodCode = new TextField();
	@FXML
	public TextField status2 = new TextField();
	@FXML
	public TextField amtCurBal = new TextField();

	@FXML
	public TextField numBranch = new TextField();

	@FXML
	public TextField dateLast = new TextField();
	@FXML
	public TextField dateOpen = new TextField();
	@FXML
	public TextField dateClosed = new TextField();

	@FXML
	public TextField reasonClosed = new TextField();
	@FXML
	public TextField dateBegin = new TextField();
	@FXML
	public TextField dateEnd = new TextField();

	public String getAcctTitle() {
		return acctTitle1.getText();
	}

	public String getNumAcct() {
		return numAcct.getText();
	}

	public String getTypeAcct() {
		return typeAcct.getText();
	}

	public String getProdCode() {
		return prodCode.getText();
	}

	public String getStatus() {
		return status2.getText();
	}

	public String getAmtCurBal() {
		return amtCurBal.getText();
	}

	public String getNumBranch() {
		return numBranch.getText();
	}

	public String getDateLast() {
		return dateLast.getText();
	}

	public String getDateOpen() {
		return dateOpen.getText();
	}

	public String getDateClosed() {
		return dateClosed.getText();
	}

	public String getReasonClosed() {
		return reasonClosed.getText();
	}

	public String getDateBegin() {
		return dateBegin.getText();
	}

	public String getDateEnd() {
		return dateEnd.getText();
	}

	private final static String fxmlFileName = "AccountView.fxml";

	@FXML
	public void SearchViewClicked() throws IOException {
		Stage stage = (Stage) numAcct.getScene().getWindow();
		SearchController.draw(stage);
	}

	@FXML
	public void backButtonClicked() throws IOException {

		Stage stage = (Stage) numAcct.getScene().getWindow();
		AcctResultController.draw(stage);
	}

	public void UpdateButtonClicked() {

		// here the call to the input validator should be.

		State state = State.getInstance();

		System.out.println("update button clicked");
		Account_To_Hs_Mapper mapper = Account_To_Hs_Mapper.getInstance();
		mapper.map_update(getValues());

		update_account_results();

	}

	private Acct_View getValues() {
		
		Acct_View record = new Acct_View();
		/*
		 * the line below, copies the primary keys from the old instance to the new instance
		 * this line is important because the instance  (the gui form) does not have keys in it
		 * it does not have numacct, typeacct, cif ... etc.
		 * 
		 * before implementing this line, there was a problem with the update function,
		 * if you update once, it will work, but when you update another time, you will update nothing
		 * no record will be updated because the primary keys will be null and there is no record in the 
		 * database that has all of its primary keys as null.
		 * but when you update, and you copy the keys from the old instance, the new record will have the 
		 * the old view keys, and so no matter how many times you hit update, every new instance will have the old 
		 * instance keys, so there would be no problem.
		 */
		record.get_keys_from_old_instance(State.getInstance().getAV());
		
		record.setFullName(acctTitle1.getText());
		record.setNumAcct(numAcct.getText());
		record.setTypeAcct(typeAcct.getText());
		record.setProdCode(prodCode.getText());
		record.setStatus(status2.getText());
		record.setAmtCurBl(amtCurBal.getText());
		record.setBranch(numBranch.getText());
		record.setEndDate(Date_Handler.string_to_date(dateLast.getText()));
		record.setDateClosed(Date_Handler.string_to_date(dateOpen.getText()));
		record.setReasonClosed(reasonClosed.getText());
		record.setBeginDate(Date_Handler.string_to_date(dateBegin.getText()));
		record.setEndDate(Date_Handler.string_to_date(dateEnd.getText()));

		return record;

	}

	private void update_account_results() {
		State state = State.getInstance();
		Acct_View_Services services = new Acct_View_Services();
		ObservableList<Acct_View> records = null;
		records = services.retrieve(state.getAV().getNumtaxid());
		state.setAcctResults(records);
	}

	@FXML
	public void deleteRecord() throws IOException {
		System.out.println("delete button clicked");

		Account_To_Hs_Mapper mapper = Account_To_Hs_Mapper.getInstance();
		mapper.map_delete(State.getInstance().getAV());
		update_account_results();
		backButtonClicked();
	}

	protected static void draw(Stage window) {
		State state = State.getInstance();

		FXMLLoader loader = Controller_Helper.getFXMLLoader(fxmlFileName);

		Scene scene = Controller_Helper.getScene(loader);
		AccountViewController controller = loader.getController();
		controller.setValues(state.getAV());
		Controller_Helper.show_Scene(window, scene);
	}

	private void setValues(Acct_View current_view) {
		acctTitle1.setText(current_view.getFullName());
		numAcct.setText(current_view.getNumAcct());
		typeAcct.setText(current_view.getTypeAcct());
		prodCode.setText(current_view.getProdCode());
		status2.setText(current_view.getStatus());
		amtCurBal.setText(current_view.getAmtCurBl());
		numBranch.setText(current_view.getBranch());
		reasonClosed.setText(current_view.getReasonClosed());

		dateLast.setText(Date_Handler.date_to_string(current_view.getLastDate()));
		dateOpen.setText(Date_Handler.date_to_string(current_view.getDateOpen()));
		dateClosed.setText(Date_Handler.date_to_string(current_view.getDateClosed()));
		dateBegin.setText(Date_Handler.date_to_string(current_view.getBeginDate()));

	}

}
