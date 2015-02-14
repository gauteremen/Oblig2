package no.uib.gre002.info233.v2015.oblig2.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import no.uib.gre002.info233.v2015.oblig2.models.Activity;
import no.uib.gre002.info233.v2015.oblig2.models.UIBbuilding;
import no.uib.gre002.info233.v2015.oblig2.models.UIBroom;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class BuildingParser implements ParserInterface {

	Pattern pattern;
	Matcher matcher;
	List<UIBbuilding> uibBuildings = new ArrayList<UIBbuilding>();
	List<UIBroom> uibRooms = new ArrayList<UIBroom>();
	Elements buildings = null;

	public BuildingParser() {
		createBuilding(buildings);
	}
	
	
	/**
	 * Find the buildings in the HTML document
	 * 
	 * @throws IOException
	 */
	public void getValueFromHTML(String url) throws IOException {
		
		Document doc = Jsoup.connect(url).get();
		Elements realTimeValues = doc.select("option[value*=:]");

//		createBuilding(realTimeValues);
		createRooms(realTimeValues);
	}

	/**
	 * Cleans the building tags for special characters and unnecessary text,
	 * using regex, and creates objects from the output.
	 * 
	 * @param buildings
	 */
	private void createBuilding(Elements buildings) {
		for (Element building : buildings) {

			pattern = Pattern
					.compile("([\\wÅ,Ø][\\d+|\\w+][\\d+|\\w+]?\\d?\\w?\\w?)");
			matcher = pattern.matcher(building.text());

			if (matcher.find()) {
				UIBbuilding uib_building = new UIBbuilding(matcher.group(0));
				uibBuildings.add(uib_building);
			}
			for (int i = 0; i < uibBuildings.size(); i++) {
				System.out.println(uibBuildings.get(i).getName());
		}		
	}
	}
	
	private void createRooms(Elements rooms) {

		for (Element room : rooms) {
			pattern = Pattern
					.compile(":([^)]+)");
			matcher = pattern.matcher(room.text());

			if (matcher.find()) {
				UIBroom uib_room = new UIBroom(matcher.group(1));
				uibRooms.add(uib_room);
			}
		}
		for (int i = 0; i < uibRooms.size(); i++) {
			System.out.println(uibRooms.get(i).getName());
		}
	}

	@Override
	public void docToLists() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Node> nodesToList(Node node, Node parent, List<Node> nodeList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node> getNodeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getActivityList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getDateStringList() {
		// TODO Auto-generated method stub
		return null;
	}

}
