package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class MainPage {
    private WebDriver driver;

    // Кнопка "Заказать" в хедере страницы
    private By headerOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    // Кнопка "Заказать" на странице перед футером
    private By footerOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    // Раздел "Вопросы о важном"
    private By containerFAQ =  By.className("Home_FAQ__3uVm4");

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
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
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
