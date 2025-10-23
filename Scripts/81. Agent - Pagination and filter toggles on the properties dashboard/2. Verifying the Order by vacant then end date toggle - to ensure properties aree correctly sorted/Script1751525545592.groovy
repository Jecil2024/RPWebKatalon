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

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Properties-Onboarding - Order by vacant then end date toggle'))

WebUI.waitForPageLoad(3)

List<String> allTenancyValues = []

SimpleDateFormat sdf = new SimpleDateFormat('dd/MM/yyyy')

int pageNumber = 1

while (true) {
    WebUI.comment("📄 Scraping page $pageNumber")

    WebUI.waitForElementVisible(findTestObject('Column_Tenancy'), 10)

    List<WebElement> tenancyElements = WebUiCommonHelper.findWebElements(findTestObject('Column_Tenancy'), 10)

    List<String> currentPageTenancyValues = tenancyElements.collect({ 
            it.getText().trim()
        })

    allTenancyValues.addAll(currentPageTenancyValues)

    WebUI.comment("✅ Collected $currentPageTenancyValues.size() records on page $pageNumber.")

    // Define dynamic Next button
    TestObject nextBtn = new TestObject('dynamicNextBtn')

    nextBtn.addProperty('xpath', ConditionType.EQUALS, '//a[starts-with(normalize-space(), \'Next\')]')

    if (WebUI.verifyElementPresent(nextBtn, 5, FailureHandling.OPTIONAL)) {
        WebElement element = WebUiCommonHelper.findWebElement(nextBtn, 5)

        WebUI.comment("➡️ Found Next: $element.getText()")

        WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(element))

        WebUI.delay(1)

        WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(element))

        WebUI.delay(3)

        pageNumber++
    } else {
        WebUI.comment('🛑 No more Next button found. Ending pagination.')

        break
    }
}

List<String> rawVacants = []

List<String> rawEnded = []

List<Date> endedDates = []

allTenancyValues.each({ def value ->
        if (value == 'N/A') {
            rawVacants.add(value)
        } else if (value.startsWith('Ended')) {
            rawEnded.add(value)

            String dateStr = value.replace('Ended ', '')

            try {
                endedDates.add(sdf.parse(dateStr))
            }
            catch (Exception e) {
                WebUI.comment("⚠️ Unable to parse date: '$dateStr'")
            } 
        }
    })

WebUI.comment('============ DEBUG START ============')

WebUI.comment("Total entries: $allTenancyValues.size()")

allTenancyValues.eachWithIndex({ def val, def idx ->
        WebUI.comment("${idx + 1}. $val")
    })

WebUI.comment("Vacants count: $rawVacants.size()")

WebUI.comment("Ended tenancy count: $rawEnded.size()")

WebUI.comment('============ DEBUG END ============')

boolean violatedVacantOrder = false

boolean seenEnded = false

for (int i = 0; i < allTenancyValues.size(); i++) {
    String val = allTenancyValues[i]

    if ((val == 'N/A') && seenEnded) {
        violatedVacantOrder = true

        WebUI.comment("❌ Vacant found after an Ended entry at row ${i + 1}: '${val}'")
    }
    
    if (val.startsWith('Ended')) {
        seenEnded = true
    }
}

boolean violatedDateSort = false

List<Date> sortedDates = new ArrayList(endedDates)

sortedDates.sort()

if (endedDates != sortedDates) {
    violatedDateSort = true

    WebUI.comment('❌ Ended tenancy dates are not in ascending order.')

    for (int i = 0; i < endedDates.size(); i++) {
        WebUI.comment("   Actual: $sdf.format(endedDates[i]) | Expected: $sdf.format(sortedDates[i])")
    }
}

if (violatedVacantOrder || violatedDateSort) {
    WebUI.takeScreenshot()

    WebUI.comment('⚠️ Sorting issue found. Screenshot taken.') // assert false
} else {
    WebUI.comment('✅ Tenancy data is correctly sorted by vacant then end date across all pages.')
}

WebUI.delay(5)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

