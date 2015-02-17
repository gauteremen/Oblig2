package no.uib.gre002.info233.v2015.oblig2.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Utility class for constructing URLs
 * @author Anders Eide
 *
 */
public class ParserController {
	
	/**
	 * Method for getting the complete URL for a building from its name and code
	 * @param buildingName The name and code of the building
	 * @return The full URL of the building
	 */
	public static String getBuildingURL(String buildingName){
		
		Pattern pattern = Pattern
				.compile("(\\w[^)]+:)");
		Matcher matcher = pattern.matcher(buildingName);
		
		if(matcher.find()) {
			return "http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building=" + matcher.group(0);
		}
		return null;
	}
}
