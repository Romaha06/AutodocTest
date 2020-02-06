import PageObject.MainPage;
import PageObject.PhonesListing;
import org.testng.annotations.Test;



public class CheckSortingTest extends BaseTest {

    @Test(groups = {"Regression"})
    public void getTopItemsToFileFrom3PagesAndCheckSortingTest() {
        new MainPage().openPhonesTvAndElectronicsCatalog()
                .openPhoneHeadphonesAndGPSCatalog()
                .openMobilePhoneListing()
                .loadMoreItem()
                .loadMoreItem()
                .saveTopSalesItemsTo(PhonesListing.listOfTopSalesItems)
                .writeTopSalesItemsToFileFrom(PhonesListing.listOfTopSalesItems)
                .selectSortOrderFromCheaper()
                .checkSortingByPrice(true);
    }
}
