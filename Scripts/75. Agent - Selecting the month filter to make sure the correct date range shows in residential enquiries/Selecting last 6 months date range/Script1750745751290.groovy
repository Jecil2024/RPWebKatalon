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

// Set the filter to 6 months (assumes index 1 is 6 months)
WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Residential - Select dropdown filter months'), 
    1)

WebUI.delay(5)

// Setup formatter and threshold date
DateTimeFormatter formatter = DateTimeFormatter.ofPattern('dd/MM/yyyy')

LocalDate today = LocalDate.now()

LocalDate sixMonthsAgo = today.minusMonths(6)

// Define TestObject for date cells
TestObject dateCell = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//table//tr/td[7]/p')

// Define TestObject for Next button
TestObject nextPageBtn = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//a[contains(text(),\'Next\')]')

// Loop through pages
boolean hasNextPage = true

while (hasNextPage) {
    // Get all date elements on current page
    List<WebElement> dateElements = WebUiCommonHelper.findWebElements(dateCell, 10)

    for (WebElement el : dateElements) {
        String rawDate = el.getText().trim()

        if (rawDate.isEmpty() || rawDate.contains('IDEAL MOVE IN')) {
            continue
        }
        
        try {
            LocalDate parsedDate = LocalDate.parse(rawDate, formatter)

            if (parsedDate.isBefore(sixMonthsAgo)) {
                KeywordUtil.markFailed("❌ 'Received' date '$rawDate' is older than 6 months.")
            }
        }
        catch (Exception e) {
            KeywordUtil.markFailed("⚠️ Failed to parse date: '$rawDate' - $e.message")
        } 
    }
    
    // Scroll down to reveal pagination
    WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight);', null)

    WebUI.delay(2)

    // Check if next page exists
    if (WebUI.verifyElementPresent(nextPageBtn, 3, FailureHandling.OPTIONAL)) {
        WebUI.click(nextPageBtn)

        WebUI.delay(3)
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

