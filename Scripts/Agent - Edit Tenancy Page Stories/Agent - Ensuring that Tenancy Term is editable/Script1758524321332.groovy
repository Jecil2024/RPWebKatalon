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
import java.util.Arrays as Arrays
import java.time.Duration as Duration
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.temporal.ChronoUnit as ChronoUnit

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

// ===== Step 1: Get the Proposed Start Date from the field =====
String startDateStr = WebUI.getAttribute(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Proposed start date field'), 
    'value')

// Example: "26-09-2025"
Date parsedStart = new SimpleDateFormat('dd-MM-yyyy').parse(startDateStr)

String expectedStartDate = new SimpleDateFormat('d MMMM yyyy').format(parsedStart)

println('DEBUG - Start date from field: ' + expectedStartDate)

// ✅ Your dropdown Test Object
TestObject tenancyDropdown = findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy - Tenancy Term dropdown')

// Get the dropdown <select> element
WebElement dropdownElement = WebUI.findWebElement(tenancyDropdown, 10)

List<WebElement> options = dropdownElement.findElements(By.tagName('option'))

// --- Pick one random tenancy term ---
Random rand = new Random()

int randomIndex = rand.nextInt(options.size() // random index between 0 and last
    )

WebElement randomOption = options.get(randomIndex)

// Select the option
randomOption.click()

// Log the selection
String selectedText = randomOption.getText().trim()

println('🎲 Randomly selected tenancy term: ' + randomOption.getText().trim())

// Extract number of months
int tenancyMonths = Integer.parseInt(selectedText.replaceAll('[^0-9]', ''))

// ===== Step 3: Compute expected end date =====
Calendar cal = Calendar.getInstance()

cal.setTime(parsedStart)

cal.add(Calendar.MONTH, tenancyMonths)

cal.add(Calendar.DATE, -1 // subtract 1 day
    )

String expectedEndDate = new SimpleDateFormat('d MMMM yyyy').format(cal.getTime())

println('DEBUG - Expected End Date: ' + expectedEndDate)

// Toggle for Consent
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_09B7E toggle consent for tenant'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt'))

WebUI.delay(2)

// ===== Step 5: Get the displayed tenancy info from UI =====
TestObject tenancyInfoObj = new TestObject('tenancyInfo')

tenancyInfoObj.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'checkstablecontainer\']//span/p')

String tenancyInfoText = WebUI.getText(tenancyInfoObj)

println('DEBUG - Raw UI text: ' + tenancyInfoText)

// Normalize UI text (remove 1st, 2nd, etc.)
String normalizedUI = tenancyInfoText.replaceAll('(?i)(\\d{1,2})(st|nd|rd|th)', '$1').trim()

println('DEBUG - Normalized UI text: ' + normalizedUI)

// ===== Step 6: Validation =====
String expectedRange = (expectedStartDate + ' until ') + expectedEndDate

if (normalizedUI.contains(expectedRange)) {
    KeywordUtil.markPassed(('✅ Validation successful: UI shows correct tenancy period [' + expectedRange) + ']')
} else {
    KeywordUtil.markFailed(((('❌ Validation failed! Expected [' + expectedRange) + '] but got [') + tenancyInfoText) + ']')
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

