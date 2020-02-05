import PageObject.MainPage;
import PageObject.PhonesHeadphonesAndGPSCatalog;
import PageObject.PhonesListing;
import PageObject.PhonesTvAndElectronicsPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;

public class SortingCheck extends BaseTest {

    MainPage mainPage = new MainPage();
    PhonesTvAndElectronicsPage phonesTvAndElectronicsPage = new PhonesTvAndElectronicsPage();
    PhonesHeadphonesAndGPSCatalog phonesHeadphonesAndGPSCatalog = new PhonesHeadphonesAndGPSCatalog();
    PhonesListing phoneListing = new PhonesListing();

    @Test (groups = {"Regression"})
    public void getTopItemsToFileFrom3PagesTest(){
        mainPage.openPhonesTvAndElectronicsCatalog();
        phonesTvAndElectronicsPage.titlePage.shouldBe(visible);
        phonesTvAndElectronicsPage.openPhoneHeadphonesAndGPSCatalog();
        phonesHeadphonesAndGPSCatalog.titleCatalog.shouldBe(visible);
        phonesHeadphonesAndGPSCatalog.openMobilePhoneListing();
        phoneListing.listingTitle.shouldBe(visible);
        phoneListing.goToPage();
        phoneListing.goToPage();
        phoneListing.saveTopSalesItemsTo(PhonesListing.listOfTopSalesItems);
        phoneListing.writeTopSalesItemsToFileFrom(PhonesListing.listOfTopSalesItems);
        phoneListing.selectSortOrderFromCheaper();
        phoneListing.checkSortingByPrice(true);
    }
}
