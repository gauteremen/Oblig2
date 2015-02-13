package no.uib.gre002.info233.v2015.oblig2.app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class roomAppController implements Initializable, ScreenController {
	private ScreenPane myScreenPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@Override
	public void setScreenPane(ScreenPane screenPage) {
		myScreenPane = screenPage;
	}

}
