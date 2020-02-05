import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeMethod (groups = {"Regression"})
    public void openUrl() {

        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        open("https://rozetka.com.ua/");
        System.out.println("The site is open.");
    }

    @AfterMethod (groups = {"Regression"})
    public void turnDown() {
        close();
        System.out.println("The site is closed.");
    }
}
