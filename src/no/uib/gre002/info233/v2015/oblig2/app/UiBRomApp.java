package no.uib.gre002.info233.v2015.oblig2.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class UiBRomApp extends Application {

	public static String startScreenFXML = "startScreen.fxml";
	public static String buildingScreenFXML = "buildingScreen.fxml";
	public static String roomScreenFXML = "roomScreen.fxml";
	public static String calendarTableScreen = "calendarTableScreen.fxml";
	
	
	public static void main(String[] args) throws IOException {
		
	//	BuildingParser parser = new BuildingParser();
		// TODO change name of the method, or split into two classes.
	//	parser.getValueFromHTML("http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building=SS%3A");
		launch(args);
		
}
	public void start(final Stage primaryStage) throws Exception {
			primaryStage.initStyle(StageStyle.UNDECORATED);
			
			ScreenPane mainContainer = new ScreenPane();
			mainContainer.loadScreen("startScreen", UiBRomApp.startScreenFXML);
			mainContainer.loadScreen("buildingScreen", UiBRomApp.buildingScreenFXML);
			mainContainer.loadScreen("roomScreen", UiBRomApp.roomScreenFXML);
			mainContainer.setScreen("startScreen");
		
			Scene scene = new Scene(mainContainer);
	        
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        

		 
	}
}