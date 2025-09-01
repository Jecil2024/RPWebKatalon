import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.util.Arrays as Arrays

WebUI.openBrowser('')

'Navigate homepage'
WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

// LOGIN
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Homepage Login - Agent login bt'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'stagingtestingagency@rentprofile.co')

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'test442s')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

// Navigate to Commercial Enquiries
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Top bar - Reporting bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Reporting - Commercial enquiries'))

WebUI.delay(3)

// Prepare date checking
DateTimeFormatter formatter3Mo = DateTimeFormatter.ofPattern('dd/MM/yyyy')

LocalDate today = LocalDate.now()

LocalDate threeMonthsAgo = today.minusMonths(3)

boolean hasNextPage = true

int page = 1

while (hasNextPage) {
    println("✅ Checking page: $page")

    TestObject receivedCol3Mo = new TestObject()

    receivedCol3Mo.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//table//tr/td[7]/p')

    List<WebElement> receivedDateElements3Mo = WebUiCommonHelper.findWebElements(receivedCol3Mo, 10)

    for (WebElement el : receivedDateElements3Mo) {
        String rawDate = el.getText().trim()

        if (rawDate.isEmpty()) {
            continue
        }
        
        // ✅ Skip invalid values like "NUMBER" or non-date formats
        if (!(rawDate.matches('\\d{2}/\\d{2}/\\d{4}'))) {
            println("⚠️ Skipping invalid date format: '$rawDate'")

            continue
        }
        
        try {
            LocalDate parsedDate = LocalDate.parse(rawDate, formatter3Mo)

            if (parsedDate.isBefore(threeMonthsAgo)) {
                KeywordUtil.markFailed("❌ Date '$rawDate' is older than 3 months.")
            }
        }
        catch (Exception e) {
            KeywordUtil.markWarning("⚠️ Unexpected parsing error: '$rawDate' - $e.message")
        } 
    }
    
    // 🔄 Pagination: click Next if exists
    TestObject nextBtn = new TestObject()

    nextBtn.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//li[contains(@class,"next")]//a')

    try {
        WebElement nextElement = WebUiCommonHelper.findWebElement(nextBtn, 5)

        if (((nextElement != null) && nextElement.isDisplayed()) && nextElement.isEnabled()) {
            WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(nextElement))

            WebUI.delay(1)

            WebUI.click(nextBtn)

            WebUI.delay(3)

            page++
        } else {
            hasNextPage = false

            println('✅ Reached last page (no more Next button).')
        }
    }
    catch (Exception e) {
        hasNextPage = false

        println("✅ Stopped pagination loop. Reason: $e.message")
    } 
}

WebUI.delay(5)

// LOGOUT
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.closeBrowser()

