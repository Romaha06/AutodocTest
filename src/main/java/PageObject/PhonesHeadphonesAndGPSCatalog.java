package PageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class PhonesHeadphonesAndGPSCatalog {

    PhonesListing phonesListing = new PhonesListing();

    private SelenideElement mobilePhoneListing = $x("//li[@class='portal-navigation__item']//span[text()=' Мобильные телефоны ']");
    public  SelenideElement titleCatalog = $x("//h1[@class='catalog-heading']");

    public PhonesListing openMobilePhoneListing() {
        mobilePhoneListing.click();
        phonesListing.listingTitle.shouldBe(visible);
        return page(PhonesListing.class);
    }
}
