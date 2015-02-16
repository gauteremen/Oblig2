package no.uib.gre002.info233.v2015.oblig2.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import no.uib.gre002.info233.v2015.oblig2.gui.ScreenPane;
import no.uib.gre002.info233.v2015.oblig2.io.ParserController;
import no.uib.gre002.info233.v2015.oblig2.io.RoomParser;
import no.uib.gre002.info233.v2015.oblig2.models.UIBroom;

/**
 * This is the controller for the roomScreen.fxml
 * 
 * @author Gaute Gjerløw Remen
 * @version 1.0
 */
public class RoomScreenController implements Initializable,
		ScreenController {

	private ScreenPane myScreenPane;
	private String buildingCode;
	

	/**
	 * Initialize the combobox and the rmArw_1 fx:id in FXML
	 */
	@FXML
	public ComboBox<String> roomCombo;
	public ImageView clndrv_1;

	/**
	 * Handles the FXML onMouseClicked on the cross symbol
	 * 
	 * @param e
	 */
	@FXML
	private void handleExitButtonEvent(MouseEvent e) {
		System.out.println("Button is clicked");
		System.exit(0);
	}

	/**
	 * Handles the FXML onMouseClicked on the home symbol
	 * 
	 * @param e
	 */
	@FXML
	private void handleHomeButtonEvent(MouseEvent e) {
		myScreenPane.setScreen("startScreen");
	}

	/**
	 * Handles the FXML onMouseClicked on the arrow
	 * 
	 * @param e
	 */
	@FXML
	private void handleNextPageEvent(MouseEvent e) {
		if ((ImageView) e.getSource() == clndrv_1) {
			myScreenPane.setScreen("calendarTableScreen");
		}
		System.out.println("Clicked");
	}

	/**
	 * Sets the new screen
	 */
	@Override
	public void setScreenPane(ScreenPane screenPage) {
		myScreenPane = screenPage;
	}

	/**
	 * Initialize the combobox items
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		roomCombo.getItems().clear();
		try {
			RoomParser roomParser = new RoomParser(ParserController.getBuildingURL(buildingCode));

			for (UIBroom room : roomParser.getBuildings()) {
				roomCombo.getItems().add(room.getName());
			}
		} catch (IOException e) {
			//TODO Write catch clause
		}
	}
	
	/**
	 * Used to store which building the user has selected
	 * @param buildingCode the code of the building (i.e. SV for Laurits Meltzers)
	 */
	public void setBuildingCode(String buildingCode){
		this.buildingCode = buildingCode;
	}

}
