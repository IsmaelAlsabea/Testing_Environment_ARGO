package sample;

import java.io.IOException;

import entities.front_end_entities.Acct_View;
import entities.front_end_entities.Business_View;
import entities.front_end_entities.Person_View;
import entities.front_end_entities.State;
import entities.front_end_entities.Viewable;
import gui_entities_to_hs_tables_mapper.Business_To_Hs_Mapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.gui_utils.Controller_Helper;
import sample.gui_utils.input_validators.Business_View_Input_Validator;
import services.front_end_services.Acct_View_Services;
import services.front_end_services.Business_View_Services;

public class BusinessViewController {

	public AnchorPane businessAnchorPane;

	public TextField companyName = new TextField();
	public TextField yearEstablished = new TextField();
	public TextField taxID = new TextField();

	public TextField telephone = new TextField();
	public TextField email = new TextField();
	public TextField address = new TextField();

	public TextField city = new TextField();
	public ComboBox state = new ComboBox();
	public TextField zipCode = new TextField();

	private String getCompanyName() {
		return companyName.getText();
	}

	public String getYearEstablished() {
		return yearEstablished.getText();
	}

	private String getTaxID() {
		return taxID.getText();
	}

	public String getTelephone() {
		return telephone.getText();
	}

	public String getEmail() {
		return email.getText();
	}

	private String getAddress() {
		return address.getText();
	}

	private String getCity() {
		return city.getText();
	}

	private String getState() {
		return state.getSelectionModel().getSelectedItem().toString();
	}

	public String getZipCode() {
		return zipCode.getText();
	}

	// private static Viewable current_view;
	private final static String fxmlFileName = "BusinessView.fxml";

	@FXML
	public void initialize() {
		businessViewInitialization();
		reloadState();
	}

	@FXML
	public void backToSearch() throws IOException {
		// setPersonState();
		Stage stage = (Stage) businessAnchorPane.getScene().getWindow();
		SearchController.draw(stage);
	}

	public void updateButtonClicked() {
		// String success = "";

		System.out.println("update button clicked");

		// Business_View_Input_Validator.getInstance().inputValidate(this);

		Business_To_Hs_Mapper mapper = Business_To_Hs_Mapper.getInstance();
		mapper.map_update( getValues());

		setBusinessState();
	}

	public void viewAccountsClicked() throws IOException {
		State state = State.getInstance();

		Acct_View_Services rtriv = new Acct_View_Services();
		ObservableList<Acct_View> records = rtriv.retrieve(state.getBV().getNumtaxid());

		state.setAcctResults(records);

		Stage stage = (Stage) businessAnchorPane.getScene().getWindow();
		AcctResultController.draw(stage);

		// Launch acctsView and fill table with entities
	}

	protected static void draw(Stage window) {

		State state = State.getInstance();
		Viewable view = state.getBV();
		FXMLLoader loader = Controller_Helper.getFXMLLoader(fxmlFileName);
		Scene scene = Controller_Helper.getScene(loader);
		BusinessViewController controller = loader.getController();
		if (view != null)
			controller.setValues((Business_View) view);
		Controller_Helper.show_Scene(window, scene);
	}

	private void setBusinessState() {
		State state = State.getInstance();
		final Business_View user_input = getValues();

		if (state.getBV() != null) {
			System.out.println("Saving BUS view");
			state.setBV(user_input);
		}
	}

	private Business_View getValues() {
		Business_View record = new Business_View();

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
		record.get_keys_from_old_instance(State.getInstance().getBV());
		
		record.setFullName(companyName.getText());
		record.setYearEstablished(yearEstablished.getText());
		record.setNumtaxid(taxID.getText());
		record.setTelephone(telephone.getText());
		record.setEmail(email.getText());
		record.setStreet_1(address.getText());
		record.setCity(city.getText());
		record.setState((String) state.getSelectionModel().getSelectedItem());
		record.setZipCode(zipCode.getText());

		return record;
	}

	// Null for program start, else bring back data
	private boolean reloadState() {
		Business_View prevView = State.getInstance().getBV();

		if (prevView == null)
			return false;

		setValues(prevView);
		return true;
	}

	private void setValues(Business_View record) {

		companyName.setText(record.getFullName());
		yearEstablished.setText(record.getYearEstablished());
		taxID.setText(record.getNumtaxid());
		telephone.setText(record.getTelephone());
		email.setText(record.getEmail());

		address.setText(record.getStreet_1());
		city.setText(record.getCity());
		state.getSelectionModel().select(record.getState());
		zipCode.setText(record.getZipCode());
	}

	private void businessViewInitialization() {

		state.getItems().removeAll(state.getItems());

		state.getItems().addAll("Any", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "ID",
				"IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH",
				"NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA",
				"WA", "WV", "WI", "WY");

		state.getSelectionModel().select("Any");

	}

}
