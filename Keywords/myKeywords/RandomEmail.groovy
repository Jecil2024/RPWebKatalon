package myKeywords

import com.kms.katalon.core.annotation.Keyword
import java.util.Random

class RandomEmail {
	@Keyword
	def generateInvalidEmail() {
		def random = new Random()
		def length = 10 // Set the length of the generated email part before the '@'

		// Generate the email prefix
		def emailPrefix = random.ints(48, 122) // ASCII range for characters a-z, A-Z, 0-9
				.filter { it <= 57 || (it >= 65 && it <= 90) || (it >= 97 && it <= 122) } // Filter to valid characters
				.limit(length)
				.collect { (char) it }
				.join('')

		// Append an invalid domain (you can change this to any invalid domain you prefer)
		def invalidDomain = "invalidDomain" // No valid top-level domain (like .com, .org, etc.)
		return emailPrefix + '@' + invalidDomain // Email with @ and invalid domain
	}
}
