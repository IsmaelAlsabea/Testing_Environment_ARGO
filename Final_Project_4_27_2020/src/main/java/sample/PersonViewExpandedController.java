package sample;

import java.io.IOException;

import entities.front_end_entities.Acct_View;
import entities.front_end_entities.Person_View;
import entities.front_end_entities.State;
import entities.front_end_entities.Viewable;
import gui_entities_to_hs_tables_mapper.Person_Extended_To_Hs_Mapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.gui_utils.Controller_Helper;
import sample.gui_utils.input_validators.Person_View_Expanded_Input_Validator;
import services.front_end_services.Acct_View_Services;
import services.front_end_services.Person_View_Services;
import utils.Date_Handler;

public class PersonViewExpandedController {
	@FXML
	private AnchorPane personExpandedAnchorPane;

	public TextField firstName = new TextField();
	public TextField lastName = new TextField();
	public ComboBox creditBureau = new ComboBox();

	public TextField dob = new TextField();
	public TextField ssn = new TextField();
	public TextField creditScore = new TextField();

	public ComboBox foreignIndicator = new ComboBox();
	public ComboBox pep = new ComboBox();
	public ComboBox onlineBanking = new ComboBox();

	public TextField telephone = new TextField();
	public TextField email = new TextField();
	public TextField address = new TextField();

	public TextField city = new TextField();
	public ComboBox state = new ComboBox();
	public TextField zipCode = new TextField();

	public ComboBox specUse = new ComboBox();
	public TextArea specUseNotes = new TextArea();

	public String getFirstName() {
		return firstName.getText();
	}

	public String getLastName() {
		return lastName.getText();
	}

	public String getCreditBureau() {
		return creditBureau.getSelectionModel().getSelectedItem().toString();
	}

	public String getDOB() {
		return dob.getText();
	}

	public String getSSN() {
		return ssn.getText();
	}

	public String getCreditScore() {
		return creditScore.getText();
	}

	public String getForeignIndicator() {
		return foreignIndicator.getSelectionModel().getSelectedItem().toString();
	}

	public String getPEP() {
		return pep.getSelectionModel().getSelectedItem().toString();
	}

	public String getOnlineBanking() {
		return onlineBanking.getSelectionModel().getSelectedItem().toString();
	}

	public String getTelephone() {
		return telephone.getText();
	}

	public String getEmail() {
		return email.getText();
	}

	public String getAddress() {
		return address.getText();
	}

	public String getCity() {
		return city.getText();
	}

	public String getState() {
		return state.getSelectionModel().getSelectedItem().toString();
	}

	public String getZipCode() {
		return zipCode.getText();
	}

	public String getSpecUse() {
		return specUse.getSelectionModel().getSelectedItem().toString();
	}

	public String getSpecUseNotes() {
		return specUseNotes.getText();
	}

	private static final String fxmlFileName = "PersonViewExpanded.fxml";

	@FXML
	public void initialize() {
		personViewExpandedInitialization();

	}

	@FXML
	public void backToSearch() throws IOException {
		setPersonState();
		Stage stage = (Stage) firstName.getScene().getWindow();
		SearchController.draw(stage);
	}

	public void viewAccountsClicked() throws IOException { // Query HS_ACCTS and return list of entities.
		// get current state of person view.
		State state = State.getInstance();
		Viewable current = state.getPV();

		// do the query here
		Acct_View_Services rtriv = new Acct_View_Services();
		ObservableList<Acct_View> records = rtriv.retrieve(current.getNumtaxid());
		// and set the results here
		state.setAcctResults(records);

		// draw acct results view
		Stage stage = (Stage) firstName.getScene().getWindow();
		AcctResultController.draw(stage);

	}

	public void UpdateButtonClicked() {
		System.out.println("update button clicked");

		// Person_View_Expanded_Input_Validator.getInstance().inputValidate(this);

		Person_Extended_To_Hs_Mapper mapper = Person_Extended_To_Hs_Mapper.getInstance();
		mapper.map_update( getValues());

		setPersonState();

	}

	private void setPersonState() {
		State state = State.getInstance();
		final Person_View user_input = getValues();

		if (State.getInstance().getPV() != null) {
			System.out.println("Saving PER view");
			state.setPV(user_input);
		}
	}

