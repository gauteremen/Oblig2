package no.uib.gre002.info233.v2015.oblig2.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.nodes.Node;

public class Activity implements ActivityInterface, Serializable {

	private static final long serialVersionUID = -4962193791986602328L;
	private Node activityNode;
	private String emne;
	private String description;
	private String roomCode;
	private Calendar startCalendar;
	private Calendar endCalendar;

	public Activity(Node activityNode, String emne, String time,
			String description, String roomCode, String date) {
		this.startCalendar = parseCalendarDate(date, time.substring(0, 5));
		this.endCalendar = parseCalendarDate(date, time.substring(6, 11));
		this.activityNode = activityNode;
		this.emne = emne;
		this.description = description;
		this.roomCode = roomCode;
	}

	private Calendar parseCalendarDate(String dateString, String timeString) {

		String formatedDateString = timeString + "."
				+ dateString.substring(8, dateString.length());
		SimpleDateFormat dateformater = new SimpleDateFormat("HH:mm.dd.MM.yyyy");

		try {
			Date date = dateformater.parse(formatedDateString);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String toString() {
		return emne + " " + description + " "
				+ startCalendar.get(Calendar.HOUR_OF_DAY) + ":"
				+ startCalendar.get(Calendar.MINUTE);
	}

	@Override
	public Node getNode() {
		return activityNode;
	}

	@Override
	public String getType() {
		return description;
	}

	@Override
	public String getRoom() {
		return roomCode;
	}

	@Override
	public Calendar getBeginTime() {
		return startCalendar;
	}

	@Override
	public Calendar getEndTime() {
		return endCalendar;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
