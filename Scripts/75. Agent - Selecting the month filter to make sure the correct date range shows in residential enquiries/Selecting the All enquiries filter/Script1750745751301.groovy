import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.testobject.TestObject as TestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.model.FailureHandling as FailureHandling

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

// Navigate to Residential Enquiries
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Top bar - Reporting bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Reporting dashboard - Residential enquiries bt'))

WebUI.delay(3)

// Select "All" from the dropdown (assumed index 3, update if needed)
WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Residential - Select dropdown filter months'), 
    3)

WebUI.delay(3)

// Pagination Loop
boolean hasNextPage = true

int pageCount = 1

while (hasNextPage) {
    println("🔄 Checking page $pageCount")

    TestObject rows = new TestObject()

    rows.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//table//tr')

    List<WebElement> tableRows = WebUiCommonHelper.findWebElements(rows, 10)

    if (tableRows.size() == 0) {
        KeywordUtil.markWarning("⚠️ No rows found on page $pageCount.")
    } else {
        println("✅ Found $tableRows.size() rows on page $pageCount")
    }
    
    // Scroll down to reveal pagination
    JavascriptExecutor js = ((DriverFactory.getWebDriver()) as JavascriptExecutor)

    js.executeScript('window.scrollTo(0, document.body.scrollHeight)')

    WebUI.delay(2)

    // Check for next button
    TestObject nextPageBtn = new TestObject()

    nextPageBtn.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//a[contains(text(),"Next")]')

    if (WebUI.verifyElementPresent(nextPageBtn, 3, FailureHandling.OPTIONAL)) {
        WebUI.click(nextPageBtn)

        WebUI.delay(3)

        pageCount++
    } else {
        hasNextPage = false

        println('✅ Reached last page. No more pagination.')
    }
}

// Logout
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.closeBrowser()

