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
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.util.Random as Random

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
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'hotblackstaging@rentprofile.co')

WebUI.delay(2)

'Input password'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'biketrip72')

WebUI.delay(2)

'Click login button in agent page'
WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), '23029')

WebUI.delay(2)

'Click search icon'
WebUI.click(findTestObject('Jecil/Agent/Properties-Onboarding - Search icon'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/a_27FD2_Tenancy'))

WebUI.delay(2)

Random random = new Random()

// Get the current year and add 3
int futureYear = LocalDate.now().getYear() + 3

// Generate a random month (1 to 12)
int month = random.nextInt(12) + 1

// Generate a random day based on the month and year
int day

switch (month) {
    case 2:
        // Check for leap year
        boolean isLeap = (((futureYear % 4) == 0) && ((futureYear % 100) != 0)) || ((futureYear % 400) == 0)

        day = (random.nextInt(isLeap ? 29 : 28) + 1)

        break
    case 4:
    case 6:
    case 9:
    case 11:
        day = (random.nextInt(30) + 1)

        break
    default:
        day = (random.nextInt(31) + 1)}

// Create the future date
LocalDate futureDate = LocalDate.of(futureYear, month, day)

// Format to dd-MM-yyyy
String formattedDate = futureDate.format(DateTimeFormatter.ofPattern('dd-MM-yyyy'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/In Tenancy - Edit End Date bt'))

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/In Tenancy - Edit End Date textfield'), 
    formattedDate)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/In Tenancy - Edit End date - Confirm bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/span_27FD2_view onboarding'))

// For Onboarding Edit End date
Random random1 = new Random()

int futureYear1 = LocalDate.now().getYear() + 3

int month1 = random1.nextInt(12) + 1

int day1

switch (month1) {
    case 2:
        boolean isLeap1 = (((futureYear1 % 4) == 0) && ((futureYear1 % 100) != 0)) || ((futureYear1 % 400) == 0)

        day1 = (random1.nextInt(isLeap1 ? 29 : 28) + 1)

        break
    case 4:
    case 6:
    case 9:
    case 11:
        day1 = (random1.nextInt(30) + 1)

        break
    default:
        day1 = (random1.nextInt(31) + 1)}

LocalDate futureDate1 = LocalDate.of(futureYear1, month1, day1)

String formattedDate1 = futureDate1.format(DateTimeFormatter.ofPattern('dd-MM-yyyy'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Onboarding - Edit end date bt'))

WebUI.setText(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Onboarding - Edit end date textfield'), 
    formattedDate1)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Onboarding - Edit end date - Confirm bt'))

WebUI.delay(2)

'Logout'
WebUI.click(findTestObject('Jecil/Agent/home_LOGOUT_bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.closeBrowser()

