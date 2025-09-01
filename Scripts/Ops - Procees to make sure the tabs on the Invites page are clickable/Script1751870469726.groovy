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
WebUI.navigateToUrl('https://covered-hill-4728.herokuapp.com/admin/login')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(2)

WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Email field'), 'jecilmae@rentprofile.co')

WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Password field'), 'CegvqGRIwL6GT!mNI09M67o4@EBGKaV5rr')

WebUI.click(findTestObject('Jecil/Admin/Page_RentProfile/Login bt'))

WebUI.waitForPageLoad(3)

WebUI.click(findTestObject('Jecil/Admin/Page_Dashboard  RentProfile/Dashboard - View all invites bt'))

WebUI.waitForPageLoad(5)

WebUI.verifyTextPresent('Invites', false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Show All'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=show_all', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=show_all', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - My Renters_Guarantors Pending'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=my_renters_guarantors_pending', 
    'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=my_renters_guarantors_pending', false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - My Team In Progress'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=my_team_in_progress', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=my_team_in_progress', 
    false)

WebUI.delay(2)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites -Landlord Checks In Progress'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=landlord_checks_in_progress', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=landlord_checks_in_progress', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - All Renters _Guarantors Pending'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=all_renters_guarantors_pending', 
    'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=all_renters_guarantors_pending', false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Company Checks Pending'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=company_checks_pending', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=company_checks_pending', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Trial Pending'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=trial_pending', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=trial_pending', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Renters _Guarantors Complete'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=renters_guarantors_complete', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=renters_guarantors_complete', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Company Checks Complete'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=company_checks_complete', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=company_checks_complete', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Renters _Guarantors Complete Referencing Only'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=renters_guarantors_complete_referencing_only', 
    'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=renters_guarantors_complete_referencing_only', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Not Paid'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=not_paid', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=not_paid', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Permitted Occupiers'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=permitted_occupiers', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=permitted_occupiers', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Renewal Only'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=renewal_only', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=renewal_only', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Testing'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=testing', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=testing', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites -Review'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=review', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=review', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Trial'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=trial', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=trial', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Acorn Checks'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=acorn_checks', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=acorn_checks', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - My In Progress (OLD)'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=my_in_progress_old', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=my_in_progress_old', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites -  Athens In Progress'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=athens_in_progress', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=athens_in_progress', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Berlin In Progress'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=berlin_in_progress', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=berlin_in_progress', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites -  Vienna In Progress'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=vienna_in_progress', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=vienna_in_progress', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites -  R2r Follow Up'))

WebUI.waitForPageLoad(5)

WebUI.verifyMatch('https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=r2r_follow_up', 'https://covered-hill-4728.herokuapp.com/shelpeak/admin/invites?scope=r2r_follow_up', 
    false)

WebUI.delay(2)

WebUI.click(findTestObject('Jecil/Admin/Page_Dashboard  RentProfile/Dashboard - Logout bt'))

WebUI.closeBrowser()

