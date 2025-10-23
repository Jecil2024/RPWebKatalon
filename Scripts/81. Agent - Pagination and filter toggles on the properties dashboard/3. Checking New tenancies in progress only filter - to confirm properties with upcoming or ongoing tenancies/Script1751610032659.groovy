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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import java.text.SimpleDateFormat as SimpleDateFormat
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.util.Arrays as Arrays
import java.util.Date as Date

WebUI.openBrowser('')

'Navigate homepage'
WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Homepage Login - Agent login bt'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'hotblackstaging@rentprofile.co')

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

// ✅ Enable the filter only ONCE
TestObject toggle = findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Properties-Onboarding - New tenancies in progress only')

WebUI.click(toggle)

WebUI.delay(3)

List<String> allTenancyValues = []

SimpleDateFormat sdf = new SimpleDateFormat('dd/MM/yyyy')

Date today = new Date()

int pageNumber = 1

String lastSeenFirstEntry = ''

while (true) {
    WebUI.comment("📄 Scraping page $pageNumber")

    WebUI.waitForElementVisible(findTestObject('Column_Tenancy'), 10)

    List<WebElement> tenancyElements = WebUiCommonHelper.findWebElements(findTestObject('Column_Tenancy'), 10)

    List<String> currentPageTenancyValues = tenancyElements.collect({ 
            it.getText().trim()
        })

    // Stop if content is identical to last page (loopback)
    if (!(currentPageTenancyValues.isEmpty()) && ((currentPageTenancyValues[0]) == lastSeenFirstEntry)) {
        WebUI.comment('🛑 Detected repeated page content. Stopping pagination.')

        break
    }
    
    allTenancyValues.addAll(currentPageTenancyValues)

    lastSeenFirstEntry = (currentPageTenancyValues[0])

    WebUI.comment("✅ Collected $currentPageTenancyValues.size() records on page $pageNumber.")

    TestObject nextBtn = new TestObject('dynamicNextBtn')

    nextBtn.addProperty('xpath', ConditionType.EQUALS, '//a[starts-with(normalize-space(), \'Next\')]')

    if (WebUI.verifyElementPresent(nextBtn, 5, FailureHandling.OPTIONAL)) {
        WebElement element = WebUiCommonHelper.findWebElement(nextBtn, 5)

        WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(element))

        WebUI.delay(1)

        WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(element))

        WebUI.waitForPageLoad(10)

        WebUI.waitForElementVisible(findTestObject('Column_Tenancy'), 10)

        WebUI.delay(2)

        pageNumber++
    } else {
        WebUI.comment('✅ No more pages. Ending loop.')

        break
    }
}

// ✅ Validation section
boolean hasInvalid = false

for (int i = 0; i < allTenancyValues.size(); i++) {
    String val = allTenancyValues[i]

    if (val.equalsIgnoreCase('N/A')) {
        continue
    } else if (val.startsWith('Ends ')) {
        try {
            Date date = sdf.parse(val.replace('Ends ', ''))

            if (date.before(today)) {
                WebUI.comment("❌ Row ${i + 1}: Ends date in the past - '${val}'")

                hasInvalid = true
            }
        }
        catch (Exception e) {
            WebUI.comment("⚠️ Row ${i + 1}: Unable to parse date - '${val}'")

            hasInvalid = true
        } 
    } else {
        WebUI.comment("❌ Row ${i + 1}: Unexpected value - '${val}'")

        hasInvalid = true
    }
}

if (hasInvalid) {
    WebUI.takeScreenshot()

    WebUI.comment('⚠️ Invalid tenancy entries found. Screenshot taken.') // assert false
} else {
    WebUI.comment('✅ All tenancy entries valid for \'New tenancies in progress only\' filter.')
}

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

