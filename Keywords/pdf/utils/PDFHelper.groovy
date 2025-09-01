package pdf.utils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import java.io.File

class PDFHelper {

	@Keyword
	def verifyPDFContainsText(String filePath, String expectedText) {
		File file = new File(filePath)
		if (!file.exists()) {
			KeywordUtil.markFailed("PDF file not found at path: " + filePath)
			return
		}

		PDDocument document = PDDocument.load(file)
		String pdfText = new PDFTextStripper().getText(document)
		document.close()

		if (pdfText.contains(expectedText)) {
			KeywordUtil.markPassed("Found text: '${expectedText}' in PDF.")
		} else {
			KeywordUtil.markFailed("Text '${expectedText}' NOT found in PDF.")
		}
	}
}