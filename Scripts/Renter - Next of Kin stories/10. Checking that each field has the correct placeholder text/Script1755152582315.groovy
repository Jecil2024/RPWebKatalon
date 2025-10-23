import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

// Login process
WebUI.click(findTestObject('Jecil/Agent/Menu - Login bt'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Email address'), 
    'kekoko6310@cotasen.com')

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Password'), 
    'test1234')

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Renter login page - Renter login bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Identity Check bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Identity check - Continue bt'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

// --- Step 1: Verify placeholders in initial view (Home address in UK) ---
def initialFields = [[findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - First Name field')
        , 'First name'], [findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Last Name field')
        , 'Last name'], [findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Address field')
        , 'Home address'], [findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Email address field')
        , 'Email address'], [findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Mobile number')
        , 'Mobile number']]

verifyPlaceholders(initialFields)

// --- Step 2: Click “Home address is not in the UK” ---
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Home address is not in the UK bt'))

WebUI.delay(1 // wait for dynamic fields to load
    )

// Step 2a: Verify placeholders for dynamic “Not in UK” address fields
def notUKFields = [[findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - First Name field')
        , 'First name'], [findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Last Name field')
        , 'Last name'], [findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Home address line 1 field')
        , 'Home address line 1'], [findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of kin - Home address line 2 (optional)')
        , 'Home address line 2 (optional)'], [findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Town-City field')
        , 'Town/City'], [findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Post code field')
        , 'Postcode'], [findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Email address field')
        , 'Email address'], [findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Mobile number')
        , 'Mobile number']]

verifyPlaceholders(notUKFields)

// --- Step 3: Optional revert back to Home address in UK ---
WebUI.click(findTestObject('Jecil/Renter/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Referencing - Next of Kin - Home address is in the UK bt'))

WebUI.delay(1)

verifyPlaceholders(initialFields)

// --- Helper function to verify placeholders ---
// Logout
WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

def verifyPlaceholders(def fieldsList) {
    boolean hasFailed = false

    fieldsList.each({ def fieldPair ->
            TestObject testObj = fieldPair[0]

            String expectedPlaceholder = fieldPair[1]

            String actualPlaceholder = WebUI.getAttribute(testObj, 'placeholder')

            if (actualPlaceholder == null) {
                actualPlaceholder = ''
            }
            
            actualPlaceholder = actualPlaceholder.trim()

            if (actualPlaceholder.equals(expectedPlaceholder)) {
                WebUI.comment("PASS: Placeholder correct for $testObj.getObjectId() → $actualPlaceholder")
            } else {
                WebUI.comment("FAIL: Placeholder incorrect for $testObj.getObjectId() → $actualPlaceholder")

                WebUI.takeScreenshot()

                hasFailed = true
            }
        })

    if (hasFailed) {
        WebUI.markFailed('One or more placeholder(s) are incorrect. Check console/screenshots.')
    }
}

