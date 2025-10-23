import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory

// --------------------- SETUP ---------------------
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseURL)
WebUI.maximizeWindow()
WebUI.waitForPageLoad(10)

// --------------------- LOGIN ---------------------
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))
WebUI.delay(2)
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Homepage Login - Agent login bt'))
WebUI.delay(2)
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'hotblackstaging@rentprofile.co')
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72')
WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))
WebUI.delay(5)

// --------------------- SEARCH TENANCY ---------------------
WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), '79AFF')
WebUI.sendKeys(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), Keys.chord(Keys.ENTER))
WebUI.delay(5)
WebUI.click(findTestObject('Jecil/Agent/Onboarding - New Tenancy Column - Agency Terms bt'))
WebUI.delay(3)
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Onboarding - Edit Tenancy bt'))
WebUI.delay(5)

// --------------------- DEFINE ELEMENTS ---------------------
TestObject storageSwitch = new TestObject("storageSwitch")
storageSwitch.addProperty("xpath", ConditionType.EQUALS, "//*[@id='requeststab']/div/table[3]/tbody/tr[3]/td[3]/label/div")

TestObject propertyPanel = new TestObject("propertyPanel")
propertyPanel.addProperty("xpath", ConditionType.EQUALS, "//*[@id='requeststab']/div/table[3]")

TestObject consentToggle = new TestObject("consentToggle")
consentToggle.addProperty("xpath", ConditionType.EQUALS, "//*[@id='standingorderswitch_confirm']")

TestObject updateTenancyBtn = findTestObject("Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt")

TestObject viewDraftBtn = new TestObject("viewDraftBtn")
viewDraftBtn.addProperty("xpath", ConditionType.EQUALS, "//*[@id='checkstable']/div[2]/p[1]/a/span")

// --------------------- SCROLL PANEL TO FIND STORAGE SWITCH ---------------------
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor js = (JavascriptExecutor) driver
WebElement panel = driver.findElement(By.xpath("//*[@id='requeststab']/div/table[3]"))

boolean found = false
for (int i = 0; i < 15; i++) {
	try {
		WebElement toggleElement = driver.findElement(By.xpath("//*[@id='requeststab']/div/table[3]/tbody/tr[3]/td[3]/label/div"))
		if (toggleElement.isDisplayed()) {
			found = true
			break
		}
	} catch (Exception e) {
		// ignore and continue scrolling
	}
	js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 250;", panel)
	WebUI.delay(0.5)
}

if (!found) {
	KeywordUtil.markFailed("❌ Storage Space switch not visible after scrolling.")
	return
}

// --------------------- TOGGLE SWITCH ---------------------
WebUI.scrollToElement(storageSwitch, 5)
WebUI.delay(2)

WebElement switchElement = WebUI.findWebElement(storageSwitch)
boolean isSwitchOn = switchElement.getAttribute("class").contains("switchOn")

if (!isSwitchOn) {
	WebUI.click(storageSwitch)
	KeywordUtil.logInfo("🔘 Storage Space switch was OFF — turned ON now.")
	isSwitchOn = true
} else {
	WebUI.click(storageSwitch)
	KeywordUtil.logInfo("🔘 Storage Space switch was ON — turned OFF now.")
	isSwitchOn = false
}

WebUI.delay(2)
WebUI.click(consentToggle)
WebUI.click(updateTenancyBtn)
WebUI.delay(5)

// --------------------- VERIFY TENANCY AGREEMENT ---------------------
WebUI.scrollToElement(viewDraftBtn, 5)
WebUI.click(viewDraftBtn)
WebUI.delay(5)

WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(10)
WebUI.delay(3)

// ✅ FIXED PART — use Selenium driver instead of WebUI.getPageSource()
driver = DriverFactory.getWebDriver()
String pageSource = driver.getPageSource()

// Case-insensitive text check
boolean hasStorageText = pageSource.toLowerCase().contains("storage space")

if (isSwitchOn) {
	if (hasStorageText) {
		KeywordUtil.markPassed("✅ PASS: Storage Space switch is ON and text found in TA.")
	} else {
		KeywordUtil.markFailed("❌ FAIL: Storage Space switch is ON but text NOT found in TA.")
	}
} else {
	if (!hasStorageText) {
		KeywordUtil.markPassed("✅ PASS: Storage Space switch is OFF and text correctly not found in TA.")
	} else {
		KeywordUtil.markFailed("❌ FAIL: Storage Space switch is OFF but text FOUND in TA.")
	}
}

// --------------------- CLEANUP ---------------------
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))
WebUI.delay(1)
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))
WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)
WebUI.closeBrowser()
KeywordUtil.logInfo("🎯 Test completed successfully for Storage Space toggle.")
