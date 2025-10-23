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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import java.util.Arrays as Arrays

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

'Click login button'
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))

WebUI.delay(2)

'Click agent login button'
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Homepage Login - Agent login bt'))

WebUI.delay(2)

'Input email address'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'hotblackstaging@rentprofile.co')

WebUI.delay(2)

'Input password'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72')

WebUI.delay(2)

'Click login button in agent page'
WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

'Individual Referencing'
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Referencing bt'))

WebUI.delay(2)

int pageCount = 1

while (true) {
    println("Currently on page: $pageCount")

    // Locate rows in the table (update if needed)
    TestObject tableRows = new TestObject('rows')

    tableRows.addProperty('xpath', ConditionType.EQUALS, '//*[@id="checkstabletable_tenancies"]/tbody/tr')

    List<WebElement> rows = WebUI.findWebElements(tableRows, 10)

    if (rows.size() > 0) {
        println("Rows found on page $pageCount: $rows.size()")
    } else {
        println("No rows found on page $pageCount.")
    }
    
    // Define the Next button
    TestObject nextButton = new TestObject('nextBtn')

    nextButton.addProperty('xpath', ConditionType.EQUALS, '/html/body/div[3]/div[2]/div/div/div[1]/div[2]/div[3]/div/ul/li[6]/a')

    // Verify if Next button is present
    if (WebUI.verifyElementPresent(nextButton, 5, FailureHandling.OPTIONAL)) {
        // Safety check for disabled class (if applicable)
        String nextClass = WebUI.getAttribute(nextButton, 'class')

        if ((nextClass != null) && nextClass.contains('disabled')) {
            println('Next button is disabled. Reached the last page.')

            break
        }
        
        WebUI.scrollToElement(nextButton, 2)

        WebUI.click(nextButton)

        WebUI.delay(3)

        pageCount++
    } else {
        println('Next button not found. Possibly last page.')

        break
    }
}

WebUI.delay(2)

'Logout'
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

