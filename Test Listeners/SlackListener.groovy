import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import groovy.json.JsonOutput
import java.net.HttpURLConnection
import java.net.URL

class SlackListener {

    static int total = 0
    static int passed = 0
    static int failed = 0
    static int error = 0
    static int skipped = 0

    // Replace with your Slack Incoming Webhook URL
    static String webhookUrl = "https://hooks.slack.com/services/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"

    @AfterTestCase
    def countResults(TestCaseContext testCaseContext) {
        total++
        switch (testCaseContext.getTestCaseStatus()) {
            case "PASSED":
                passed++
                break
            case "FAILED":
                failed++
                break
            case "ERROR":
                error++
                break
            case "SKIPPED":
                skipped++
                break
        }
    }

    @AfterTestSuite
    def notifySlack(TestSuiteContext suiteContext) {
        try {
            String suiteName = suiteContext.getTestSuiteId()

            String message = """*Summary execution result of test suite:* ${suiteName}
• Total test cases: ${total}
• ✅ Passed: ${passed}
• ❌ Failed: ${failed}
• ⚠️ Errors: ${error}
• ⏭ Skipped: ${skipped}"""

            sendToSlack(message)
        } catch (Exception e) {
            println("❌ Failed to prepare Slack notification: ${e.message}")
        }
    }

    static void sendToSlack(String text) {
        try {
            String payload = JsonOutput.toJson([text: text])
            URL url = new URL(webhookUrl)
            HttpURLConnection conn = (HttpURLConnection) url.openConnection()
            conn.setRequestMethod("POST")
            conn.setDoOutput(true)
            conn.setRequestProperty("Content-Type", "application/json")

            conn.outputStream.withWriter("UTF-8") { it.write(payload) }

            int responseCode = conn.responseCode
            String responseMsg = conn.inputStream.text
            println("✅ Slack response: ${responseCode} - ${responseMsg}")

        } catch (Exception e) {
            println("❌ Failed to send Slack notification: ${e.message}")
        }
    }
}
