package PageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    PhonesTvAndElectronicsPage phonesTvAndElectronicsPage = new PhonesTvAndElectronicsPage();

    private SelenideElement phones_TV_electronicsLink = $x("//ul[@class='menu-categories menu-categories_type_main']//a[text()='Смартфоны, ТВ и электроника']");

    public PhonesTvAndElectronicsPage openPhonesTvAndElectronicsCatalog() {
        phones_TV_electronicsLink.click();
        phonesTvAndElectronicsPage.titlePage.shouldBe(visible);
        return page (PhonesTvAndElectronicsPage.class );
    }
}
