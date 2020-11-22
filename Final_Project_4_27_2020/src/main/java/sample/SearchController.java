package sample;

import java.io.IOException;

import entities.front_end_entities.Business_View;
import entities.front_end_entities.Person_View;
import entities.front_end_entities.Search_View;
import entities.front_end_entities.State;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.gui_utils.Controller_Helper;
import sample.gui_utils.input_validators.Search_View_Input_Validator;
import services.front_end_services.Business_View_Services;
import services.front_end_services.Person_View_Services;
import services.front_end_services.Search_View_Services;
import services.hs_services.HS_CUST_Services;
import user_interface.UI_DB_Interactor;

public class SearchController {

	public ComboBox customerType = new ComboBox();
	public TextField age = new TextField();
	public ComboBox state = new ComboBox();

	public ComboBox creditBureau = new ComboBox();
	public ComboBox pep = new ComboBox();
	public TextField zipCode = new TextField();

	public ComboBox onlineBanking = new ComboBox();
	public ComboBox foreignIndicator = new ComboBox();
	public ComboBox specialUse = new ComboBox();
	
	public ComboBox mortgageAccts = new ComboBox();
	public ComboBox bankruptcyRecords = new ComboBox();

	public TextField name = new TextField();
	public TextField creditHigh = new TextField();
	public TextField creditLow = new TextField();
	public TextField city = new TextField();

	public Text rowsReturned = new Text();

	@FXML
	private TableView<Search_View> resultsTable;
	// @FXML private TableColumn<CI_View, Button> viewButtonColumn;
	@FXML
	private TableColumn<Search_View, String> nameColumn;
	@FXML
	private TableColumn<Search_View, Integer> ageColumn;
	@FXML
	private TableColumn<Search_View, String> stateColumn;
	@FXML
	private TableColumn<Search_View, Integer> zipCodeColumn;
	@FXML
	private TableColumn<Search_View, Integer> creditScoreColumn;
	@FXML
	private TableColumn<Search_View, String> bureauColumn;
	@FXML
	private TableColumn<Search_View, String> specialUseColumn;

	private ObservableList<Search_View> theList;

	private final static String fxmlFileName = "search.fxml";

	private String getCustomerType() {
		return customerType.getSelectionModel().getSelectedItem().toString();
	}

	public String getAge() {
		return age.getText();
	}

	private String getState() {
		return state.getSelectionModel().getSelectedItem().toString();
	}

	private String getCreditBureau() {
		return creditBureau.getSelectionModel().getSelectedItem().toString();
	}

	private String getPep() {
		return pep.getSelectionModel().getSelectedItem().toString();
	}

	public String getZipCode() {
		return zipCode.getText();
	}

	private String getOnlineBanking() {
		return onlineBanking.getSelectionModel().getSelectedItem().toString();
	}

	private String getForeignIndicator() {
		return foreignIndicator.getSelectionModel().getSelectedItem().toString();
	}

	private String getSpecialUse() {
		return specialUse.getSelectionModel().getSelectedItem().toString();
	}

	private String getName() {
		return name.getText();
	}

	public String getCreditHigh() {
		return creditHigh.getText();
	}

	public String getCreditLow() {
		return creditLow.getText();
	}

	public String getCity() {
		return city.getText();
	}
	
	private String getMortgageAccts() {
		return mortgageAccts.getSelectionModel().getSelectedItem().toString();
	}
	
	private String getBankruptcyRecords() {
		return bankruptcyRecords.getSelectionModel().getSelectedItem().toString();
	}

	public AnchorPane searchAnchorPane;

	@FXML
	public void initialize() {
		searchInitialization();
		tableInitialization();
		rowsReturned.setText("");
		reloadState();

	}

	public void SearchButtonClicked() {

		// Search_View_Input_Validator.getInstance().inputValidate(this);

		Search_View user_input = getUserInput();

		theList = new Search_View_Services().getEntities(user_input);

		resultsTable.setItems(theList);
		rowsReturned.setText(Integer.toString(theList.size()));

		setSearchState();

	}

	public void ExpandSelectedButtonClicked() throws IOException {

		Search_View selected = resultsTable.getSelectionModel().getSelectedItem(); // <-- How you get whatever was
																					// selected

		Stage stage = (Stage) resultsTable.getScene().getWindow();
		Stage window = stage;

		if (selected == null) {
			System.out.println("ExpandSelectedButtonClicked(): Nothing selected");
		} else {

			State state = State.getInstance();

			setSearchState();

			if (selected.getCustType().equals("BUS")) {

				Business_View_Services rtriv = new Business_View_Services();
				Business_View record = rtriv.retrieve(selected.getCif());

				state.setBV(record);

				BusinessViewController.draw(window);
			} else if (selected.getCustType().equals("PER")) {

				Person_View_Services rtriv_pv = new Person_View_Services();
				Person_View record = rtriv_pv.retrieve(selected.getCif());

				state.setPV(record);

				// expand to person view
				PersonViewController.draw(window);
			} else {
				System.out.println("NEITHER PER, or BUS, something wrong.");
			}
		}

	}

	public void clearSearch() {
		searchInitialization();
		theList = null;
		resultsTable.setItems(theList);
		setSearchState();
	}

	protected static void draw(Stage stage) {

		FXMLLoader loader = Controller_Helper.getFXMLLoader(fxmlFileName);
		Scene scene = Controller_Helper.getScene(loader);
		Controller_Helper.show_Scene(stage, scene);
	}

	private void setSearchState() {

		State state = State.getInstance();
		final Search_View user_input = getUserInput();
		state.setSV_UserInput(user_input);
		state.setSV_ResultsList(theList);
	}

