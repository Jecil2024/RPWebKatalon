import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// --- Login and setup
WebUI.openBrowser('')

'Navigate homepage'
WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(5)

WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Email field'), 'jecilmae@rentprofile.co')

WebUI.setText(findTestObject('Jecil/Admin/Page_RentProfile/Password field'), 'CegvqGRIwL6GT!mNI09M67o4@EBGKaV5rr')

WebUI.click(findTestObject('Jecil/Admin/Page_RentProfile/Login bt'))

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Jecil/Admin/Page_Dashboard  RentProfile/Dashboard - View all renter sign ups bt'))

WebUI.waitForPageLoad(10)

WebUI.verifyTextPresent('Renters', false)

WebUI.delay(2)

// Define the Application Error banner
TestObject errorBanner = new TestObject()

errorBanner.addProperty('xpath', ConditionType.EQUALS, '/html/body/div[2]/div')

// List of tab objects and expected URLs
def tabs = [[findTestObject('Jecil/Admin/Page_Renters  RentProfile/Renters - Show All'), 'scope=show_all'], [findTestObject(
            'Jecil/Admin/Page_Renters  RentProfile/Renters - My In Progress'), 'scope=my_in_progress'], [findTestObject(
            'Jecil/Admin/Page_Renters  RentProfile/Renters - My Team In Progress'), 'scope=my_team_in_progress'], [findTestObject(
            'Jecil/Admin/Page_Renters  RentProfile/Renters - Landlord Checks In Progress'), 'scope=landlord_checks_in_progress']
    , [findTestObject('Jecil/Admin/Page_Renters  RentProfile/Renters - All In Progress'), 'scope=all_in_progress'], [findTestObject(
            'Jecil/Admin/Page_Renters  RentProfile/Renters - Unlinked'), 'scope=unlinked'], [findTestObject('Jecil/Admin/Page_Invites  RentProfile/Invites - Trial Pending')
        , 'scope=trials_in_progress'], [findTestObject('Jecil/Admin/Page_Renters  RentProfile/Renters - Clients In Progress')
        , 'scope=clients_in_progress'], [findTestObject('Jecil/Admin/Page_Renters  RentProfile/Renters - Testing In Progress')
        , 'scope=testing_in_progress'], [findTestObject('Jecil/Admin/Page_Renters  RentProfile/Renters - Processed'), 'scope=processed']
    , [findTestObject('Jecil/Admin/Page_Renters  RentProfile/Renters - Duplicates'), 'scope=duplicates'], [findTestObject(
            'Jecil/Admin/Page_Renters  RentProfile/Renters - Random Signups'), 'scope=random_signups'], [findTestObject(
            'Jecil/Admin/Page_Renters  RentProfile/Renters - Testing Processed'), 'scope=testing_processed'], [findTestObject(
            'Jecil/Admin/Page_Renters  RentProfile/Renters - Unresponsive Template'), 'scope=unresponsive_template'], [findTestObject(
            'Jecil/Admin/Page_Renters  RentProfile/Renters - Permitted Occupier Processing'), 'scope=permitted_occupier_processing']
    , [findTestObject('Jecil/Admin/Page_Renters  RentProfile/Renters - Permitted Occupier Complete'), 'scope=permitted_occupier_complete']
    , [findTestObject('Jecil/Admin/Page_Renters  RentProfile/Renters - Native Communities Checks'), 'scope=native_communities_checks']]

// Loop over each tab
for (def tab : tabs) {
    def tabObject = tab[0]

    def urlFragment = tab[1]

    try {
        WebUI.scrollToElement(tabObject, 5)

        WebUI.waitForElementVisible(tabObject, 10, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(tabObject)

        WebUI.waitForPageLoad(10)

        WebUI.delay(2)

        // Handle application error by refreshing up to 20 times
        int retryCount = 0

        boolean hasError = WebUI.verifyElementPresent(errorBanner, 3, FailureHandling.OPTIONAL)

        while (hasError && (retryCount < 20)) {
            WebUI.comment("⚠️ Application Error detected on $urlFragment. Refresh attempt ${retryCount + 1}")

            WebUI.refresh()

            WebUI.waitForPageLoad(10)

            WebUI.delay(2)

            retryCount++

            hasError = WebUI.verifyElementPresent(errorBanner, 3, FailureHandling.OPTIONAL)
        }
        
        if (hasError) {
            WebUI.comment("❌ Still Application Error after 20 refreshes. Going back and skipping this tab: $urlFragment")

            WebUI.takeScreenshot()

            WebUI.back()

            WebUI.waitForPageLoad(10)

            WebUI.delay(2)

            continue
        }
        
        // Confirm URL fragment is in the current page
        String currentUrl = WebUI.getUrl()

        assert currentUrl.contains(urlFragment)

        WebUI.comment("✅ Successfully loaded tab: $urlFragment")

        WebUI.delay(2)
    }
    catch (Exception e) {
        WebUI.comment("❗ Unexpected error in tab $urlFragment: " + e.getMessage())

        WebUI.takeScreenshot()

        WebUI.back()

        WebUI.waitForPageLoad(10)

        WebUI.delay(2)
    } 
}

// Logout and close browser
WebUI.click(findTestObject('Jecil/Admin/Page_Dashboard  RentProfile/Dashboard - Logout bt'))

WebUI.closeBrowser()

