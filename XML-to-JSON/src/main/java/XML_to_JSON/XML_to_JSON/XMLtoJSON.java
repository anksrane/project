package XML_to_JSON.XML_to_JSON;

import java.io.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/*Using Jackson Object Convert to JSON*/
public class XMLtoJSON {

	public static void main(String[] args) throws Exception {
		FormatXML objXML = new FormatXML();
		String FormattedXmlString = objXML.FormatXMLData();
		String checkFile="File Not Found...!";
		if(FormattedXmlString==checkFile) {
			System.out.println(FormattedXmlString);
		}else {
			// Read XML File
			XmlMapper xmlMapper = new XmlMapper();
			//Convert to JSON Object and Print
			xmlMapper.registerModule(
					new SimpleModule().addDeserializer(JsonNode.class, new DuplicateToArrayJsonNodeDeserializer()));
			JsonNode jsonNode = xmlMapper.readTree(FormattedXmlString);
			ObjectMapper objectMapper = new ObjectMapper();
			String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
			System.out.println(value);
			
			File myObj = new File("C:\\Users\\ankirane\\Desktop\\Ankit Courses\\Working-Directory\\Eclipse\\XML-to-JSON\\File\\udi.json");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());				
				System.out.println("File created: " + myObj.getAbsolutePath());				
			} else {
				System.out.println("File already exists.");
			}
		      FileWriter myWriter = new FileWriter(myObj);
		      myWriter.write(value);
		      myWriter.close();
		}
	}
}
