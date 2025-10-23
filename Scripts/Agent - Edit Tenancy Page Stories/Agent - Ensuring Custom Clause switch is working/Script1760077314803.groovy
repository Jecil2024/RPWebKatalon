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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

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

// ---------- XPATHS FOR CUSTOM CLAUSE ----------
String xpathCustomClauseSwitch = '//*[@id="table_agreement_details"]/tbody/tr[7]/td[2]/label/div'
String xpathCustomClauseField = '//*[@id="ta_custom_clauses"]'

// Input text (must include 1. to submit successfully)
String inputClauseText = "1. Katalon Custom Clause Testing"

// Verification text (as it appears in TA)
String verifyClauseText = "Katalon Custom Clause Testing"

// ---------- TEST OBJECTS ----------
TestObject customClauseSwitchObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpathCustomClauseSwitch)
TestObject customClauseFieldObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpathCustomClauseField)

// ---------- SCROLL TO SWITCH ----------
WebUI.scrollToElement(customClauseSwitchObj, 5)
WebUI.delay(1)

// ---------- CHECK SWITCH STATUS ----------
String switchClass = WebUI.getAttribute(customClauseSwitchObj, "class")
boolean isSwitchOn = switchClass != null && switchClass.toLowerCase().contains("switchon")

if (isSwitchOn) {
    // 🔴 CASE: TURN OFF CUSTOM CLAUSE
    WebUI.click(customClauseSwitchObj)
    KeywordUtil.logInfo("🔴 Custom Clause switch was ON → turned OFF.")
    WebUI.delay(2)

    // Consent + Update Tenancy
    TestObject consentToggle = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="standingorderswitch_confirm"]')
    WebUI.click(consentToggle)
    WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt'))
    WebUI.delay(5)

    // ---------- VIEW DRAFT TENANCY ----------
    TestObject viewDraftBtn = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="checkstable"]/div[2]/p[1]/a/span')
    WebUI.scrollToElement(viewDraftBtn, 5)
    WebUI.click(viewDraftBtn)
    WebUI.switchToWindowIndex(1)
    WebUI.waitForPageLoad(5)

    // Verify custom clause does NOT exist
    boolean clauseExists = WebUI.verifyTextPresent(verifyClauseText, false, FailureHandling.OPTIONAL)
    if (clauseExists) {
        KeywordUtil.markFailed("❌ Custom Clause should NOT exist when switch is OFF!")
    } else {
        KeywordUtil.logInfo("✅ Custom Clause correctly does NOT exist when switch is OFF.")
    }

    WebUI.closeWindowIndex(1)
    WebUI.switchToWindowIndex(0)

} else {
    // 🟢 CASE: TURN ON CUSTOM CLAUSE
    WebUI.click(customClauseSwitchObj)
    WebUI.delay(2)
    KeywordUtil.logInfo("🟢 Custom Clause switch was OFF → turned ON.")

    // Enter text in the custom clause field
    WebUI.setText(customClauseFieldObj, inputClauseText)

    // Consent + Update Tenancy
    TestObject consentToggle = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="standingorderswitch_confirm"]')
    WebUI.click(consentToggle)
    WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy Page - Update Tenancy bt'))
    WebUI.delay(5)

    // ---------- VIEW DRAFT TENANCY ----------
    TestObject viewDraftBtn = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="checkstable"]/div[2]/p[1]/a/span')
    WebUI.scrollToElement(viewDraftBtn, 5)
    WebUI.click(viewDraftBtn)
    WebUI.switchToWindowIndex(1)
    WebUI.waitForPageLoad(5)

    // Verify custom clause text exists in TA (without the "1.")
    boolean clauseTextExists = WebUI.verifyTextPresent(verifyClauseText, false, FailureHandling.OPTIONAL)
    if (clauseTextExists) {
        KeywordUtil.markPassed("✅ Custom Clause text correctly exists in the tenancy draft.")
    } else {
        KeywordUtil.markFailed("❌ Custom Clause text NOT found in the tenancy draft!")
    }

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
