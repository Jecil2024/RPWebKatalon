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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.openBrowser('')

'Navigate homepage'
WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

// Login
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

// Go to Residential Enquiries page
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Top bar - Reporting bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Reporting dashboard - Residential enquiries bt'))

WebUI.delay(3)

// Select the custom range option from the dropdown
WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Residential - Select dropdown filter months'), 
    4 // Adjust index if custom range isn't index 4
    )

WebUI.delay(3)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Residential enquiries - From Select date range'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Residential Enquiries - From date (June 1 2025)'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Residential enquiries - To Select date range'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Residential Enquiries - To date (June 30 2025)'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

// ========== CUSTOM RANGE SETUP ==========
DateTimeFormatter tableFormatter = DateTimeFormatter.ofPattern('dd MMM yyyy')

// Manually define your custom range (update as needed)
LocalDate customStart = LocalDate.of(2025, 6, 1 // 01 June 2025
    )

LocalDate customEnd = LocalDate.of(2025, 6, 30 // 30 June 2025
    )

// ========== PAGINATION LOOP ==========
boolean hasNextPage = true

int pageCount = 1

while (hasNextPage) {
    println("🔄 Checking page $pageCount")

    // Define the 'Received' column TestObject dynamically (adjust td[7] if needed)
    TestObject receivedCol = new TestObject()

    receivedCol.addProperty('xpath', ConditionType.EQUALS, '//table//tr/td[7]/p')

    // Get all date elements in the current page
    List<WebElement> receivedDateElements = WebUiCommonHelper.findWebElements(receivedCol, 10)

    for (WebElement el : receivedDateElements) {
        String fullDate = el.getText().trim( // e.g., "18 Jun 2025, 17:21"
            )

        if (fullDate.isEmpty() || fullDate.contains('IDEAL MOVE IN')) {
            continue
        }
        
        try {
            String dateOnly = (fullDate.split(',')[0]).trim( // "18 Jun 2025"
                )

            LocalDate parsedDate = LocalDate.parse(dateOnly, tableFormatter)

            if (parsedDate.isBefore(customStart) || parsedDate.isAfter(customEnd)) {
                KeywordUtil.markFailed("❌ Received date '$dateOnly' is OUTSIDE the range ($customStart to $customEnd)")
            } else {
                println("✅ Received date '$dateOnly' is within range.")
            }
        }
        catch (Exception e) {
            KeywordUtil.markWarning("⚠️ Could not parse date '$fullDate': $e.message")
        } 
    }
    
    // Scroll to bottom to trigger pagination visibility
    JavascriptExecutor js = ((DriverFactory.getWebDriver()) as JavascriptExecutor)

    js.executeScript('window.scrollTo(0, document.body.scrollHeight)')

    WebUI.delay(2)

    // Check if a "Next" page button exists
    TestObject nextPageBtn = new TestObject()

    nextPageBtn.addProperty('xpath', ConditionType.EQUALS, '//a[contains(text(),"Next")]')

    if (WebUI.verifyElementPresent(nextPageBtn, 3, FailureHandling.OPTIONAL)) {
        WebUI.click(nextPageBtn)

        WebUI.delay(3)

        pageCount++
    } else {
        hasNextPage = false
    }
}

// Logout
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.closeBrowser()

