package sample;

import java.sql.SQLException;

import data_source_mgr_pac.Data_Src_Mgr;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	//SearchController.draw(primaryStage);
    	DatabaseSelectionController.draw(primaryStage);
    }



    public static void LAUNCH(String[] args) {
    	
    	try {
    	launch(args);
    	} catch (Exception e){
    		e.printStackTrace();
    	} finally {
    		try {
				Data_Src_Mgr.get_Serv_Con().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

}

