import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

def url = "https://slack.com/api/chat.postMessage"
def token = System.getenv("SLACK_TOKEN")   // ✅ Pull from environment
println("Using Slack Token: " + token)

def body = """
{
    "channel": "katalon",
    "text": "Hello from Katalon ✅"
}
"""

RequestObject request = new RequestObject("Slack Request")
request.setRestUrl(url)
request.setRestRequestMethod("POST")
request.setHttpHeaderProperties([
    new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json"),
    new TestObjectProperty("Authorization", ConditionType.EQUALS, "Bearer " + token)
])
request.setBodyContent(new HttpTextBodyContent(body, "UTF-8", "application/json"))

def response = WS.sendRequest(request)
println("Slack API response: " + response.getResponseText())
