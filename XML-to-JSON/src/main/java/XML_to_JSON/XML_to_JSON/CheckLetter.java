package XML_to_JSON.XML_to_JSON;

public class CheckLetter {

	public static void main(String[] args) {
		// create a string
		String message = "Everyone_Loves_Java Having";
		// stores each characters to a char array
		char[] charArray = message.toCharArray();
		boolean foundSpace = true;
		for (int i = 0; i < charArray.length; i++) {
			// if the array element is a letter
			if (Character.isLetter(charArray[i])) {
				// check space is present before the letter
				if (foundSpace) {
					// change the letter into uppercase
					charArray[i] = Character.toLowerCase(charArray[i]);
					foundSpace = false;
				}
			} else {
				// if the new character is not character
				foundSpace = true;
			}
		}

		// convert the char array to the string
		message = String.valueOf(charArray);
		System.out.println("Message: " + message);
	}
}
