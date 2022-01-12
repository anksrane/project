package XML_to_JSON.XML_to_JSON;

public class FormatJSON {

	public String FormatJSONData(String value) {
		String rawJson=value;
		String formatedJSON="";
		String regexForN="(\\n)";
		String regexForT="(\\t)";
		formatedJSON=rawJson.replace("\n","1");
		return formatedJSON;
	}

}
