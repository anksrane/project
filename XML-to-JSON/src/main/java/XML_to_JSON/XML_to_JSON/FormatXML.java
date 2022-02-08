package XML_to_JSON.XML_to_JSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatXML {
	public String FormatXMLData() throws Exception {
		File xmlFile = new File(
				"C:\\Users\\ankirane\\Desktop\\Ankit Courses\\Working-Directory\\Eclipse\\XML-to-JSON\\File\\udi.xml");
		String xmlString = "";
		String regex = "([a-z])([A-Z]+)";
		String replacement = "$1_$2";
		String underScoreUpperCase = "_[A-Z]+";
		String[] patterns = new String[] {
				// This will remove empty elements that look like <ElementName />
				"\\s*<\\w+ />",
				// This will remove empty elements that look like <ElementName/>
				"\\s*<\\w+/>",
				// This will remove empty elements that look like <ElementName></ElementName>
				"\\s*<\\w+></\\w+>",
				// This will remove empty elements that look like
				// <ElementName>
				// </ElementName>
				"\\s*<\\w+>\n*\\s*</\\w+>" };
		if(xmlFile.exists()) {
			Reader fileReader = new FileReader(xmlFile);
			// Convert XML to String
			BufferedReader bufReader = new BufferedReader(fileReader);
			try {
				StringBuilder sb = new StringBuilder();
				String line = bufReader.readLine();
				while (line != null) {
					sb.append(line).append("\n");
					line = bufReader.readLine();
				}
				xmlString = sb.toString();
				// Remove Empty XML Tag
				for (String pattern : patterns) {
					Matcher matcher = Pattern.compile(pattern).matcher(xmlString);
					xmlString = matcher.replaceAll("");
				}
				// To Change Camel Casing to UnderScoreUpperCase 
				xmlString = xmlString.replaceAll(regex, replacement);

				// To change to UnderScoreUpperCase to LowerCase
				Pattern pattern = Pattern.compile(underScoreUpperCase);
				Matcher matcher = pattern.matcher(xmlString);
				xmlString = matcher.replaceAll(matche -> matche.group().toLowerCase());
			} finally {
			}
			bufReader.close();
		}else {
			xmlString="File Not Found...!";
		}
		return xmlString;
	}
}
