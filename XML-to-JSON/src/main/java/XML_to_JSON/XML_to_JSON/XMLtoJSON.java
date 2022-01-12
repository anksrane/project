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
		FormatJSON objJSON=new FormatJSON();
		String FormattedXmlString = objXML.FormatXMLData();
		try {
			// Read XML File
			XmlMapper xmlMapper = new XmlMapper();
			//Convert to JSON Object and Print
			xmlMapper.registerModule(
					new SimpleModule().addDeserializer(JsonNode.class, new DuplicateToArrayJsonNodeDeserializer()));
			JsonNode jsonNode = xmlMapper.readTree(FormattedXmlString);
			ObjectMapper objectMapper = new ObjectMapper();
			String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
//			String FormattedJsonString=objJSON.FormatJSONData(value);
			System.out.println(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
