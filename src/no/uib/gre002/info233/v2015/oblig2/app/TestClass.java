package no.uib.gre002.info233.v2015.oblig2.app;

import java.util.List;

import no.uib.gre002.info233.v2015.oblig2.io.ActivityParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

public class TestClass {

	public static void main(String[] args) {
		String url = "http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building=BIO%3A&room=BIO%3AK2";
		try {
			Document doc = Jsoup.connect(url).get();
			
			ActivityParser parser = new ActivityParser(doc, "BIO 3");
			parser.docToLists();
			List<Node> nodes = parser.getNodeList();
			
			parser.getActivityList();
			
			System.out.println("Done bruh");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
