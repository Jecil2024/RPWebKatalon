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
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'dandaraliving@rentprofile.co')

WebUI.delay(2)

'Input password'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'rpdandara09')

WebUI.delay(2)

'Click login button in agent page'
WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), '97B9F')

WebUI.sendKeys(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Onboarding - New Tenancy Column - Add Tenancy bt'))

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Landlord (Dandara agent) dropdown'), 
    0)

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Landlord (Dandara agent) dropdown'), 
    'Aberdeen - Aberdeen Forbes Place Arosa Living Limited', false)

WebUI.delay(2)

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Flatfair logo'))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Landlord (Dandara agent) dropdown'), 
    'Aberdeen - Dandara Living Triple Kirks LP acting by its general partner Dandara Living Triple Kirks GP Limited', false)

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Flatfair logo'))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Landlord (Dandara agent) dropdown'), 
    'Birmingham - U & A - Unity & Armouries BG Nom1 Limited and BG Nom2 Limited', false)

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Flatfair logo'))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Landlord (Dandara agent) dropdown'), 
    'Glasgow - Granary Quay Unit Trust acting by its trustees Granary Quay (IOM) Trustee Limited', false)

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Flatfair logo'))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Landlord (Dandara agent) dropdown'), 
    'Leeds Calvert & Daniels CURA Living GP Limited as a general partner of Leeds Calvert & Daniels CURA Living LP', false)

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Flatfair logo'))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Landlord (Dandara agent) dropdown'), 
    'Manchester Alcock & Bradshaw CURA Living GP Limited on behalf of Manchester Alcock & Bradshaw CURA Living LP', false)

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Flatfair logo'))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Landlord (Dandara agent) dropdown'), 
    'Manchester Chapman AROSA Living GP Limited on behalf of Manchester Chapman AROSA Living LP', false)

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Flatfair logo'))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Landlord (Dandara agent) dropdown'), 
    'Manchester Doodson AROSA Living GP Limited on behalf of Manchester Doodson AROSA Living LP', false)

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create Tenancy - Flatfair logo'))

// ============ LOGOUT ============
WebUI.refresh()

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

