package no.uib.gre002.info233.v2015.oblig2.app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class roomAppController implements Initializable, ScreenController {
	private ScreenPane myScreenPane;
	
    @FXML
    public ImageView bldArw_1;
	
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
			if((ImageView)e.getSource() == bldArw_1) {
				myScreenPane.setScreen("buildingScreen");
			}
            System.out.println("Clicked");
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	@Override
	public void setScreenPane(ScreenPane screenPage) {
		myScreenPane = screenPage;
	}
	
}
