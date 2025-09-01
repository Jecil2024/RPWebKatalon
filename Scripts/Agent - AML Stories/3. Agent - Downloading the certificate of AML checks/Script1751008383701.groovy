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
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

// ============ CONFIGURE CHROME WITH DOWNLOAD DIRECTORY ============
String downloadPath = 'C:\\Users\\jecil\\Downloads'

HashMap<String, Object> chromePrefs = new HashMap()

chromePrefs.put('download.default_directory', downloadPath)

chromePrefs.put('download.prompt_for_download', false)

chromePrefs.put('profile.default_content_settings.popups', 0)

ChromeOptions options = new ChromeOptions()

options.setExperimentalOption('prefs', chromePrefs)

WebDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

// ============ START TEST CASE ============
WebUI.openBrowser('')

'Navigate homepage'
WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

// Login
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Homepage Login - Agent login bt'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'stagingtestingagency@rentprofile.co')

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'test442s')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

// Navigate to AML section
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/AML - AML tab bt'))

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/AML tab - View all AML checks bt'), 
    2)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/AML tab - View all AML checks bt'))

WebUI.delay(2)

WebUI.switchToWindowIndex(1)

WebUI.delay(2)

// Verify AML result
WebUI.verifyElementPresent(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/AML Reporting - AML text'), 
    0)

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML (1)/AML Reporting - Search bar'), 
    'Cthy')

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML (1)/AML Reporting - Search icon'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/AML Reporting - Pass status bt'))

WebUI.verifyTextPresent('Tenant AML: Cthy Test', false)

WebUI.verifyTextPresent('AML Result:', false)

WebUI.verifyTextPresent('Pass', false)

// ============ CLEAN OLD FILES BEFORE DOWNLOAD ============
String expectedPrefix = 'applicant_aml_check_report_'

String expectedExtension = '.pdf'

File downloadDir = new File(downloadPath)

File[] oldFiles = downloadDir.listFiles().findAll({ 
        it.name.startsWith(expectedPrefix) && it.name.endsWith(expectedExtension)
    })

oldFiles.each({ 
        it.delete( // clean old matching files
            )
    })

// ============ TRIGGER CERTIFICATE DOWNLOAD ============
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/AML - Side panel - Download Certificate bt'))

WebUI.delay(5 // wait for download to complete
    )

// ============ VERIFY FILE IS DOWNLOADED ============
File[] matchingFiles = downloadDir.listFiles().findAll({ 
        it.name.startsWith(expectedPrefix) && it.name.endsWith(expectedExtension)
    })

if (matchingFiles.size() > 0) {
    println("✅ File downloaded successfully: $matchingFiles[0].name")
} else {
    KeywordUtil.markFailed('❌ No matching certificate file found in download directory.')
}

// ============ LOGOUT ============
WebUI.refresh()

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

