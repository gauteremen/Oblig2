package no.uib.gre002.info233.v2015.oblig2.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import no.uib.gre002.info233.v2015.oblig2.gui.ScreenPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * This is the controller for the buildinScreen.fxml
 * 
 * @author Gaute Gjerløw Remen
 * @version 1.0
 */
public class BuildingScreenController implements Initializable,
		ScreenController {

	private ScreenPane myScreenPane;

	/**
	 * Initialize the combobox and the rmArw_1 fx:id in FXML
	 */
	@FXML
	public ComboBox<String> combo123;
	public ImageView rmArw_1;

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
		if ((ImageView) e.getSource() == rmArw_1) {
			myScreenPane.setScreen("roomScreen");
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
		combo123.getItems().clear();
		combo123.getItems().addAll("A55: Bjørn Trumpys Hus(Fysikkbygget)",
				"A66: Allégaten 66", "A70: Allégaten 70,",
				"AHH: Armauer Hansens Hus", "BK: Barneklinkken",
				"BB: BB-Bygget", "BIO: Biologen", "BC: Bjørn Christiansen Hus",
				"BV: Brakkerigg Vinjesgate", "M1: C.G. Sundts Hus",
				"CLG: Carl L. Godskes Hus",
				"C13: Christies gate 13 (Vektergården)",
				"C17: Christies gate 17", "DR: Dragefjellet");
	}

}
