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
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'stagingtestingagency@rentprofile.co')

WebUI.delay(2)

'Input password'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'test442s')

WebUI.delay(2)

'Click login button in agent page'
WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), '7F28D')

WebUI.delay(2)

'Click search icon'
WebUI.click(findTestObject('Jecil/Agent/Properties-Onboarding - Search icon'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/New Tenancy column-Start bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Side panel - Create Listing bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Listing form - Create Listing bt'))

WebUI.verifyTextPresent('Please enter rental amount', false)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing - Rental amount textfield'), 
    '1000')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Listing form - Create Listing bt'))

WebUI.verifyTextPresent('Please enter date', false)

WebUI.delay(10)

not_run: WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing -Available to rent from textfield'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing - Available to rent date (3)'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Listing form - Create Listing bt'))

WebUI.verifyTextPresent('Please select property type', false)

WebUI.delay(2)

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing - Property type dropdown'), 
    '1')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Listing form - Create Listing bt'))

WebUI.verifyTextPresent('Please select property of bedrooms', false)

WebUI.delay(2)

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing - Number of Bedrooms dropdown'), 
    '1')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Listing form - Create Listing bt'))

WebUI.verifyTextPresent('Please select property of bathrooms', false)

WebUI.delay(2)

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing - Number of Bathrooms dropdown'), 
    '1')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Listing form - Create Listing bt'))

WebUI.verifyTextPresent('Please select furnish type', false)

WebUI.delay(2)

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing - Furnish Type dropdown'), 
    '1')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Listing form - Create Listing bt'))

WebUI.verifyTextPresent('Please enter current/potential EPC rating', false)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing - Energy Cert - Current textfield'), 
    '80')

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing - Energy Cert - Potential textfield'), 
    '80')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Listing form - Create Listing bt'))

WebUI.verifyTextPresent('Please select council tax band', false)

WebUI.delay(2)

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing - Council tax band dropdown'), 
    '3')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Listing form - Create Listing bt'))

WebUI.verifyTextPresent('Please enter property summary', false)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing - Property summary textfield'), 
    'Katalon property summary')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Listing form - Create Listing bt'))

WebUI.verifyTextPresent('Please enter property description', false)

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Listing - Property description textfield'), 
    'Katalon property description')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

'Logout'
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.closeBrowser()

