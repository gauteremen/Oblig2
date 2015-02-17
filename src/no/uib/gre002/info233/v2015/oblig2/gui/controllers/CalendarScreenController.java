package no.uib.gre002.info233.v2015.oblig2.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import no.uib.gre002.info233.v2015.oblig2.gui.ScreenPane;

public class CalendarScreenController implements Initializable, ScreenController {

private ScreenPane myScreenPane;

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
 * Sets the new screen
 */
@Override
public void setScreenPane(ScreenPane screenPage) {
	myScreenPane = screenPage;
}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {

	
}


}

