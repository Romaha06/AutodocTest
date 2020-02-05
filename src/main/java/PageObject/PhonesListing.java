package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class PhonesListing {

    public static ArrayList<String> listOfTopSalesItems = new ArrayList<>();
    private File topItemsFile = new File("C:\\Autodoc\\result.txt");

    public SelenideElement listingTitle = $x("//h1[@class='catalog-heading']");

    private SelenideElement sortingSelector = $x("//select[@class='select-css ng-untouched ng-pristine ng-valid']"),
                            loadMoreItem = $x("//span[@class='catalog-more__text']");

    private ElementsCollection topSalesItems = $$x("//span[contains(@class,'promo-label_type_popularity')]/ancestor::div[@class='goods-tile']"),
                               labelPrices = $$x("//span[@class='goods-tile__price-value']");




    public void goToPage() {
        loadMoreItem.scrollTo().click();
    }


    public void saveTopSalesItemsTo(ArrayList<String> list) {
        if (topSalesItems.size() > 0) {
            for (SelenideElement itemBox : topSalesItems) {
                String name = itemBox.$x(".//a[@class='goods-tile__heading']").getAttribute("title");
                String price = itemBox.$x(".//div[contains(@class,'price_color_red')]").getText().replaceAll("\\s*", "");
                String lineForRecord = String.format("%s\t%s\r\n", name, price);
                list.add(lineForRecord);
            }
        }
    }


    public void writeTopSalesItemsToFileFrom(ArrayList<String> list) {
        FileWriter filewriter = null; //Обьявил ссылку на класс FileWriter
        try {
            if (!topItemsFile.exists()) {
                topItemsFile.createNewFile(); //Если файл не существует, создаем его
            }
            filewriter = new FileWriter(topItemsFile); //Создаю обьект класса FileWriter
            for (String item : list) {
                filewriter.write(item); // Записываю все елементы листа в файл
            }
            filewriter.close();
            System.out.println("File writing done.");
            // Этот блок выполняется всегда: закрывается поток записи и обрабатываются ошибки
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (filewriter != null) {
                    filewriter.close();
                }
                listOfTopSalesItems.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void selectSortOrderFromCheaper() {
        sortingSelector.selectOptionByValue("1: cheap");
        sleep(2000);
    }


    public void checkSortingByPrice(boolean naturalOrder) {
        //получаем текст цены, парсим цифры, превращаем в Double и записываем в список pricesFromSite
        List<Double> pricesFromSite = new ArrayList<>();
        for (SelenideElement element : labelPrices) {
            double price = Double.parseDouble(
                    element.getText().replaceAll("\\s*", ""));
            pricesFromSite.add(price);
        }

        //делаем копию списка pricesFromSite и сортируем список sortedPrices
        List<Double> sortedPrices = new ArrayList(pricesFromSite);
        if (naturalOrder == true) {
            Collections.sort(sortedPrices);  //по возростанию
        } else {
            Collections.sort(sortedPrices, Collections.reverseOrder()); //по убыванию
        }
        Assert.assertEquals(pricesFromSite, sortedPrices);
    }
}

