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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling

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

// ======================
// Define TestObjects
// ======================

// Holding Deposit toggle
TestObject holdingDepositToggle = new TestObject('holdingDepositToggle')
holdingDepositToggle.addProperty("xpath", ConditionType.EQUALS, '//*[@id="depositstuff"]/table/tbody/tr[1]/td[2]/label/div')

// Consent toggle
TestObject consentToggle = new TestObject('consentToggle')
consentToggle.addProperty("xpath", ConditionType.EQUALS, '//*[@id="standingorderswitch_confirm"]')

// Update Tenancy button (from Object Repository)
TestObject updateTenancyButton = findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt')

TestObject holdingDepositLabel = new TestObject('holdingDepositLabel')
holdingDepositLabel.addProperty("xpath", ConditionType.EQUALS, '//*[@id="checkstabletable"]/tbody/tr[1]/td[4]/p')

// Holding Deposit status in UI
TestObject holdingDepositStatus = new TestObject('holdingDepositStatus')
holdingDepositStatus.addProperty("xpath", ConditionType.EQUALS, '//*[@id="checkstabletable"]/tbody/tr[2]/td[4]')


WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Onboarding - Edit Tenancy bt'))

WebUI.delay(2)

// STEP 1: Check current state of Holding Deposit toggle
String toggleClass = WebUI.getAttribute(holdingDepositToggle, "class")
boolean isToggleOn = toggleClass.contains("switchOn")

println("Current Holding Deposit state: " + (isToggleOn ? "ON" : "OFF"))

// STEP 2: Toggle it
WebUI.click(holdingDepositToggle)

// STEP 3: Consent + Save
WebUI.click(consentToggle)
WebUI.click(updateTenancyButton)

WebUI.delay(2)

// STEP 4: Verify new state in UI
WebUI.delay(2)
String actualStatus = WebUI.getText(holdingDepositStatus).trim()

if (isToggleOn) {
    // Was ON → toggled OFF → expect N/A
    WebUI.verifyMatch(actualStatus, "N/A", false)
    println("✅ Verified: Holding Deposit toggled from ON → OFF, UI displays 'N/A'")
} else {
    // Was OFF → toggled ON → expect "-"
    WebUI.verifyMatch(actualStatus, "-", false)
    println("✅ Verified: Holding Deposit toggled from OFF → ON, UI displays '-'")
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

