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
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'hotblackstaging@rentprofile.co')

WebUI.delay(2)

'Input password'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72')

WebUI.delay(2)

'Click login button in agent page'
WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), 'test katalon')

WebUI.sendKeys(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), Keys.chord(Keys.ENTER))

WebUI.verifyTextPresent('LANDLORD', false)

WebUI.verifyTextPresent('test katalon', false)

WebUI.clearText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), '20377')

WebUI.sendKeys(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), Keys.chord(Keys.ENTER))

WebUI.verifyTextPresent('UTR', false)

WebUI.verifyTextPresent('20377', false)

WebUI.clearText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), 'ExclusiveFor Katalon -- Clarion Housing Group, Greater London House, Hampstead Road, LONDON, NW1 7QX')

WebUI.sendKeys(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), Keys.chord(Keys.ENTER))

WebUI.verifyTextPresent('ADDRESS', false)

WebUI.verifyTextPresent('ExclusiveFor Katalon', false)

WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

