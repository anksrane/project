package XML_to_JSON.XML_to_JSON;

import java.io.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/*Using Jackson Object Convert to JSON*/
public class XMLtoJSON {

	public static void main(String[] args) throws Exception {
		FormatXML obj = new FormatXML();
		String FormattedString = obj.EmptyXML();
		try {
			// Read XML File
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.registerModule(
					new SimpleModule().addDeserializer(JsonNode.class, new DuplicateToArrayJsonNodeDeserializer()));
			JsonNode jsonNode = xmlMapper.readTree(FormattedString);
			ObjectMapper objectMapper = new ObjectMapper();
			String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
			System.out.println(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
