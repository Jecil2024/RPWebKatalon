package invalidNumber  // Correct package name, should match folder structure

import com.kms.katalon.core.annotation.Keyword  // Import the Keyword annotation
import java.util.Random

// The class should be public
public class GenerateInvalidMobileNumber {

	// Mark the method with @Keyword so it can be used in test cases
	@Keyword
	def generateInvalidMobileNumber() {
		Random rand = new Random()

		// Define a few invalid formats for phone numbers
		String[] invalidFormats = [
			"abc123456",
			// Invalid due to letters
			"123@56789",
			// Invalid due to special characters
			//"123456789012345",
			// Too long
			//"0000000000"   // Invalid or reserved number
		]

		// Pick a random invalid phone number format
		String invalidNumber = invalidFormats[rand.nextInt(invalidFormats.length)]

		// Return the invalid number
		return invalidNumber
	}
}
