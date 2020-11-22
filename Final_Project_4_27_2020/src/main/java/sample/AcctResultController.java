package sample;

import java.io.IOException;

import entities.front_end_entities.Acct_View;
import entities.front_end_entities.Person_View;
import entities.front_end_entities.State;
import entities.front_end_entities.Viewable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.gui_utils.Controller_Helper;
import services.front_end_services.Acct_View_Services;

public class AcctResultController {

	public AnchorPane acctResultsAnchorPane;
	public TitledPane acctResultsTitle = new TitledPane();

	@FXML
	public TableView<Acct_View> acctResultsTable;
	@FXML
	public TableColumn<Acct_View, String> bankNum;
	@FXML
	public TableColumn<Acct_View, String> branchNum;
	@FXML
	public TableColumn<Acct_View, String> acctType;
	@FXML
	public TableColumn<Acct_View, String> acctNum;
	@FXML
	public TableColumn<Acct_View, String> prodCode;
	@FXML
	public TableColumn<Acct_View, String> amtCurBal;

	String errorMsg = "";

	private final static String fxmlFileName = "AcctResults.fxml";

	@FXML
	public void initialize() {
		tableInitialization();
	}

	@FXML
	public void SearchViewClicked() throws IOException {

		Stage stage = (Stage) acctResultsAnchorPane.getScene().getWindow();
		SearchController.draw(stage);
	}

	@FXML
	public void viewThisAcct() throws IOException {

		if (acctResultsTable.getSelectionModel().getSelectedItem() == null) {
			System.out.println("ExpandSelectedButtonClicked(): Nothing selected");
		} else {
			Acct_View selected = acctResultsTable.getSelectionModel().getSelectedItem();

			State state = State.getInstance();
			state.setAV(selected);

			Stage stage = (Stage) acctResultsTable.getScene().getWindow();
			AccountViewController.draw(stage);
		}
	}

	@FXML
	public void backButtonClicked() throws IOException {

		Stage stage = (Stage) acctResultsAnchorPane.getScene().getWindow();

		State state = State.getInstance();

		state.setAcctResults(null);

		if (state.getPV() != null) {

			PersonViewController.draw(stage);

		} else if (state.getBV() != null) {

			BusinessViewController.draw(stage);
		} else {
			System.out.println("Missed Problem in Acct Result Controller Back Button");
		}

	}

	protected static void draw(Stage window) {

		FXMLLoader loader = Controller_Helper.getFXMLLoader(fxmlFileName);
		Scene scene = Controller_Helper.getScene(loader);
		AcctResultController controller = loader.getController();
		controller.acctResultsTable.setItems(State.getInstance().getAcctResults());
		Controller_Helper.show_Scene(window, scene);
	}

	private void tableInitialization() {

		bankNum.setCellValueFactory(new PropertyValueFactory<Acct_View, String>("numBank"));
		branchNum.setCellValueFactory(new PropertyValueFactory<Acct_View, String>("branch"));
		acctType.setCellValueFactory(new PropertyValueFactory<Acct_View, String>("typeAcct"));
		acctNum.setCellValueFactory(new PropertyValueFactory<Acct_View, String>("numAcct"));
		prodCode.setCellValueFactory(new PropertyValueFactory<Acct_View, String>("prodCode"));
		amtCurBal.setCellValueFactory(new PropertyValueFactory<Acct_View, String>("amtCurBl"));
	}

}
