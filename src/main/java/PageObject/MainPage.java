package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private SelenideElement phones_TV_electronicsLink = $x("//ul[@class='menu-categories menu-categories_type_main']//a[text()='Смартфоны, ТВ и электроника']");


    public void openPhonesTvAndElectronicsCatalog() {
        phones_TV_electronicsLink.click();
    }
}
