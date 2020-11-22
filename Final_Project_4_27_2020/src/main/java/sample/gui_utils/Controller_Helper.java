package sample.gui_utils;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.fxml_files.Where_FXML_Files_Are;

public class Controller_Helper {

	public static FXMLLoader getFXMLLoader(String fxmlFileName) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(new Where_FXML_Files_Are().getClass().getResource(fxmlFileName));
		return loader;

	}

	public static Scene getScene(FXMLLoader loader) {

		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			System.out.println("loader.load() returning null");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return new Scene(root, 800, 600);
	}
	

	public static void show_Scene(Stage window, Scene scene) {
		window.setScene(scene);
		window.show();
	}
	

}
