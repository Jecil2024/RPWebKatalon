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

'Correct email'
WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Email field'), 'jecilmae@rentprofile.co')

'Incorrect password'
WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Password field'), 'testwrongpassword')

WebUI.click(findTestObject('Jecil/Admin/Page_RentProfile/Login bt'))

WebUI.verifyTextPresent('Invalid Email or password.', false)

WebUI.delay(2)

'Incorrect email'
WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Email field'), 'testxxjecilmae@rentprofile.co')

'Correct password'
WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Password field'), 'CegvqGRIwL6GT!mNI09M67o4@EBGKaV5rr')

WebUI.click(findTestObject('Jecil/Admin/Page_RentProfile/Login bt'))

WebUI.verifyTextPresent('Invalid Email or password.', false)

WebUI.delay(2)

'Incorrect email'
WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Email field'), 'testxxjecilmae@rentprofile.co')

'Incorrect password'
WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Password field'), 'testwrongpassword')

WebUI.click(findTestObject('Jecil/Admin/Page_RentProfile/Login bt'))

WebUI.verifyTextPresent('Invalid Email or password.', false)

WebUI.delay(2)

'correct email'
WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Email field'), 'jecilmae@rentprofile.co')

'correct password'
WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Password field'), 'CegvqGRIwL6GT!mNI09M67o4@EBGKaV5rr')

WebUI.click(findTestObject('Jecil/Admin/Page_RentProfile/Login bt'))

WebUI.verifyTextPresent('Signed in successfully.', false)

WebUI.closeBrowser()

