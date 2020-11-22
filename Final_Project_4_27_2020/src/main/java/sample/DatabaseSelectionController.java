package sample;

import java.io.IOException;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import sample.gui_utils.Controller_Helper;
import services.front_end_services.Search_View_Services;
import user_interface.Consumer_Info_DB_Vars;
import user_interface.Schema_Name;
import user_interface.UI_DB_Interactor;
import utils.DB_Names_Holder;


public class DatabaseSelectionController {
    
    private static String fxmlFileName = "DatabaseSelection.fxml";

	public ComboBox<String> databaseSelection = new ComboBox<String>();

    public Button go = new Button();

    private String getDatabaseSelection() {
        return databaseSelection.getSelectionModel().getSelectedItem().toString();
    }


    @FXML
    public void initialize() {
    	
    	ObservableList<String> dbs = getDatabases();
    	databaseSelectionInitialization(dbs);
    }


  
    public void goClicked() throws IOException{
    	
    	String db_choice = getDatabaseSelection();
    	
		DB_Names_Holder.setHs_db_name(db_choice +"."+Schema_Name.schemaName);
		DB_Names_Holder.setCi_db_name(Consumer_Info_DB_Vars.db_name+"."+Schema_Name.schemaName);
       
        Stage stage = (Stage) databaseSelection.getScene().getWindow();
     
        SearchController.draw(stage);

    }

    public void databaseSelectionInitialization(ObservableList<String> databases) {
    	
    	databaseSelection.getItems().removeAll(databaseSelection.getItems());	
    	databaseSelection.getItems().addAll(databases);

    }
    public ObservableList<String> getDatabases(){
    	
  
		UI_DB_Interactor dumm = UI_DB_Interactor.getInstance();
		ObservableList<String> dbs = dumm.get_All_HS_Databases();

    	return dbs;
    }
    
    protected static void draw (Stage stage)  {
    	
    	FXMLLoader loader = Controller_Helper.getFXMLLoader(fxmlFileName);

		Scene scene = Controller_Helper.getScene(loader);
		stage.setTitle("ARGO Test Tool");
		Controller_Helper.show_Scene(stage, scene);
    }
    

    
}
