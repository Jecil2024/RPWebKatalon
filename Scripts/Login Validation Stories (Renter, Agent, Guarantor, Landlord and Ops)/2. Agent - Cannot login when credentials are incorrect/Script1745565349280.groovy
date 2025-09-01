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

'Click login button'
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Homepage Login - Agent login bt'))

WebUI.delay(2)

'Incorrect email address'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'xxtesthotblackstaging@rentprofile.co')

WebUI.delay(2)

'Correct password'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Agent login', false)

WebUI.delay(2)

'Correct email address'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'hotblackstaging@rentprofile.co')

WebUI.delay(2)

'Incorrect password'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72test22!!')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Agent login', false)

WebUI.delay(2)

'Incorrect email address'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'xxtesthotblackstaging@rentprofile.co')

WebUI.delay(2)

'Incorrect password'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72test22!!')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Agent login', false)

WebUI.delay(2)

'Correct email address'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'hotblackstaging@rentprofile.co')

WebUI.delay(2)

'Correct password'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72')

WebUI.delay(2)

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Topbar - Account bt'))

WebUI.verifyTextPresent('Logged in as', false)

WebUI.delay(2)

WebUI.verifyTextPresent('hotblackstaging@rentprofile.co', false)

WebUI.delay(2)

'Logout'
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Topbar - Logout'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

