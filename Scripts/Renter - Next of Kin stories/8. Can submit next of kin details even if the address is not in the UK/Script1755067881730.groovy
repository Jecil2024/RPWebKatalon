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

WebUI.openBrowser('')

'Navigate homepage'
WebUI.navigateToUrl('https://covered-hill-4728.herokuapp.com/')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

'Click login button'
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))

WebUI.delay(2)

'Input email address'
WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Email address'), 
    'lojavim596@coursora.com')

WebUI.delay(5)

'Input password'
WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Password'), 
    'test1234')

WebUI.delay(2)

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Renter login bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Identity Check bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Identity check - Continue bt'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - First Name field'), 
    'Jecil')

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Last Name field'), 
    'Nextofkin')

WebUI.selectOptionByIndex(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Select relationship dropdown'), 
    '3')

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Email address field'), 
    'nextofkinkat@rentprofile.co')

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Mobile number'), 
    '07365459652')

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Home address is not in the UK bt'))

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Home address line 1 field'), 
    '123 Main Street, Toronto')

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Town-City field'), 
    'Toronto')

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Post code field'), 
    'ON M5J 2N1')

WebUI.selectOptionByLabel(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Country dropdown'), 
    'Canada', false)

WebUI.delay(2)

'Logout'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Continue bt'))

WebUI.verifyTextPresent('UK Bank Account verification', false)

'Logout'
WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

