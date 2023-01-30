package ru.yandex.praktikum.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;

    // Кнопка "Заказать" в хедере страницы
    private final By headerOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    // Кнопка "Заказать" на странице перед футером
    private final By footerOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Раздел "Вопросы о важном"
    private final By containerFAQ = By.className("Home_FAQ__3uVm4");

    // Вопрос от цене: "Сколько это стоит? И как оплатить?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_PRICE = By.id("accordion__heading-0");

    // Отвтет на вопрос о цене
    public static final By ANSWER_ABOUT_PRICE = By.id("accordion__panel-0");

    public static final String ANSWER_ABOUT_PRICE_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    // Вопрос о количестве самокатов: "Хочу сразу несколько самокатов! Так можно?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_SEVERAL = By.id("accordion__heading-1");

    // Ответ на вопрос о количестве самокатов
    public static final By ANSWER_ABOUT_SEVERAL = By.id("accordion__panel-1");

    // Вопрос о расчете времени аренды: "Как рассчитывается время аренды?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_RENTAL_TIME = By.id("accordion__heading-2");

    // Ответ о расчете времени аренды
    public static final By ANSWER_ABOUT_RENTAL_TIME = By.id("accordion__panel-2");

    // Вопрос о заказе на текущий день: "Можно ли заказать самокат прямо на сегодня?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_ORDER_TODAY = By.id("accordion__heading-3");

    //Ответ о заказе на текущий день
    public static final By ANSWER_ABOUT_ORDER_TODAY = By.id("accordion__panel-3");

    // Вопрос об изменении срока аренды: "Можно ли продлить заказ или вернуть самокат раньше?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_RENT_TIME_EDIT = By.id("accordion__heading-4");

    // Ответ об изменении срока аренды
    public static final By ANSWER_ABOUT_RENT_TIME_EDIT = By.id("accordion__panel-4");

    // Вопрос "Вы привозите зарядку вместе с самокатом?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_CHARGING = By.id("accordion__heading-5");

    // Ответ о наличии зарядки для самоката
    public static final By ANSWER_ABOUT_CHARGING = By.id("accordion__panel-5");

    // Вопрос "Можно ли отменить заказ?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_CANCEL = By.id("accordion__heading-6");

    // Ответ об отмене заказа
    public static final By ANSWER_ABOUT_CANCEL = By.id("accordion__panel-6");

    // Вопрос "Я жиз(в?)у за МКАДом, привезёте?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_OUTSIDE_MKAD = By.id("accordion__heading-7");

    // Ответ о зоне доставки за МКАД
    public static final By ANSWER_ABOUT_OUTSIDE_MKAD = By.id("accordion__panel-7");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    public void clickFooterOrderButton() {
        driver.findElement(footerOrderButton).click();
    }

    public void scrollToFooterOrderButton() {
        WebElement element = driver.findElement(footerOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitForOrderFormToLoad(By orderFormTitle) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(orderFormTitle));
    }

    public void scrollToFAQ() {
        WebElement element = driver.findElement(containerFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOnQuestion(By question) {
        driver.findElement(question).click();
    }

    public String getAnswerText(By answer) {
        return driver.findElement(answer).getText();
    }
}
