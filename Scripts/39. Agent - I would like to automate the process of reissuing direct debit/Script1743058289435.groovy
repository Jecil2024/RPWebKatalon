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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver

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

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Direct debit - Reissue mandate bt'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Direct debit - reissue field'), 
    '1234abcd')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Direct debit - Reissue mandate bt1'))

WebUI.delay(2)

'Logout'
WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.closeBrowser()

WebUI.delay(2)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://covered-hill-4728.herokuapp.com/')

WebUI.maximizeWindow()

WebUI.delay(5)

WebUI.waitForPageLoad(5)

'Click login button'
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))

WebUI.delay(5)

WebUI.waitForPageLoad(5)

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Email address'), 
    'memonow319@oziere.com')

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Password'), 
    'test1234')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Renter login bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Direct Debit - Start bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Direct debit - Continue bt'))

WebUI.delay(2)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Direct debit - Please sign the direct debit instruction below bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Direct debit - TA Type signature switch'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Direct debit - TA type signature field'), 
    'Renter K')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Direct debit - TA Submit bt'))

WebUI.waitForPageLoad(30)

WebUI.delay(10)

WebUI.closeBrowser()

WebUI.delay(2)

not_run: WebUI.openBrowser('')

not_run: WebUI.navigateToUrl('https://accounts.google.com/v3/signin/identifier?ifkv=AXH0vVvFscz9sQwwKFCLtyLNtpKQFmg8KTu_01lDhWysCMnw33a0y0bt2c2fkopsd5SFklowBdP4&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S154646681%3A1742459455022971')

not_run: WebUI.maximizeWindow()

not_run: WebUI.setText(findTestObject('Jecil/Gmail/Page_Gmail/Gmail - Email txtfield'), 'jecilmae@rentprofile.co')

not_run: WebUI.click(findTestObject('Jecil/Gmail/Page_Gmail/Gmail - Email Next bt'))

not_run: WebUI.delay(2)

not_run: WebUI.setEncryptedText(findTestObject('Jecil/Gmail/Page_Gmail/Gmail - Password txtfield'), 'zlnfLCq0d5wyoUK3rpMILoO+HA35zbDb')

not_run: WebUI.delay(2)

not_run: WebUI.click(findTestObject('Jecil/Gmail/Page_Gmail/Gmail - Password Next bt'))

not_run: WebUI.delay(2)

not_run: WebUI.setText(findTestObject('Jecil/Gmail/Page_Inbox (1,138) - jecilmaerentprofile.co - RentProfile Mail/Gmail - Search email'), 
    '5 Clevelands Avenue')

not_run: WebUI.sendKeys(findTestObject('Jecil/Gmail/Page_Inbox (1,138) - jecilmaerentprofile.co - RentProfile Mail/Gmail - Search email'), 
    Keys.chord(Keys.ENTER))

not_run: WebUI.delay(2)

not_run: TestObject firstEmail = new TestObject()

not_run: firstEmail.addProperty('xpath', ConditionType.EQUALS, '//*[@id=\':lz\']')

not_run: WebUI.waitForElementPresent(firstEmail, 10)

not_run: WebUI.waitForElementClickable(firstEmail, 10)

not_run: WebUI.click(firstEmail)

not_run: WebUI.delay(5)

not_run: TestObject signButton = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//a[contains(text(), \'Sign Car parking Agreement\')]')

not_run: WebUI.click(signButton)

not_run: WebUI.delay(15)

not_run: WebUI.switchToWindowIndex(1)

not_run: WebUI.delay(5)

not_run: WebUI.scrollToPosition(0, 7500)

not_run: WebUI.delay(10)

not_run: WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/TA - Type signature switch bt'))

not_run: WebUI.delay(2)

not_run: WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/TA - Sign agreement field'), 
    'Agent K')

not_run: WebUI.delay(2)

not_run: WebUI.scrollToPosition(5000, 8000)

not_run: WebUI.delay(2)

not_run: WebUI.waitForElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Agent TA sign - Submit bt'), 
    30)

not_run: WebUI.delay(10)

not_run: WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Agent TA sign - Submit bt'))

not_run: WebUI.waitForPageLoad(30)

not_run: WebUI.delay(15)

not_run: WebUI.closeBrowser()

not_run: WebUI.delay(2)

WebUI.openBrowser('')

'Navigate homepage'
WebUI.navigateToUrl('https://covered-hill-4728.herokuapp.com/')

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

WebUI.refresh()

WebUI.verifyTextPresent('Reissue mandate', false)

WebUI.delay(2)

'Logout'
WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.closeBrowser()

WebUI.delay(2)

