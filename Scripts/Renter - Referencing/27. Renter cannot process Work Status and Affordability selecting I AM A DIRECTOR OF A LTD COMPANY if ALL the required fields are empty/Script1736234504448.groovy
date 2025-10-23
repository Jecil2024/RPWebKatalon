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

'Input email address'
WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Email address'), 
    'fodewek472@confmin.com')

WebUI.delay(2)

'Input password'
WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Password'), 
    'test1234')

WebUI.delay(2)

'Click login button in renter page'
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Renter login bt'))

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/a_Work status Start bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am self employed bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am a Director of a LTD Company  bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_LTD Company Continue bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Please enter the accountant\'s name', false)

WebUI.verifyTextPresent('Please enter the company number', false)

WebUI.verifyTextPresent('Please enter the date of incorporation', false)

WebUI.verifyTextPresent('Please enter your job title', false)

WebUI.verifyTextPresent('Please enter your annual earnings', false)

WebUI.refresh()

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am self employed bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am a Director of a LTD Company  bt'))

'Company name field should be empty'
not_run: WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD Company name'), 
    'RP')

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD Company number'), 
    '123456789')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    Keys.chord(Keys.BACK_SPACE))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    '01012000')

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD job title'), 
    'QA')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/LTD Annual Earnings'))

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/LTD Annual Earnings'), 
    '60', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_LTD Company Continue bt'))

'Verify error alert present'
WebUI.verifyTextPresent('Please enter the accountant\'s name', false)

'Return to \'Your Employment\' page'
WebUI.refresh()

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am self employed bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am a Director of a LTD Company  bt'))

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD Company name'), 
    'RP')

'Company number field should be empty'
not_run: WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD Company number'), 
    '123456789')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    Keys.chord(Keys.BACK_SPACE))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    '01012000')

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD job title'), 
    'QA')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/LTD Annual Earnings'))

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/LTD Annual Earnings'), 
    '60', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_LTD Company Continue bt'))

'Verify error alert present'
WebUI.verifyTextPresent('Please enter the company number', false)

WebUI.delay(2)

'Return to \'Your Employment\' page'
WebUI.refresh()

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am self employed bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am a Director of a LTD Company  bt'))

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD Company name'), 
    'RP')

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD Company number'), 
    '123456789')

'Date of incorporation field should be empty'
not_run: WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'))

not_run: WebUI.delay(2)

not_run: WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    Keys.chord(Keys.CONTROL, 'a'))

not_run: WebUI.delay(2)

not_run: WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    Keys.chord(Keys.BACK_SPACE))

not_run: WebUI.delay(2)

not_run: WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    '01012000')

not_run: WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD job title'), 
    'QA')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/LTD Annual Earnings'))

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/LTD Annual Earnings'), 
    '60', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_LTD Company Continue bt'))

'Verify error alert present'
WebUI.verifyTextPresent('Please enter the date of incorporation', false)

WebUI.delay(2)

'Return to \'Your Employment\' page'
WebUI.refresh()

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am self employed bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am a Director of a LTD Company  bt'))

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD Company name'), 
    'RP')

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD Company number'), 
    '123456789')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    Keys.chord(Keys.BACK_SPACE))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    '01012000')

WebUI.delay(2)

'Job title field should be empty'
not_run: WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD job title'), 
    'QA')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/LTD Annual Earnings'))

WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/LTD Annual Earnings'), 
    '60', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_LTD Company Continue bt'))

'Verify error alert present'
WebUI.verifyTextPresent('Please enter your job title', false)

WebUI.delay(2)

'Return to \'Your Employment\' page'
WebUI.refresh()

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am self employed bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_I am a Director of a LTD Company  bt'))

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD Company name'), 
    'RP')

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD Company number'), 
    '123456789')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    Keys.chord(Keys.BACK_SPACE))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD date of incorporation'), 
    '01012000')

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/input_LTD job title'), 
    'QA')

'Annual earnings should be empty'
not_run: WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/LTD Annual Earnings'))

not_run: WebUI.selectOptionByIndex(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/LTD Annual Earnings'), 
    '60', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/div_LTD Company Continue bt'))

WebUI.verifyTextPresent('Please enter your annual earnings', false)

WebUI.delay(2)

'Logout'
WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