	private Person_View getValues() {

		Person_View record = new Person_View();
		
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
		record.get_keys_from_old_instance(State.getInstance().getPV());
		
		record.setFirstName(firstName.getText());
		record.setLastName(lastName.getText());
		record.setCreditBureau((String) creditBureau.getSelectionModel().getSelectedItem());

		record.setDob(Date_Handler.string_to_date(dob.getText()));

		record.setNumtaxid(ssn.getText());
		record.setCreditScore(creditScore.getText());
		record.setForeignInd((String) foreignIndicator.getSelectionModel().getSelectedItem());
		record.setPep((String) pep.getSelectionModel().getSelectedItem());
		record.setOnlineBanking((String) onlineBanking.getSelectionModel().getSelectedItem());
		record.setTelephone(telephone.getText());
		record.setEmail(email.getText());
		record.setStreet_1(address.getText());

		// String city, state, zipCode, specUse, specUseNotes;
		record.setCity(city.getText());
		record.setState((String) state.getSelectionModel().getSelectedItem());
		record.setZipCode(zipCode.getText());
		record.setSpecUse((String) specUse.getSelectionModel().getSelectedItem());
		record.setSpecUseNotes(specUseNotes.getText());

		return record;

	}

	protected static void draw(Stage window) {
		State state = State.getInstance();
		Viewable view = state.getPV();
		FXMLLoader loader = Controller_Helper.getFXMLLoader(fxmlFileName);
		Scene scene = Controller_Helper.getScene(loader);
		PersonViewExpandedController controller = loader.getController();

		if (view != null)
			controller.setValues((Person_View) view);
		Controller_Helper.show_Scene(window, scene);

	}

	private void setValues(Person_View pv) {
		firstName.setText(pv.getFirstName());
		lastName.setText(pv.getLastName());
		creditBureau.getSelectionModel().select(pv.getCreditBureau());
		dob.setText(pv.getDob().toString());
		ssn.setText(pv.getNumtaxid());
		creditScore.setText(pv.getCreditScore());
		foreignIndicator.getSelectionModel().select(pv.getForeignInd());
		pep.getSelectionModel().select(pv.getPep());
		onlineBanking.getSelectionModel().select(pv.getOnlineBanking());
		telephone.setText(pv.getTelephone());
		email.setText(pv.getTelephone());
		address.setText(pv.getStreet_1());

		// String city, state, zipCode, specUse, SpecUseNotes;
		city.setText(pv.getCity());
		state.getSelectionModel().select(pv.getState());
		zipCode.setText(pv.getZipCode());
		specUse.getSelectionModel().select(pv.getSpecUse());
		specUseNotes.setText(pv.getSpecUseNotes());
	}

	public void personViewExpandedInitialization() {

		creditBureau.getItems().removeAll(creditBureau.getItems());
		creditBureau.getItems().addAll("Equifax", "Experian", "TransUnion", "Canada", "Mexico", "Business", "ITIN",
				"Any");
		creditBureau.getSelectionModel().select("Any");

		foreignIndicator.getItems().removeAll(foreignIndicator.getItems());
		foreignIndicator.getItems().addAll("Y", "N", "Any");
		foreignIndicator.getSelectionModel().select("Any");

		pep.getItems().removeAll(pep.getItems());
		pep.getItems().addAll("Y", "N", "Any");
		pep.getSelectionModel().select("Any");

		onlineBanking.getItems().removeAll(onlineBanking.getItems());
		onlineBanking.getItems().addAll("Y", "N", "Any");
		onlineBanking.getSelectionModel().select("Any");

		state.getItems().addAll("Any", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "ID",
				"IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH",
				"NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA",
				"WA", "WV", "WI", "WY");
		state.getSelectionModel().select("Any");

		specUse.getItems().removeAll(specUse.getItems());
		specUse.getItems().addAll("MLA", "OFAC", "SnS", "Identity Scan", "No Online Banking", "Frozen", "Deceased",
				"ITIN", "Any");
		specUse.getSelectionModel().select("Any");

		System.out.println("personViewExpandedInitialization()");

	}
}
