import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.Keys
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
import java.util.Random as Random
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling

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
TestObject gardenSwitch = new com.kms.katalon.core.testobject.TestObject("gardenSwitch")
gardenSwitch.addProperty("xpath", ConditionType.EQUALS, "/html/body/div[3]/div[3]/div/div[1]/div[2]/div/table[3]/tbody/tr[2]/td[3]/label/div")

TestObject consentToggle = new com.kms.katalon.core.testobject.TestObject("consentToggle")
consentToggle.addProperty("xpath", ConditionType.EQUALS, "//*[@id='standingorderswitch_confirm']")

TestObject updateTenancyBtn = findTestObject("Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt")

TestObject viewDraftBtn = new com.kms.katalon.core.testobject.TestObject("viewDraftBtn")
viewDraftBtn.addProperty("xpath", ConditionType.EQUALS, "//*[@id='checkstable']/div[2]/p[1]/a/span")

TestObject gardenTextInTA = new com.kms.katalon.core.testobject.TestObject("gardenTextInTA")
gardenTextInTA.addProperty("xpath", ConditionType.EQUALS, "/html/body/div[3]/div[2]/div/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[11]/td[2]/p")

// --------------------- TOGGLE SWITCH ---------------------
WebUI.scrollToElement(gardenSwitch, 5)
WebUI.delay(2)

def switchElement = WebUI.findWebElement(gardenSwitch)
boolean isSwitchOn = switchElement.getAttribute("class").contains("checked")

if (!isSwitchOn) {
	WebUI.click(gardenSwitch)
	KeywordUtil.logInfo("🔘 Garden switch was OFF — turned ON now.")
} else {
	WebUI.click(gardenSwitch)
	KeywordUtil.logInfo("🔘 Garden switch was ON — turned OFF now.")
}

WebUI.delay(2)
WebUI.click(consentToggle)
WebUI.click(updateTenancyBtn)
WebUI.delay(5)

// --------------------- VERIFY TENANCY AGREEMENT ---------------------
WebUI.scrollToElement(viewDraftBtn, 5)
WebUI.click(viewDraftBtn)
WebUI.delay(5)

WebUI.switchToWindowIndex(1) // open TA tab
WebUI.waitForPageLoad(10)
WebUI.delay(3)

// check if Garden text appears depending on switch
if (!isSwitchOn) {
	// Garden switch was OFF before clicking → now ON → text should exist
	if (WebUI.verifyTextPresent('Garden', false, FailureHandling.OPTIONAL)) {
		KeywordUtil.markPassed("✅ 'Garden' text is present in TA when switch is ON.")
	} else {
		KeywordUtil.markFailed("❌ 'Garden' text NOT found when switch is ON.")
	}
} else {
	// Garden switch was ON before clicking → now OFF → text should NOT exist
	if (WebUI.verifyTextPresent('Garden', false, FailureHandling.OPTIONAL)) {
		KeywordUtil.markFailed("❌ 'Garden' text still appears when switch is OFF.")
	} else {
		KeywordUtil.markPassed("✅ 'Garden' text is correctly NOT present when switch is OFF.")
	}
}
// ---------- CLEANUP ----------
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))
WebUI.delay(1)
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))
WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)
WebUI.closeBrowser()
KeywordUtil.logInfo("🎯 Test completed successfully.")
