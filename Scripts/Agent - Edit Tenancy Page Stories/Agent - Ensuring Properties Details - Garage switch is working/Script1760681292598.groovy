import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
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
TestObject garageSwitch = new TestObject("garageSwitch")
garageSwitch.addProperty("xpath", ConditionType.EQUALS, "//*[@id='requeststab']/div/table[3]/tbody/tr[3]/td[2]/label/div")

TestObject propertyPanel = new TestObject("propertyPanel")
propertyPanel.addProperty("xpath", ConditionType.EQUALS, "//*[@id='requeststab']/div/table[3]")

TestObject consentToggle = new TestObject("consentToggle")
consentToggle.addProperty("xpath", ConditionType.EQUALS, "//*[@id='standingorderswitch_confirm']")

TestObject updateTenancyBtn = findTestObject("Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt")

TestObject viewDraftBtn = new TestObject("viewDraftBtn")
viewDraftBtn.addProperty("xpath", ConditionType.EQUALS, "//*[@id='checkstable']/div[2]/p[1]/a/span")

// --------------------- SCROLL PANEL TO FIND GARAGE SWITCH ---------------------
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor js = (JavascriptExecutor) driver
WebElement panel = driver.findElement(By.xpath("//*[@id='requeststab']/div/table[3]"))

boolean found = false
for (int i = 0; i < 15; i++) {
	try {
		WebElement toggleElement = driver.findElement(By.xpath("//*[@id='requeststab']/div/table[3]/tbody/tr[3]/td[2]/label/div"))
		if (toggleElement.isDisplayed()) {
			found = true
			break
		}
	} catch (Exception e) {
		// ignore, keep scrolling
	}
	js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 250;", panel)
	WebUI.delay(0.5)
}

if (!found) {
	KeywordUtil.markFailed("❌ Garage switch not visible after scrolling.")
	return
}

// --------------------- TOGGLE SWITCH ---------------------
WebUI.scrollToElement(garageSwitch, 5)
WebUI.delay(2)

WebElement switchElement = WebUI.findWebElement(garageSwitch)
boolean isSwitchOn = switchElement.getAttribute("class").contains("switchOn")

if (isSwitchOn) {
	WebUI.click(garageSwitch)
	WebUI.delay(1)
	switchElement = WebUI.findWebElement(garageSwitch)
	isSwitchOn = switchElement.getAttribute("class").contains("switchOn")
	KeywordUtil.logInfo("🔘 Garage switch was ON — now turned OFF. Current class: " + switchElement.getAttribute("class"))
} else {
	WebUI.click(garageSwitch)
	WebUI.delay(1)
	switchElement = WebUI.findWebElement(garageSwitch)
	isSwitchOn = switchElement.getAttribute("class").contains("switchOn")
	KeywordUtil.logInfo("🔘 Garage switch was OFF — now turned ON. Current class: " + switchElement.getAttribute("class"))
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

// ✅ Correct Logic: ON = expect "Garage" present; OFF = expect "Garage" absent
boolean hasGarageText = WebUI.verifyTextPresent('Garage', false, FailureHandling.OPTIONAL)

if (isSwitchOn) {
	if (hasGarageText) {
		KeywordUtil.markPassed("✅ PASS: Garage toggle is ON and 'Garage' text is visible in TA.")
	} else {
		KeywordUtil.markFailed("❌ FAIL: Garage toggle is ON but 'Garage' text NOT found in TA.")
	}
} else {
	if (!hasGarageText) {
		KeywordUtil.markPassed("✅ PASS: Garage toggle is OFF and 'Garage' text correctly NOT found in TA.")
	} else {
		KeywordUtil.markFailed("❌ FAIL: Garage toggle is OFF but 'Garage' text FOUND in TA.")
	}
}

// --------------------- CLEANUP ---------------------
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))
WebUI.delay(1)
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))
WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)
WebUI.closeBrowser()
KeywordUtil.logInfo("🎯 Test completed successfully.")
