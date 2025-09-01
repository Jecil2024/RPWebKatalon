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
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Email address'), 'stagingtestingagency@rentprofile.co')

WebUI.delay(2)

'Input password'
WebUI.setText(findTestObject('Jecil/Agent/Agent login page - Password'), 'test442s')

WebUI.delay(2)

'Click login button in agent page'
WebUI.click(findTestObject('Jecil/Agent/Agent login page - Agent Login bt'))

WebUI.delay(2)

WebUI.setText(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), 'Katalon AST')

WebUI.sendKeys(findTestObject('Jecil/Agent/Properties-Onboarding - Search bar'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Properties - New Tenancy Column - Start bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Side panel - Tenancy - Onboarding bt'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Side panel - Tenancy - Create tenancy'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for AST'))

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip description for AST'))

WebUI.verifyTextPresent('An Assured Shorthold Tenancy is the most common type of tenancy. It falls within the Housing act 2004', 
    false)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for AST'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for NHA Individuals'))

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip description for NHA Individual'))

WebUI.verifyTextPresent('A Non-Housing Act Tenancy is typically used if the rent is over £100,000 a year, or where it is not the tenant\'s main home.', 
    false)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for NHA Individuals'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for NHA Company'))

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip description for NHA Company'))

WebUI.verifyTextPresent(' A Non-Housing Act Tenancy for a company is used when a company takes on a residential tenancy agreement as the tenant (company let), rather than an individual.', 
    false)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for NHA Company'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for Rent Increase'))

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip description for Rent Increase'))

WebUI.verifyTextPresent('The increase applies to the sooner of annual rent increase or start of rolling tenancy.', false)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for Rent Increase'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for Collect externally'))

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip description for Collect externally'))

WebUI.verifyTextPresent('Enabling means the holding deposit will not be collected by RentProfile. Tenants should pay the holding deposit directly to the agent.', 
    false)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for Collect externally'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for Custom Clause'))

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip description for Custom Clause'))

WebUI.verifyTextPresent('Structure:', false)

WebUI.verifyTextPresent('1. New custom clause', false)

WebUI.verifyTextPresent('1.1 first paragraph in section 1 of custom clauses', false)

WebUI.verifyTextPresent(' 1.2 second paragraph in section 1 of custom clauses', false)

WebUI.verifyTextPresent('2. Second custom clause', false)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for Custom Clause'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for Lead Tenant'))

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip description for Lead Tenant'))

WebUI.verifyTextPresent('The lead tenant is responsible for paying holding deposit payment (if applicable), deposit and initial rent.', 
    false)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for Lead Tenant'))

WebUI.delay(2)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - NHA for company radio button'))

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip icon for Contact name'))

WebUI.verifyElementVisible(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip description for Contact name'))

WebUI.verifyTextPresent('The Contact is a person within the company who is authorized to approve the rental of this property.', 
    false)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Create tenancy - Tooltip description for Contact name'))

WebUI.delay(2)

// ============ LOGOUT ============
WebUI.refresh()

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account bt'))

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Agent/Page_RentProfile  Onboarding eSign, Tenant Checks  Landlord AML/Dashboard - Account page - Logout bt'))

WebUI.delay(2)

WebUI.verifyTextPresent('Complete new tenancies in as little as 20 minutes', false)

WebUI.delay(2)

WebUI.closeBrowser()

