package no.uib.gre002.info233.v2015.oblig2.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ParserController {
	
	
	public static String getBuildingURL(String buildingCode){
		
		Pattern pattern = Pattern
				.compile("(\\w[^)]+:)");
		Matcher matcher = pattern.matcher(buildingCode);
		
		if(matcher.find()) {
			return "http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building=" + matcher.group(0);
		}
		return null;
	}
}
