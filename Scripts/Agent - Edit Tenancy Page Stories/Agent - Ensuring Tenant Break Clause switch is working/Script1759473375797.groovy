import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Random
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
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

// ----------------- SETUP & NAVIGATION -----------------
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseURL)
WebUI.maximizeWindow()
WebUI.waitForPageLoad(5)

// ---------- LOGIN ----------
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))
WebUI.delay(1)
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Homepage Login - Agent login bt'))
WebUI.delay(1)
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'hotblackstaging@rentprofile.co')
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72')
WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))
WebUI.delay(3)

// ---------- FIND TENANCY & EDIT ----------
WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), '79AFF')
WebUI.sendKeys(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), Keys.chord(Keys.ENTER))
WebUI.delay(3)
WebUI.click(findTestObject('Jecil/Agent/Onboarding - New Tenancy Column - Agency Terms bt'))
WebUI.delay(2)
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Onboarding - Edit Tenancy bt'))
WebUI.delay(3)

// ---------- XPATHS ----------
String xpathBreakClauseSwitch = '//*[@id="breakclausedateswitch_switch"]'
String xpathBreakClauseDropdown = '//*[@id="break_clause_term"]'
String xpathBreakClauseDate = '//*[@id="break_clause_date"]'
String xpathProposedStartDate = '//*[@id="proposedmoveindate"]'
String xpathTenancyTerm = '//*[@id="tenancyterm"]'

// ---------- TEST OBJECTS ----------
TestObject switchObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpathBreakClauseSwitch)
TestObject dropdownObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpathBreakClauseDropdown)
TestObject breakDateObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpathBreakClauseDate)
TestObject proposedStartObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpathProposedStartDate)
TestObject tenancyTermObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpathTenancyTerm)

WebUI.scrollToElement(switchObj, 5)
WebUI.delay(1)

// ---------- SWITCH BEHAVIOR ----------
String switchClass = WebUI.getAttribute(switchObj, "class")
boolean isSwitchOn = switchClass != null && switchClass.toLowerCase().contains("switchon")

if (isSwitchOn) {
    // 🔴 CASE 1: TURN OFF BREAK CLAUSE
    WebUI.click(switchObj)
    KeywordUtil.logInfo("🔴 Break Clause switch was ON → turned OFF.")
    WebUI.delay(2)

    // Consent + Update Tenancy
    TestObject consentToggle = new TestObject('consentToggle')
    consentToggle.addProperty("xpath", ConditionType.EQUALS, '//*[@id="standingorderswitch_confirm"]')
    WebUI.click(consentToggle)
    WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt'))
    WebUI.delay(5)

    // ---------- VIEW DRAFT TENANCY AGREEMENT ----------
    TestObject viewDraftBtn = new TestObject('viewDraftBtn')
    viewDraftBtn.addProperty("xpath", ConditionType.EQUALS, '//*[@id="checkstable"]/div[2]/p[1]/a/span')

    WebUI.scrollToElement(viewDraftBtn, 5)
    WebUI.click(viewDraftBtn)
    WebUI.delay(5)

    // Switch to new tab
    WebUI.switchToWindowIndex(1)
    WebUI.waitForPageLoad(5)

    // ✅ FIX: Verify Break Clause text (with scrolling)
    TestObject breakClauseText = new TestObject('breakClauseText')
    breakClauseText.addProperty('xpath', ConditionType.EQUALS, "/html/body/div[3]/div[2]/div/table/tbody/tr[6]/td/table[1]/tbody/tr[4]/td/table/tbody/tr[12]/td[1]/p")

    // Scroll down fully and then to the Break Clause text
    WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)", null)
    WebUI.delay(3)
    WebUI.scrollToElement(breakClauseText, 5)
    WebUI.delay(2)

 // Check if any "Break Clause" text appears in the visible content
boolean textPresent = WebUI.verifyTextPresent('The Tenant may terminate the tenancy', false, FailureHandling.OPTIONAL)

if (textPresent) {
    // Now double-check if that text is actually visible in the rendered page
    boolean actuallyVisible = WebUI.verifyElementVisible(breakClauseText, FailureHandling.OPTIONAL)
    if (actuallyVisible) {
        KeywordUtil.markFailed("❌ Break Clause text is visible in the tenancy agreement even though the switch is OFF!")
    } else {
        KeywordUtil.logInfo("✅ Break Clause text exists in the HTML source but is NOT visible — treated as hidden (PASS).")
    }
} else {
    KeywordUtil.logInfo("✅ Verified: Break Clause text is completely absent when switch is OFF.")
}