	private Search_View getUserInput() {
		Search_View user_input = new Search_View();

		user_input.setCustType(getCustomerType());
		user_input.setAge(getAge());
		user_input.setState(getState());
		user_input.setCreditBureau(getCreditBureau());
		user_input.setPep(getPep());
		user_input.setZipCode(getZipCode());
		user_input.setOnlineBanking(getOnlineBanking());
		user_input.setForeignIndicator(getForeignIndicator());
		user_input.setSpecialUse(getSpecialUse());
		user_input.setName(getName());
		user_input.setCreditHigh(getCreditHigh());
		user_input.setCreditLow(getCreditLow());
		user_input.setCity(getCity());
		
		user_input.setMortgageAccts(getMortgageAccts());
		user_input.setBankruptcyRecords(getBankruptcyRecords());

		return user_input;
	}

	// Null for program start, else bring back data
	private boolean reloadState() {
		State prevState = State.getInstance();

		if (prevState.getSV_UserInput() == null)
			return false;
		else {

			customerType.getSelectionModel().select(prevState.getSV_UserInput().getCustType());
			age.setText(prevState.getSV_UserInput().getAge());
			state.getSelectionModel().select(prevState.getSV_UserInput().getState());
			creditBureau.getSelectionModel().select(prevState.getSV_UserInput().getCreditBureau());
			pep.getSelectionModel().select(prevState.getSV_UserInput().getPep());
			zipCode.setText(prevState.getSV_UserInput().getZipCode());
			onlineBanking.getSelectionModel().select(prevState.getSV_UserInput().getOnlineBanking());
			foreignIndicator.getSelectionModel().select(prevState.getSV_UserInput().getForeignIndicator());
			specialUse.getSelectionModel().select(prevState.getSV_UserInput().getSpecialUse());
			name.setText(prevState.getSV_UserInput().getName());
			creditLow.setText(prevState.getSV_UserInput().getCreditLow());
			creditHigh.setText(prevState.getSV_UserInput().getCreditHigh());
			city.setText(prevState.getSV_UserInput().getCity());
			
			mortgageAccts.getSelectionModel().select(prevState.getSV_UserInput().getMortgageAccts());
			pep.getSelectionModel().select(prevState.getSV_UserInput().getPep());

			resultsTable.setItems(theList = prevState.getSV_ResultsList());
			rowsReturned.setText(Integer.toString(theList.size()));

			return true;
		}
	}

	private void tableInitialization() {
		nameColumn.setCellValueFactory(new PropertyValueFactory<Search_View, String>("name"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<Search_View, Integer>("age"));
		stateColumn.setCellValueFactory(new PropertyValueFactory<Search_View, String>("state"));
		zipCodeColumn.setCellValueFactory(new PropertyValueFactory<Search_View, Integer>("zipCode"));
		creditScoreColumn.setCellValueFactory(new PropertyValueFactory<Search_View, Integer>("creditScore"));
		bureauColumn.setCellValueFactory(new PropertyValueFactory<Search_View, String>("creditBureau"));
		specialUseColumn.setCellValueFactory(new PropertyValueFactory<Search_View, String>("specialUse"));
	}

	private void searchInitialization() {
		
		age.setText("");
		creditLow.setText("");
		creditHigh.setText("");
		city.setText("");
		zipCode.setText("");
		

		customerType.getItems().removeAll(customerType.getItems());
		customerType.getItems().addAll("PER", "BUS", "Any");
		customerType.getSelectionModel().select("Any");
		
		
		
		UI_DB_Interactor dumm = UI_DB_Interactor.getInstance();
		ObservableList<String> stateList = dumm.get_states();
		
		stateList.remove(null);

		state.getItems().removeAll(state.getItems());
		
		state.getItems().addAll(stateList);
		state.getSelectionModel().select("Any");

		creditBureau.getItems().removeAll(creditBureau.getItems());
		creditBureau.getItems().addAll("Equifax", "Experian", "TransUnion", "Canada", "Mexico", "Business", "ITIN",
				"Any");
		creditBureau.getSelectionModel().select("Any");

		pep.getItems().removeAll(pep.getItems());
		pep.getItems().addAll("Y", "N", "Any");
		pep.getSelectionModel().select("Any");

		onlineBanking.getItems().removeAll(onlineBanking.getItems());
		onlineBanking.getItems().addAll("Y", "N", "Any");
		onlineBanking.getSelectionModel().select("Any");

		foreignIndicator.getItems().removeAll(foreignIndicator.getItems());
		foreignIndicator.getItems().addAll("Y", "N", "Any");
		foreignIndicator.getSelectionModel().select("Any");

		ObservableList<String> specialUses = dumm.get_special_uses();
		
		specialUse.getItems().removeAll(specialUse.getItems());
		specialUse.getItems().addAll(specialUses);
		specialUse.getSelectionModel().select("Any");
		
		//ObservableList<String> mortgages = dumm.get_mortgages(); // need to make "get mortgages" function
		
		mortgageAccts.getItems().removeAll(mortgageAccts.getItems());
		//mortgageAccts.getItems().addAll(mortgages); // 
		mortgageAccts.getSelectionModel().select("Any");
		
		//ObservableList<String> bankruptcies = dumm.get_bankrupcies(); // need to make "get bankruptcies" function
		
		bankruptcyRecords.getItems().removeAll(bankruptcyRecords.getItems());
		//bankruptcyRecords.getItems().addAll(bankruptcies); // 
		bankruptcyRecords.getSelectionModel().select("Any");
		
		

		rowsReturned.setText("");

	}

}
