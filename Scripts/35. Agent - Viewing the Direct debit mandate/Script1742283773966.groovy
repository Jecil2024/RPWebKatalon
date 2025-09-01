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

WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), '05260')

WebUI.delay(2)

'Click search icon'
WebUI.click(findTestObject('Jecil/Agent/Properties-Onboarding - Search icon'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/a_27FD2_Tenancy'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Direct debit - View mandate bt'))

WebUI.delay(2)

WebUI.switchToWindowUrl('https://rentprofiletest.s3-eu-west-1.amazonaws.com/tenancy/0526069d272bf660379afdcd9b71f91e9f2511e98f085abd375c9e0f03b2/0526069d272bf660379afdcd9b71f91e9f2511e98f085abd375c9e0f03b2_dd_ref.jpg')

WebUI.delay(2)

WebUI.switchToWindowUrl('https://covered-hill-4728.herokuapp.com/agent/in_tenancy?tenancyid=0526069d272bf660379afdcd9b71f91e9f2511e98f085abd375c9e0f03b2')

WebUI.delay(2)

WebUI.delay(2)

'Logout'
WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.closeBrowser()