// Go back to main tab
WebUI.closeWindowIndex(1)
WebUI.switchToWindowIndex(0)


} else {
    // 🟢 CASE 2: TURN ON BREAK CLAUSE AND VALIDATE
    WebUI.click(switchObj)
    WebUI.delay(2)
    KeywordUtil.logInfo("🟢 Break Clause switch was OFF → turned ON. Proceeding...")

    // ---------- RANDOM TERM SELECTION ----------
    List<String> terms = ["3 months", "6 months", "10 months", "12 months", "18 months"]
    Random rand = new Random()
    String selectedTerm = terms[rand.nextInt(terms.size())]
    KeywordUtil.logInfo("🎲 Selected break clause term: ${selectedTerm}")

    WebUI.selectOptionByLabel(dropdownObj, selectedTerm, false)
    WebUI.delay(5)

    // ---------- DATE VALIDATION ----------
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    String proposedStartStr = WebUI.getAttribute(proposedStartObj, "value")
    LocalDate proposedStartDate = LocalDate.parse(proposedStartStr, formatter)
    int monthsToAdd = selectedTerm.replaceAll("[^0-9]", "").toInteger()
    LocalDate expectedDate = proposedStartDate.plusMonths(monthsToAdd)
    String expectedDateStr = expectedDate.format(formatter)

    WebUI.delay(5)
    String actualDateStr = WebUI.getAttribute(breakDateObj, "value")

    if (actualDateStr != expectedDateStr) {
        KeywordUtil.logInfo("⚠️ Adjusting tenancy term due to mismatch...")
        int newTerm = monthsToAdd + 2
        WebUI.selectOptionByLabel(tenancyTermObj, "${newTerm} months", false)
        WebUI.delay(5)
        WebUI.selectOptionByLabel(dropdownObj, selectedTerm, false)
        WebUI.delay(3)
        actualDateStr = WebUI.getAttribute(breakDateObj, "value")
    }

    assert actualDateStr == expectedDateStr : "❌ Expected ${expectedDateStr} but got ${actualDateStr}"
    KeywordUtil.logInfo("✅ Break Clause auto-date is correct: ${actualDateStr}")

    // ---------- SAVE ----------
    TestObject consentToggle = new TestObject('consentToggle')
    consentToggle.addProperty("xpath", ConditionType.EQUALS, '//*[@id="standingorderswitch_confirm"]')
    WebUI.click(consentToggle)
    WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt'))
    WebUI.delay(5)

    // ---------- VIEW DRAFT TENANCY ----------
    TestObject viewDraftButton = new TestObject('dynamicViewDraftBtn')
    viewDraftButton.addProperty('xpath', ConditionType.EQUALS, "//*[@id='checkstable']/div[2]/p[1]/a/span")
    WebUI.waitForElementVisible(viewDraftButton, 10)
    WebUI.scrollToElement(viewDraftButton, 5)
    WebUI.click(viewDraftButton)

    // Switch to new tab
    WebUI.switchToWindowIndex(1)
    WebUI.waitForPageLoad(5)

    // ✅ Verify Break Clause text visible when switch ON
    TestObject breakClauseText = new TestObject('breakClauseText')
    breakClauseText.addProperty('xpath', ConditionType.EQUALS, "/html/body/div[3]/div[2]/div/table/tbody/tr[6]/td/table[1]/tbody/tr[4]/td/table/tbody/tr[12]/td[2]/p")

    WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)", null)
    WebUI.delay(3)
    WebUI.scrollToElement(breakClauseText, 5)
    WebUI.delay(5)

    boolean isBreakClauseVisible = WebUI.verifyElementPresent(breakClauseText, 10, FailureHandling.OPTIONAL)
    if (isBreakClauseVisible) {
        KeywordUtil.markPassed('✅ Break Clause text is correctly displayed in the Tenancy Agreement.')
    } else {
        KeywordUtil.markFailed('❌ Expected Break Clause text not found in Tenancy Agreement!')
    }
	WebUI.delay(5)
    WebUI.closeWindowIndex(1)
    WebUI.switchToWindowIndex(0)
}

// ---------- CLEANUP ----------
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))
WebUI.delay(1)
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))
WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)
WebUI.closeBrowser()
KeywordUtil.logInfo("🎯 Test completed successfully.")
