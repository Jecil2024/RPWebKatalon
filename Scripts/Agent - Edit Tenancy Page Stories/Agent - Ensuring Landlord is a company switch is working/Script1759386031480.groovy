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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

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

// Consent toggle
//TestObject consentToggle = new TestObject('consentToggle')
//consentToggle.addProperty("xpath", ConditionType.EQUALS, '//*[@id="standingorderswitch_confirm"]')

// Update Tenancy button (from Object Repository)
//TestObject updateTenancyButton = findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt')

// --- Test Objects by XPath ---
TestObject landlordSwitch = new TestObject('landlordSwitch')
landlordSwitch.addProperty('xpath', ConditionType.EQUALS, '//*[@id="primary_contact_landlord_switch"]')

// Landlord fields
TestObject landlordName = new TestObject('landlordName')
landlordName.addProperty('xpath', ConditionType.EQUALS, '//*[@id="landlord_name"]')

TestObject landlordEmail = new TestObject('landlordEmail')
landlordEmail.addProperty('xpath', ConditionType.EQUALS, '//*[@id="landlord_email"]')

TestObject landlordHome = new TestObject('landlordHome')
landlordHome.addProperty('xpath', ConditionType.EQUALS, '//*[@id="landlord_home_address"]')

// Company fields
TestObject companyName = new TestObject('companyName')
companyName.addProperty('xpath', ConditionType.EQUALS, '//*[@id="landlord_name"]')

TestObject contactPerson = new TestObject('contactPerson')
contactPerson.addProperty('xpath', ConditionType.EQUALS, '//*[@id="primary_contact_landlord_name"]')

TestObject companyEmail = new TestObject('companyEmail')
companyEmail.addProperty('xpath', ConditionType.EQUALS, '//*[@id="landlord_email"]')

TestObject companyAddress = new TestObject('companyAddress')
companyAddress.addProperty('xpath', ConditionType.EQUALS, '//*[@id="landlord_home_address"]')


WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Onboarding - Edit Tenancy bt'))

WebUI.delay(2)

// --- Scroll to switch before checking state ---
WebUI.scrollToElement(landlordSwitch, 10)

// --- Check current switch state ---
String switchClass = WebUI.getAttribute(landlordSwitch, 'class')

// ============ IF SWITCH IS OFF ============
if (!switchClass.contains('switchOn')) {
    WebUI.comment("Switch is OFF → Validate Landlord fields")

    WebUI.verifyTextPresent('LANDLORD NAME', false)
    WebUI.verifyElementPresent(landlordName, 10)

    WebUI.verifyTextPresent('LANDLORD EMAIL', false)
    WebUI.verifyElementPresent(landlordEmail, 10)

    WebUI.verifyTextPresent('LANDLORD HOME', false)
    WebUI.verifyElementPresent(landlordHome, 10)

    // Scroll + Turn switch ON
    WebUI.scrollToElement(landlordSwitch, 10)
    WebUI.click(landlordSwitch)
    WebUI.delay(2)

    WebUI.comment("Now Switch is ON → Validate Company fields")

    WebUI.verifyTextPresent('COMPANY NAME', false)
    WebUI.verifyElementPresent(companyName, 10)

    WebUI.verifyTextPresent("CONTACT PERSON'S NAME", false)
    WebUI.verifyElementPresent(contactPerson, 10)

    WebUI.verifyTextPresent('COMPANY EMAIL', false)
    WebUI.verifyElementPresent(companyEmail, 10)

    WebUI.verifyTextPresent('COMPANY ADDRESS', false)
    WebUI.verifyElementPresent(companyAddress, 10)

} else {
    // ============ IF SWITCH IS ON ============
    WebUI.comment("Switch is ON → Validate Company fields")

    WebUI.verifyTextPresent('COMPANY NAME', false)
    WebUI.verifyElementPresent(companyName, 10)

    WebUI.verifyTextPresent("CONTACT PERSON'S NAME", false)
    WebUI.verifyElementPresent(contactPerson, 10)

    WebUI.verifyTextPresent('COMPANY EMAIL', false)
    WebUI.verifyElementPresent(companyEmail, 10)

    WebUI.verifyTextPresent('COMPANY ADDRESS', false)
    WebUI.verifyElementPresent(companyAddress, 10)

    // Scroll + Turn switch OFF
    WebUI.scrollToElement(landlordSwitch, 10)
    WebUI.click(landlordSwitch)
    WebUI.delay(2)

    WebUI.comment("Now Switch is OFF → Validate Landlord fields")

    WebUI.verifyTextPresent('LANDLORD NAME', false)
    WebUI.verifyElementPresent(landlordName, 10)

    WebUI.verifyTextPresent('LANDLORD EMAIL', false)
    WebUI.verifyElementPresent(landlordEmail, 10)

    WebUI.verifyTextPresent('LANDLORD HOME', false)
    WebUI.verifyElementPresent(landlordHome, 10)
}


// STEP 3: Consent + Save
//WebUI.click(consentToggle)
//WebUI.click(updateTenancyButton)

WebUI.delay(2)


// ============ LOGOUT ============
WebUI.refresh()

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

