import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.scooter.pageobjects.MainPage;

@RunWith(Parameterized.class)
public class CheckFAQTest {
    private WebDriver driver;

    private final By question;
    private final By answer;
    private final String text;

    private static final String ANSWER_ABOUT_PRICE_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    private static final String ANSWER_ABOUT_SEVERAL_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    private static final String ANSWER_ABOUT_RENTAL_TIME_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    private static final String ANSWER_ABOUT_ORDER_TODAY_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

    private static final String ANSWER_ABOUT_RENT_TIME_EDIT_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

    private static final String ANSWER_ABOUT_CHARGING_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

    private static final String ANSWER_ABOUT_CANCEL_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

    private static final String ANSWER_ABOUT_OUTSIDE_MKAD_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public CheckFAQTest(By question, By answer, String text) {
        this.question = question;
        this.answer = answer;
        this.text = text;
    }

    @Parameterized.Parameters(name = "{index}: Вопрос {0} - Ответ {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {MainPage.QUESTION_ABOUT_PRICE, MainPage.ANSWER_ABOUT_PRICE, ANSWER_ABOUT_PRICE_TEXT},
                {MainPage.QUESTION_ABOUT_SEVERAL, MainPage.ANSWER_ABOUT_SEVERAL, ANSWER_ABOUT_SEVERAL_TEXT},
                {MainPage.QUESTION_ABOUT_RENTAL_TIME, MainPage.ANSWER_ABOUT_RENTAL_TIME, ANSWER_ABOUT_RENTAL_TIME_TEXT},
                {MainPage.QUESTION_ABOUT_ORDER_TODAY, MainPage.ANSWER_ABOUT_ORDER_TODAY, ANSWER_ABOUT_ORDER_TODAY_TEXT},
                {MainPage.QUESTION_ABOUT_RENT_TIME_EDIT, MainPage.ANSWER_ABOUT_RENT_TIME_EDIT, ANSWER_ABOUT_RENT_TIME_EDIT_TEXT},
                {MainPage.QUESTION_ABOUT_CHARGING, MainPage.ANSWER_ABOUT_CHARGING, ANSWER_ABOUT_CHARGING_TEXT},
                {MainPage.QUESTION_ABOUT_CANCEL, MainPage.ANSWER_ABOUT_CANCEL, ANSWER_ABOUT_CANCEL_TEXT},
                {MainPage.QUESTION_ABOUT_OUTSIDE_MKAD, MainPage.ANSWER_ABOUT_OUTSIDE_MKAD, ANSWER_ABOUT_OUTSIDE_MKAD_TEXT},
        };
    }

    @Test
    public void checkAnswerText() {
        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.scrollToFAQ();
        mainPageObj.clickOnQuestion(question);
        String actualText = mainPageObj.getAnswerText(answer);
        Assert.assertEquals(text, actualText);
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
