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

WebUI.openBrowser('')

'Navigate homepage'
WebUI.navigateToUrl('https://covered-hill-4728.herokuapp.com/')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

'Click login button'
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_bt Guarantor login page'))

WebUI.delay(2)

'Incorrect email address\r\n'
WebUI.setText(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor email'), 
    'xxtest!!yoxav30052@gitated.com')

WebUI.delay(2)

'Correct password'
WebUI.setText(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor password'), 
    'test1234')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor login button'))

WebUI.delay(2)

WebUI.verifyTextPresent('Invalid Email or password.', false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_bt Guarantor login page'))

WebUI.delay(2)

'correct email address\r\n'
WebUI.setText(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor email'), 
    'yoxav30052@gitated.com')

WebUI.delay(2)

'Incorrect password'
WebUI.setText(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor password'), 
    'test1234xxinco**')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor login button'))

WebUI.delay(2)

WebUI.verifyTextPresent('Invalid Email or password.', false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_bt Guarantor login page'))

WebUI.delay(2)

'incorrect email address\r\n'
WebUI.setText(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor email'), 
    'xxtest!!yoxav30052@gitated.com')

WebUI.delay(2)

'Incorrect password'
WebUI.setText(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor password'), 
    'test1234xxinco**')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor login button'))

WebUI.delay(2)

WebUI.verifyTextPresent('Invalid Email or password.', false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_bt Guarantor login page'))

WebUI.delay(2)

'correct email address\r\n'
WebUI.setText(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor email'), 
    'yoxav30052@gitated.com')

WebUI.delay(2)

'correct password'
WebUI.setText(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor password'), 
    'test1234')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_guarantor login button'))

WebUI.delay(2)

WebUI.verifyTextPresent('Welcome', false)

WebUI.click(findTestObject('Jecil/Guarantor/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/a_guarantor Account'))

WebUI.delay(2)

WebUI.verifyTextPresent('Settings', false)

WebUI.delay(2)

'Logout'
WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

