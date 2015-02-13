package no.uib.gre002.info233.v2015.oblig2.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UiBRomApp extends Application {

	private double xOffset = 0;
	private double yOffset = 0;
	public static String roomAppFXML = "roomApp.fxml";
	public static String roomApp = "roomApp";
	
	public static void main(String[] args) throws IOException {
		
	//	BuildingParser parser = new BuildingParser();
		// TODO change name of the method, or split into two classes.
	//	parser.getValueFromHTML("http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building=SS%3A");
		launch(args);
		
}
	public void start(final Stage primaryStage) throws Exception {
			primaryStage.initStyle(StageStyle.UNDECORATED);
			
			ScreenPane mainContainer = new ScreenPane();
			mainContainer.loadScreen(UiBRomApp.roomApp, UiBRomApp.roomAppFXML);
			mainContainer.setScreen(roomApp);
			
			Scene scene = new Scene(mainContainer);
	        
	        primaryStage.setScene(scene);
	        primaryStage.show();
		
	}
}