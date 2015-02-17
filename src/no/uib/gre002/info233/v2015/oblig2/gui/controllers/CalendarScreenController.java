package no.uib.gre002.info233.v2015.oblig2.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import no.uib.gre002.info233.v2015.oblig2.gui.ScreenPane;
import no.uib.gre002.info233.v2015.oblig2.io.CalendarPopulator;

public class CalendarScreenController implements Initializable,
		ScreenController {

	private ScreenPane myScreenPane;

	@FXML
	private TableView<CalendarPopulator> calendarPopulator;
	@FXML
	private TableColumn<CalendarPopulator, String> mandagColumn;
	@FXML
	private TableColumn<CalendarPopulator, String> tirsdagColumn;
	@FXML
	private TableColumn<CalendarPopulator, String> onsdagColumn;
	@FXML
	private TableColumn<CalendarPopulator, String> torsdagColumn;
	@FXML
	private TableColumn<CalendarPopulator, String> fredagColumn;

	@FXML
	private Label mandagLabel;
	@FXML
	private Label tirsdagLabel;
	@FXML
	private Label onsdagLabel;
	@FXML
	private Label torsdagLabel;
	@FXML
	private Label fredagLabel;
	
	public CalendarScreenController() {
		
	}

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
		mandagColumn.setCellValueFactory(cellData -> cellData.getValue().mandagProperty());
		tirsdagColumn.setCellValueFactory(cellData -> cellData.getValue().tirsdagProperty());
		onsdagColumn.setCellValueFactory(cellData -> cellData.getValue().onsdagProperty());
		torsdagColumn.setCellValueFactory(cellData -> cellData.getValue().torsdagProperty());
		fredagColumn.setCellValueFactory(cellData -> cellData.getValue().fredagProperty());
	}

}
