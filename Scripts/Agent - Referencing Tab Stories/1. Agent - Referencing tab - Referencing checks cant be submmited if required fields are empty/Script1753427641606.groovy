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

'Individual Referencing'
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Referencing bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Add referencing bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Submit Request bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Please select a branch', false)

WebUI.delay(2)

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Select Branch dropdown'), 
    1)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Submit Request bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Address cannot be empty', false)

WebUI.delay(2)

WebUI.verifyTextPresent('Rent value cannot be empty', false)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Address textfield'), 
    'London')

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Selected address - London, Po Box 81703 London, N4 9PT'), 
    0)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Selected address - London, Po Box 81703 London, N4 9PT'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Submit Request bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Rent value cannot be empty', false)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Rent value textfield'), 
    '1000')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Submit Request bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Renter\'s name must be at least 2 characters', false)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Renter name textfield'), 
    'Referencing Katalon')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Submit Request bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Enter the renter\'s email or mobile number', false)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Renter Email textfield'), 
    'bdfhf4655!!<<')

WebUI.delay(2)

WebUI.verifyTextPresent('Enter the renter\'s email or mobile number', false)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Submit Request bt'))

WebUI.verifyTextPresent('Invalid email address format', false)

'Company as a Tenant'
WebUI.refresh()

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Add referencing bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Company as a Tenant bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Company as Tenant - Submit Request bt'))

WebUI.verifyTextPresent('Please select a branch', false)

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Select Branch dropdown'), 
    1)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Company as Tenant - Submit Request bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Address cannot be empty', false)

WebUI.delay(2)

WebUI.verifyTextPresent('Rent value cannot be empty', false)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Address textfield'), 
    'London')

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Selected address - London, Po Box 81703 London, N4 9PT'), 
    0)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Selected address - London, Po Box 81703 London, N4 9PT'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Company as Tenant - Submit Request bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Rent value cannot be empty', false)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Rent value textfield'), 
    '1000')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Company as Tenant - Submit Request bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Enter company\'s name', false)

WebUI.verifyTextPresent('Enter contact\'s name', false)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Company name'), 
    'Katalon Ref Company')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Company as Tenant - Submit Request bt'))

WebUI.verifyTextPresent('Enter contact\'s name', false)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Contact name'), 
    'Jecil Katalon')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Company as Tenant - Submit Request bt'))

WebUI.verifyTextPresent('Enter the contact\'s email or mobile number', false)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Contact email'), 
    'gsgdfg126323!!')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing tab - Company as Tenant - Submit Request bt'))

WebUI.verifyTextPresent('Invalid email address format', false)

WebUI.delay(2)

'Logout'
WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.closeBrowser()

