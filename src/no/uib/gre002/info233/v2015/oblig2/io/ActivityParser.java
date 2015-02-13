package no.uib.gre002.info233.v2015.oblig2.io;

import java.util.ArrayList;
import java.util.List;

import no.uib.gre002.info233.v2015.oblig2.models.Activity;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class ActivityParser implements ParserInterface {
	
	private String roomCode;
	private Document document;
	private List<Node> nodes;
	private String[] dates = new String[5];
	
	public ActivityParser(Document document, String roomCode) {
		this.document = document;
		nodes = new ArrayList<Node>();
	}

	@Override
	public void docToLists() {
		nodesToList(document, null, nodes);
	}

	@Override
	public List<Node> nodesToList(Node paramnode, Node parent,
			List<Node> nodeList) {

		List<Node> children = paramnode.childNodes();
		if (!children.isEmpty()) {
			for (Node node : children) {
				nodesToList(node, paramnode, nodeList);
			}
		}

		nodeList.add(paramnode);

		return nodeList;
	}


	private Node getCalendarNode() {
		for (Node node : nodes) {
			if (node instanceof Element && node.attr("class").equals("calendar")) {
				return node;
			}
		}
		return null;
	}

	@Override
	public List<Node> getNodeList() {
		return nodes;
	}

	@Override
	public List<Activity> getActivityList() {

		List<Activity> activityList = new ArrayList<Activity>(); 

		List<Node> rowList = (getCalendarNode().childNode(0).childNodes());
		//TODO
		dates = parseDates(rowList.get(1));

		for (int row = 3; row < rowList.size(); row+=2) {
			List<Node> cells = rowList.get(row).childNodes();

			for (int cellnumber = 2; cellnumber < cells.size(); cellnumber+=2) {
				Node cell = cells.get(cellnumber);
				List<Node> cellNodes = new ArrayList<Node>();
				nodesToList(cell, null, cellNodes);

				Activity temp = extractActivity(cellNodes, cell, cellnumber / 2);

				if(temp != null)
					activityList.add(temp);
			}
		}

		return null;
	}

	private String[] parseDates(Node dateRow){
		String[] datestrings = new String[5];
		List<Node> dates = new ArrayList<Node>(dateRow.childNodes());
		for(int cellnumber = 1; cellnumber < dates.size(); cellnumber++){
			datestrings[cellnumber-1] = dates.get(cellnumber).childNode(0).toString();
		}


		return datestrings;
	}


	public Activity extractActivity(List<Node> nodes, Node activityNode, int day) {

		String emneString = null;
		String descString = null;
		String timeString = null;

		for (Node currnode : nodes) {

			String classString = currnode.attr("class");
			if (currnode.childNodeSize() != 0) {

				if (classString.equals("emne"))
					emneString = currnode.childNode(0).toString();
				else if (classString.equals("time"))
					timeString = currnode.childNode(0).toString();
				else if (classString.equals("item_desc"))
					descString = currnode.childNode(0).toString();
			}

			if (descString != null && timeString != null && emneString != null) {
				Activity activity = new Activity(activityNode, emneString, timeString, descString, roomCode, dates[day]);
				System.out.println(activity);

				return activity;
			}
		}
		return null;
	}

	@Override
	public List<String> getDateStringList() {
		// TODO Auto-generated method stub
		return null;
	}

}
