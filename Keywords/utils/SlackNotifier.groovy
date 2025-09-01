package utils  // 👈 make sure this matches your folder inside Keywords/

import com.kms.katalon.core.annotation.Keyword
import groovy.json.JsonOutput
import java.net.HttpURLConnection
import java.net.URL

public class SlackNotifier {
    
    @Keyword
    static void sendMessage(String message) {
        try {
            String webhookUrl = "https://hooks.slack.com/services/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"
            
            URL url = new URL(webhookUrl)
            HttpURLConnection conn = (HttpURLConnection) url.openConnection()
            conn.setRequestMethod("POST")
            conn.setRequestProperty("Content-Type", "application/json")
            conn.setDoOutput(true)

            String payload = JsonOutput.toJson([text: message])
            conn.outputStream.withWriter("UTF-8") { it.write(payload) }

            int responseCode = conn.getResponseCode()
            println "✅ Slack response code: " + responseCode
        } catch (Exception e) {
            println "❌ Failed to send Slack notification: " + e.message
        }
    }
}
