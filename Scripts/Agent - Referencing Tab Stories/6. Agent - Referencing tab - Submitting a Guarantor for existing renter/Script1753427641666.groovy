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
import myKeywords.RandomEmail as RandomEmail
import com.kms.katalon.core.testobject.ConditionType as ConditionType

// Open browser and go to site
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

// Login steps
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Homepage Login - Agent login bt'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'hotblackstaging@rentprofile.co')

WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72' // Changed password for safety
    )

WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

// Navigate to Referencing tab
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Referencing tab bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Add referencing bt'))

// Fill referencing form
WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Select Branch dropdown'), 
    1)

WebUI.delay(2)

// Type address
WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Address textfield'), 
    '33 Madres')

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Address textfield'), 
    Keys.chord(Keys.SPACE))

WebUI.delay(2)

// Simulate typing using JavaScript (to trigger suggestion dropdown)
WebUI.executeJavaScript('document.querySelector(\'input[placeholder*=\\\'Start typing\\\']\').value = \'33 Madres\';', null)

WebUI.executeJavaScript('document.querySelector(\'input[placeholder*=\\\'Start typing\\\']\').dispatchEvent(new Event(\'input\', { bubbles: true }))', 
    null)

WebUI.delay(2)

// Click the suggestion
TestObject suggestion = new TestObject('dynamic_suggestion')

suggestion.addProperty('xpath', ConditionType.EQUALS, '//div[contains(text(), \'33 Madresfield Village\')]')

WebUI.waitForElementVisible(suggestion, 10)

WebUI.click(suggestion)

WebUI.delay(2)

// Enter rent
WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Rent value textfield'), 
    '900')

WebUI.delay(2)

// Select guarantor for existing renter
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Guarantor for existing renter'), 
    FailureHandling.STOP_ON_FAILURE)

// Enter guarantor details
WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Guarantor exiting renter - Gua Name'), 
    'Katalon Guarantor')

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Guarantor exiting renter - Gua Email'), 
    'katalonguaran@rentprofile.co')

WebUI.delay(2)

// Submit request
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Guarantor exiting renter - Submit Request'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert()

WebUI.delay(2)

// Verify confirmation
WebUI.verifyTextPresent('Thanks', false)

WebUI.verifyTextPresent('Your request has been sent', false)

// Back to dashboard
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Back to Agent Dashboard bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Referencing tab bt'))

WebUI.verifyTextPresent('Katalon Guarantor', false)

WebUI.delay(2)

// Logout
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

