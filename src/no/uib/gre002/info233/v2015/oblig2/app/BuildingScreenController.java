package no.uib.gre002.info233.v2015.oblig2.app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BuildingScreenController implements Initializable,
		ScreenController {

	private ScreenPane myScreenPane;

	@FXML
	public ComboBox<String> combo123;
	public ImageView rmArw_1;

	@FXML
	private void handleExitButtonEvent(MouseEvent e) {
		System.out.println("Button is clicked");
		System.exit(0);
	}

	@FXML
	private void handleHomeButtonEvent(MouseEvent e) {
		myScreenPane.setScreen("startScreen");
	}

	@FXML
	private void handleNextPageEvent(MouseEvent e) {
		if ((ImageView) e.getSource() == rmArw_1) {
			myScreenPane.setScreen("roomScreen");
		}
		System.out.println("Clicked");
	}

	@Override
	public void setScreenPane(ScreenPane screenPage) {
		myScreenPane = screenPage;
	}

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
