import constants.MainPageConstants;
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
import pageObjects.MainPage;

@RunWith(Parameterized.class)
public class CheckFAQTest {
    private WebDriver driver;

    private final By question;
    private final By answer;
    private final String text;

    public CheckFAQTest(By question, By answer, String text) {
        this.question = question;
        this.answer = answer;
        this.text = text;
    }

    @Parameterized.Parameters(name = "{index}: Вопрос {0} - Ответ {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {MainPageConstants.QUESTION_ABOUT_PRICE, MainPageConstants.ANSWER_ABOUT_PRICE, MainPageConstants.ANSWER_ABOUT_PRICE_TEXT},
                {MainPageConstants.QUESTION_ABOUT_SEVERAL, MainPageConstants.ANSWER_ABOUT_SEVERAL, MainPageConstants.ANSWER_ABOUT_SEVERAL_TEXT},
                {MainPageConstants.QUESTION_ABOUT_RENTAL_TIME, MainPageConstants.ANSWER_ABOUT_RENTAL_TIME, MainPageConstants.ANSWER_ABOUT_RENTAL_TIME_TEXT},
                {MainPageConstants.QUESTION_ABOUT_ORDER_TODAY, MainPageConstants.ANSWER_ABOUT_ORDER_TODAY, MainPageConstants.ANSWER_ABOUT_ORDER_TODAY_TEXT},
                {MainPageConstants.QUESTION_ABOUT_RENT_TIME_EDIT, MainPageConstants.ANSWER_ABOUT_RENT_TIME_EDIT, MainPageConstants.ANSWER_ABOUT_RENT_TIME_EDIT_TEXT},
                {MainPageConstants.QUESTION_ABOUT_CHARGING, MainPageConstants.ANSWER_ABOUT_CHARGING, MainPageConstants.ANSWER_ABOUT_CHARGING_TEXT},
                {MainPageConstants.QUESTION_ABOUT_CANCEL, MainPageConstants.ANSWER_ABOUT_CANCEL, MainPageConstants.ANSWER_ABOUT_CANCEL_TEXT},
                {MainPageConstants.QUESTION_ABOUT_OUTSIDE_MKAD, MainPageConstants.ANSWER_ABOUT_OUTSIDE_MKAD, MainPageConstants.ANSWER_ABOUT_OUTSIDE_MKAD_TEXT},
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
