package customKeywords

import com.kms.katalon.core.annotation.Keyword
import java.util.Random

class RandomDataGenerator {

	@Keyword
	String generateRandomStringWithSpecialChars(int length) {
		// Define the character set, escape $ with a backslash to avoid interpolation error
		String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#\$%^&*()-_=+{}[]|:;<>,.?/"

		// Create a StringBuilder to hold the generated string
		StringBuilder randomString = new StringBuilder()

		// Initialize a Random object to generate random indexes
		Random random = new Random()

		// Loop to generate the random string of the specified length
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(charSet.length())  // Get a random index from the charSet
			randomString.append(charSet.charAt(randomIndex))    // Append the character at the random index
		}

		// Return the generated random string
		return randomString.toString()
	}
}
