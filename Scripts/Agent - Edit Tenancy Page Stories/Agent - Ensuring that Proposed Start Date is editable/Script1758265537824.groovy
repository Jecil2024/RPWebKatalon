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
import java.util.Random as Random
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('')

'Navigate homepage'
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

'Search tenancy'
WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), '79AFF')

WebUI.sendKeys(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Jecil/Agent/Onboarding - New Tenancy Column - Agency Terms bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Onboarding - Edit Tenancy bt'))

// How many days ahead you want (e.g., 7 days in the future)
int daysInFuture = 7

// Generate the future date
Calendar cal = Calendar.getInstance()

cal.add(Calendar.DATE, daysInFuture)

String futureDate = new SimpleDateFormat('dd-MM-yyyy').format(cal.getTime())

println('DEBUG - Future proposed start date: ' + futureDate)

// Clear any existing value first
WebUI.clearText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Proposed start date field'))

// Set the dynamic future date
WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Proposed start date field'), 
    futureDate)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_09B7E toggle consent for tenant'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt'))

WebUI.delay(2)

// ===== Validation of displayed date =====
// Convert expected date into UI format "d MMMM yyyy" (e.g., "26 September 2025")
Date parsedDate = new SimpleDateFormat('dd-MM-yyyy').parse(futureDate)

String expectedUIDate = new SimpleDateFormat('d MMMM yyyy').format(parsedDate)

println(('DEBUG - Expected UI date: [' + expectedUIDate) + ']')

// Capture tenancy info text from UI
TestObject tenancyInfoObj = new TestObject('tenancyInfo')

WebUI.delay(2)

tenancyInfoObj.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'checkstablecontainer\']//span/p')

String tenancyInfoText = WebUI.getText(tenancyInfoObj)

println(('DEBUG - Raw tenancy info text: [' + tenancyInfoText) + ']')

// Normalize UI text (remove ordinal suffixes like "st", "nd", "rd", "th")
String tenancyInfoNormalized = tenancyInfoText.replaceAll('(?i)(\\d{1,2})(st|nd|rd|th)', '$1')

tenancyInfoNormalized = tenancyInfoNormalized.replaceAll('\\s+', ' ').trim()

println(('DEBUG - Normalized tenancy info text: [' + tenancyInfoNormalized) + ']')

// Check if normalized UI text contains the expected date
if (tenancyInfoNormalized.contains(expectedUIDate)) {
    KeywordUtil.markPassed("✅ Date validation successful: Found '$expectedUIDate' in the UI.")
} else {
    KeywordUtil.markFailed("❌ Date validation failed! Expected '$expectedUIDate' but UI showed: '$tenancyInfoText'")
}

// ============ LOGOUT ============
WebUI.refresh()

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

