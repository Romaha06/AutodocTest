package PageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class PhonesTvAndElectronicsPage {

    private SelenideElement smartphoneAndPortDevicesCatalog = $x("//li//a[2][@title='Смартфоны и портативная техника']"),
                            closePopup = $x("//span[@class='exponea-close-cross']");

    public  SelenideElement titlePage = $x("//h1[@class='portal__heading']");


    public PhonesHeadphonesAndGPSCatalog openPhoneHeadphonesAndGPSCatalog() {
        smartphoneAndPortDevicesCatalog.scrollTo();
        closePopup.click();
        smartphoneAndPortDevicesCatalog.click();
        new PhonesHeadphonesAndGPSCatalog().titleCatalog.shouldBe(visible);
        return page (PhonesHeadphonesAndGPSCatalog.class );
    }
}

