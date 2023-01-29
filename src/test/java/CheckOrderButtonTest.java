import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.MainPage;
import pageObjects.OrderPage;

public class CheckOrderButtonTest {
    private WebDriver driver;

    @Test
    public void checkHeaderButtonClick() {
        MainPage mainPageObj = new MainPage(driver);
        OrderPage orderPageObj = new OrderPage(driver);
        mainPageObj.clickHeaderOrderButton();
        mainPageObj.waitForOrderFormToLoad(orderPageObj.getOrderFormTittle());
    }

    @Test
    public void checkFooterButtonClick() {
        MainPage mainPageObj = new MainPage(driver);
        OrderPage orderPageObj = new OrderPage(driver);
        mainPageObj.scrollToFooterOrderButton();
        mainPageObj.clickFooterOrderButton();
        mainPageObj.waitForOrderFormToLoad(orderPageObj.getOrderFormTittle());
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
