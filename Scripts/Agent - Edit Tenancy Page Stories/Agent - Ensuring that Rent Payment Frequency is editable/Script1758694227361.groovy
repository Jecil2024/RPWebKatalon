import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import java.util.Random
import java.math.BigDecimal
import java.util.regex.Pattern
import java.util.regex.Matcher

// ----------------- START -----------------
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseURL)
WebUI.maximizeWindow()
WebUI.waitForPageLoad(10)

// ----------------- LOGIN FLOW -----------------
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))
WebUI.delay(2)
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Homepage Login - Agent login bt'))
WebUI.delay(2)
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'hotblackstaging@rentprofile.co')
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72')
WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))
WebUI.delay(3)

// ----------------- SEARCH TENANCY -----------------
WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), '79AFF')
WebUI.sendKeys(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Jecil/Agent/Onboarding - New Tenancy Column - Agency Terms bt'))
WebUI.delay(2)
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Onboarding - Edit Tenancy bt'))
WebUI.delay(3)

// ----------------- SELECT RANDOM FREQUENCY -----------------
TestObject dropdown = findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Edit Tenancy - Rent Payment Frequency dropdown')
if (dropdown == null) {
    dropdown = new TestObject("dynamicDropdown")
    dropdown.addProperty("xpath", ConditionType.EQUALS, "//select[contains(@id,'frequency')]")
}
WebElement dropdownElement = WebUI.findWebElement(dropdown)
Select select = new Select(dropdownElement)

List<WebElement> allOptions = select.getOptions()
List<String> validOptions = []
for (WebElement opt : allOptions) {
    String txt = opt.getText().trim()
    if (txt && !txt.equalsIgnoreCase("Select") && !txt.equalsIgnoreCase("--Select--")) {
        validOptions.add(txt)
    }
}
if (validOptions.isEmpty()) {
    KeywordUtil.markFailedAndStop("⚠️ No valid rent frequency options found in dropdown.")
}

// pick random
Random rand = new Random(System.currentTimeMillis())
int chosenIndex = rand.nextInt(validOptions.size())
String selectedFreq = validOptions.get(chosenIndex)
select.selectByVisibleText(selectedFreq)
println("✅ Randomly selected frequency: " + selectedFreq)
WebUI.delay(1)

// ----------------- HANDLE INLINE ALERT -----------------
TestObject inlineAlert = new TestObject("inlineAlert")
inlineAlert.addProperty("xpath", ConditionType.EQUALS, "//*[@id='alertonchangingrentschedule']/p")
if (WebUI.waitForElementVisible(inlineAlert, 5, FailureHandling.OPTIONAL)) {
    String alertText = WebUI.getText(inlineAlert)
    println("⚠️ Inline alert displayed: " + alertText)
} else {
    println("✅ No inline alert found.")
}

// ----------------- CAPTURE RENT AMOUNT BEFORE UPDATE -----------------
TestObject rentField = new TestObject("rentField")
rentField.addProperty("xpath", ConditionType.EQUALS, "//*[@id='rentdone']")
if (!WebUI.waitForElementVisible(rentField, 10, FailureHandling.OPTIONAL)) {
    KeywordUtil.markFailedAndStop("❌ Rent input field not found at //*[@id='rentdone']")
}
String rentInput = WebUI.getAttribute(rentField, "value")
println("DEBUG - Rent input value: " + rentInput)
if (rentInput == null || rentInput.trim() == "") {
    KeywordUtil.markFailedAndStop("❌ Rent input field is empty or returned null.")
}
BigDecimal rentalAmount = new BigDecimal(rentInput.replace(",", "").trim())
println("✅ Captured base rental amount: £" + rentalAmount.toString())

// ----------------- CLICK TOGGLE CONSENT -----------------
TestObject toggleConsent = new TestObject("toggleConsent")
toggleConsent.addProperty("xpath", ConditionType.EQUALS, "//*[@id='standingorderswitch_confirm']")
if (WebUI.waitForElementClickable(toggleConsent, 10, FailureHandling.OPTIONAL)) {
    WebUI.click(toggleConsent)
    WebUI.delay(1)
    println("✅ Consent toggle clicked successfully.")
} else {
    KeywordUtil.markWarning("⚠️ Consent toggle not found or not clickable.")
}

// ----------------- CLICK UPDATE TENANCY -----------------
TestObject updateTenancyBtn = new TestObject("updateTenancyBtn")
updateTenancyBtn.addProperty("xpath", ConditionType.EQUALS, "//*[@id='invitecheckvalidmobilenewrightside']")
if (WebUI.waitForElementClickable(updateTenancyBtn, 10, FailureHandling.OPTIONAL)) {
    WebUI.click(updateTenancyBtn)
    println("✅ Update Tenancy button clicked successfully.")
} else {
    KeywordUtil.markWarning("⚠️ Update Tenancy button not found or not clickable.")
}

// ----------------- CALCULATE EXPECTED VALUE -----------------
BigDecimal expectedAmountBD = BigDecimal.ZERO
String freq = selectedFreq.toLowerCase()

if (freq.contains("week")) {
    expectedAmountBD = rentalAmount.multiply(new BigDecimal("12"))
                                   .divide(new BigDecimal("52"), 2, BigDecimal.ROUND_HALF_UP)
} else if (freq.contains("month")) {
    expectedAmountBD = rentalAmount
} else if (freq.contains("quarter")) {
    expectedAmountBD = rentalAmount.multiply(new BigDecimal("3"))
} else if (freq.contains("half")) {
    expectedAmountBD = rentalAmount.multiply(new BigDecimal("6"))
} else if (freq.contains("annua") || freq.contains("year")) {
    expectedAmountBD = rentalAmount.multiply(new BigDecimal("12"))
} else {
    KeywordUtil.markWarning("⚠️ Unknown frequency detected: " + selectedFreq)
}
println("DEBUG - Expected amount for '" + selectedFreq + "': £" + expectedAmountBD.toString())

// ----------------- GET DISPLAYED RENT TEXT -----------------
TestObject rentDisplayObj = new TestObject("rentDisplay")
rentDisplayObj.addProperty("xpath", ConditionType.EQUALS, "//*[@id='checkstablecontainer']//span/p")
if (!WebUI.waitForElementPresent(rentDisplayObj, 8, FailureHandling.OPTIONAL)) {
    KeywordUtil.markFailedAndStop("❌ Rent display element not found.")
}
String uiText = WebUI.getText(rentDisplayObj)
println("DEBUG - UI text: " + uiText)

// ----------------- PARSE AMOUNT & FREQUENCY -----------------
Pattern p = Pattern.compile("£([\\d,]+\\.\\d{2})\\s+per\\s+(.+)", Pattern.CASE_INSENSITIVE)
Matcher m = p.matcher(uiText)
if (!m.find()) {
    KeywordUtil.markFailedAndStop("❌ Unable to parse rent info from UI: " + uiText)
}
BigDecimal uiAmountBD = new BigDecimal(m.group(1).replace(",", ""))
String uiFreq = m.group(2).toLowerCase().trim()
println("DEBUG - Parsed amount: £" + uiAmountBD.toString())
println("DEBUG - Parsed frequency: " + uiFreq)

// ----------------- MAP EXPECTED FREQUENCY -----------------
Map<String, String> freqMap = [
    "weekly"   : "week",
    "monthly"  : "month",
    "quarterly": "quarter",
    "half year": "half year",
    "annually" : "year"
]
String expectedFreq = freqMap.find { k, v -> freq.contains(k) }?.value
if (expectedFreq == null) {
    expectedFreq = freq // fallback
}
println("DEBUG - Normalized expected frequency: " + expectedFreq)

// ----------------- COMPARE & VERIFY -----------------
if (uiAmountBD.compareTo(expectedAmountBD) != 0 || !uiFreq.contains(expectedFreq)) {
    KeywordUtil.markFailed("❌ Mismatch: Expected £" + expectedAmountBD +
        " per " + expectedFreq + ", but UI showed £" + uiAmountBD + " per " + uiFreq)
} else {
    KeywordUtil.logInfo("✅ Verified: UI shows £" + uiAmountBD + " per " + uiFreq + " correctly")
}

// ----------------- LOGOUT -----------------
WebUI.refresh()
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))
WebUI.delay(2)
WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))
WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)
WebUI.closeBrowser()

// ----------------- END -----------------
