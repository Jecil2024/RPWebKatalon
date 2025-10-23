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
import com.kms.katalon.core.util.KeywordUtil

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

// Generate a random rental amount between 1000 and 2500
Random rand = new Random()
def rentalAmount = (rand.nextInt(1501) + 1000).toString()

// Input the dynamic value into the rental amount field
WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Rental amount field'), 
    rentalAmount)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_09B7E toggle consent for tenant'))
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt'))
WebUI.delay(2)

// Create TestObject for the tenancy term / rental amount display
TestObject rentalObj = new TestObject("rentalAmountText")
rentalObj.addProperty("xpath", ConditionType.EQUALS, "//div[@id='checkstablecontainer']//span/p")

// Wait until the element is visible
WebUI.waitForElementVisible(rentalObj, 10)

// Capture the text from UI
String rentalText = WebUI.getText(rentalObj)
println("DEBUG - Raw UI text captured: [" + rentalText + "]")

// Cut off everything after "per month"
String amountOnly = rentalText.split(" per month")[0].trim()
println("DEBUG - Amount only: [" + amountOnly + "]")

// Remove currency + commas, but keep the decimal for now
amountOnly = amountOnly.replace("£", "").replace(",", "")
println("DEBUG - Cleaned amount (with decimal): [" + amountOnly + "]")

// Take only the part before the decimal point
String actualRentalAmount = amountOnly.split("\\.")[0]
println("DEBUG - Parsed UI amount (final): [" + actualRentalAmount + "]")

// Expected value
println("DEBUG - Expected rental amount (input): [" + rentalAmount + "]")

// Safeguard
if (actualRentalAmount.isEmpty()) {
    KeywordUtil.markFailed("No numeric rental amount found in UI text: " + rentalText)
}

// Compare values
boolean isMatch = WebUI.verifyMatch(actualRentalAmount, rentalAmount, false, FailureHandling.CONTINUE_ON_FAILURE)

if (!isMatch) {
    KeywordUtil.markFailed("❌ Mismatch! Expected [" + rentalAmount + "] but UI showed [" + actualRentalAmount + "]")
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
