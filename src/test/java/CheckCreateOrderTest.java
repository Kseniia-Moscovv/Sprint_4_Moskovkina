import constants.OrderPageConstants;
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
import pageObjects.MainPage;
import pageObjects.OrderPage;

@RunWith(Parameterized.class)
public class CheckCreateOrderTest {
    private WebDriver driver;

    private final String userName;
    private final  String userSurname;
    private final  String userAddress;
    private final  String metroStation;
    private final  String userPhone;
    private final  String rentData;
    private final  String rentTime;
    private final  By colour;
    private final  String comment;

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

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Ксюша", "Московкина", "Зацепский Вал 6", "0", "89996134742", "02.03.2023", "двое суток", OrderPageConstants.BLACK_COLOUR, "Спасибо!"},
                {"Грю", "Фелониус", "Нью Йорк", "1", "89999999999", "14.02.2023", "сутки", OrderPageConstants.GREY_COLOUR, "Банана!"},
        };
    }


    @Test
    public void checkCreateOrder() {
        MainPage mainPageObj = new MainPage(driver);
        OrderPage orderPageObj = new OrderPage(driver);
        mainPageObj.clickHeaderOrderButton();
        mainPageObj.waitForOrderFormToLoad(orderPageObj.getOrderFormTittle());
        orderPageObj.clickOnNameInput();
        orderPageObj.inputName(userName);
        orderPageObj.clickOnSurnameInput();
        orderPageObj.inputSurname(userSurname);
        orderPageObj.clickOnAddressInput();
        orderPageObj.inputAddress(userAddress);
        orderPageObj.clickOnMetroStationInput();
        orderPageObj.searchMetroStation(metroStation);
        orderPageObj.clickOnPhoneInput();
        orderPageObj.inputPhoneNumber(userPhone);
        orderPageObj.clickOnNextButton();
        orderPageObj.waitForRentFormToLoad();
        orderPageObj.clickOnRentDataDropdown();
        orderPageObj.inputRentData(rentData);
        orderPageObj.clickOnRentTimeInput();
        orderPageObj.selectRentTime(rentTime);
        orderPageObj.clickOnColourCheckbox(colour);
        orderPageObj.clickOnCommentInput();
        orderPageObj.inputComment(comment);
        orderPageObj.clickOnOrderButton();
        orderPageObj.waitForApproveOrderModalToLoad();
        orderPageObj.clickOnApproveOrderButtonButton();
        orderPageObj.waitForApprovedOrderModalToLoad();
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
