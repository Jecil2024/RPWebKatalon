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

WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), '20377')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Properties-Onboarding - Search icon'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/a_09B7E new tenancy'))

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Proposed start date field'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/a_09B7E selected start date 20'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Rental amount field'), 
    '900')

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landlod name field'), 
    2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landlod name field'), 
    'katalon testing')

WebUI.delay(2)

def invalidEmail = new RandomEmail().generateInvalidEmail()

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landlord email field'), 
    invalidEmail)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landlords home is not in the UK bt'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landlord home - Line 1 field'), 
    '1 Glen William Road')

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landord Home - Town_City field'), 
    'Queensland')

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landlord Home - Postcode'), 
    ' 4871')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landlord Home - Country dropdown'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landlord Home - Country dropdown'), 
    '14', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_09B7E_renter name'), 
    0)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_09B7E_renter name'), 
    'automate katalon')

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_71369_renter email'), 
    'automate@rentprofile.co')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_09B7E toggle consent for tenant'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_09B7E bt_Create Tenancy'))

WebUI.delay(0)

WebUI.scrollToElement(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landlords home is not in the UK bt'), 
    2)

WebUI.verifyTextPresent('Invalid email address', false)

WebUI.delay(2)

WebUI.clearText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landlord email field'))

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Landlord email field'), 
    'katalon@rentprofile.co')

WebUI.scrollToElement(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_09B7E_renter email'), 
    0)

def invalidEmail2 = new RandomEmail().generateInvalidEmail()

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_09B7E_renter email'), 
    invalidEmail)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_09B7E bt_Create Tenancy'))

WebUI.verifyTextPresent('Invalid email address format', false)

WebUI.clearText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_71369_renter email'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_71369_renter email'), 
    'automate@rentprofile.co')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_09B7E toggle guarantor'))

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_09B7E guarantorname'), 
    'gua test')

def invalidEmail3 = new RandomEmail().generateInvalidEmail()

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_09B7E_guarantoremail'), 
    invalidEmail)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_09B7E bt_Create Tenancy'))

WebUI.verifyTextPresent('Invalid email address format', false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

