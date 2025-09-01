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
WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

'Click login button'
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))

WebUI.delay(2)

'Input email address'
WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Email address'), 
    'tobeb71500@macho3.com')

WebUI.delay(2)

'Input password'
WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Password'), 
    'test1234')

WebUI.delay(2)

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Renter login bt'))

WebUI.delay(2)

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - Start bt'))

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - I have a UK Irish Passport bt'))

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - Continue bt'))

WebUI.verifyTextPresent('Please upload a document', false)

WebUI.back()

WebUI.delay(2)

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - I have Biometric Residence card or permit bt'))

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - Continue bt'))

WebUI.verifyTextPresent('Please insert a valid sharecode', false)

WebUI.back()

WebUI.delay(2)

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - I have Settled (or Pre-Settled) Status in the UK bt'))

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - Continue bt'))

WebUI.verifyTextPresent('Please insert a valid sharecode', false)

WebUI.back()

WebUI.delay(2)

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - I have a pending visa application with the UK government bt'))

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - Continue bt'))

WebUI.verifyTextPresent('Please insert a valid sharecode', false)

WebUI.back()

WebUI.delay(2)

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - I have Frontier Worker permit bt'))

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - Continue bt'))

WebUI.verifyTextPresent('Please insert a valid sharecode', false)

WebUI.back()

WebUI.delay(2)

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - I have other accepted documentation for Right to Rent bt'))

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - Submit Right to Rent bt'))

WebUI.verifyTextPresent('Please choose a document type', false)

WebUI.back()

WebUI.delay(2)

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - I have other accepted documentation for Right to Rent bt'))

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - I do not have one of these documents bt'))

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/R2R - Submit first Right to Rent document bt'))

WebUI.verifyTextPresent('Please choose a document type', false)

WebUI.back()

WebUI.delay(2)

'Logout'
WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

