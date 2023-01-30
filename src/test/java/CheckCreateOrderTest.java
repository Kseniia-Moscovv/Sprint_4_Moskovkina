import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.scooter.pageobjects.MainPage;
import ru.yandex.praktikum.scooter.pageobjects.OrderPage;

@RunWith(Parameterized.class)
public class CheckCreateOrderTest {
    private WebDriver driver;

    private final String userName;
    private final String userSurname;
    private final String userAddress;
    private final String metroStation;
    private final String userPhone;
    private final String rentData;
    private final String rentTime;
    private final By colour;
    private final String comment;

    public CheckCreateOrderTest(String userName, String userSurname, String userAddress, String metroStation, String userPhone, String rentData, String rentTime, By colour, String comment) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
        this.metroStation = metroStation;
        this.userPhone = userPhone;
        this.rentData = rentData;
        this.rentTime = rentTime;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Тестовые данные: name {0}, surname {1}, address {2}, metro {3}, phone {4}, date {5}, time {6}, colour {7}, comment {8}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Ксюша", "Московкина", "Зацепский Вал 6", "0", "89996134742", "02.03.2023", "двое суток", OrderPage.BLACK_COLOUR, "Спасибо!"},
                {"Грю", "Фелониус", "Нью Йорк", "1", "89999999999", "14.02.2023", "сутки", OrderPage.GREY_COLOUR, "Банана!"},
        };
    }


    @Test
    public void checkCreateOrder() {
        MainPage mainPageObj = new MainPage(driver);
        OrderPage orderPageObj = new OrderPage(driver);

        mainPageObj.clickHeaderOrderButton();
        mainPageObj.waitForOrderFormToLoad(orderPageObj.getOrderFormTittle());

        orderPageObj.fillInClientForm(userName, userSurname, userAddress, metroStation, userPhone);
        orderPageObj.waitForRentFormToLoad();
        orderPageObj.fillInRentForm(rentData, rentTime, colour, comment);
        orderPageObj.approveOrder();
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
