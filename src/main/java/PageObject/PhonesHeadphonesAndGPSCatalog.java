package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PhonesHeadphonesAndGPSCatalog {

    private SelenideElement mobilePhoneListing = $x("//li[@class='portal-navigation__item']//span[text()=' Мобильные телефоны ']");
    public SelenideElement titleCatalog = $x("//h1[@class='catalog-heading']");

    public void openMobilePhoneListing() {
        mobilePhoneListing.click();
    }
}
