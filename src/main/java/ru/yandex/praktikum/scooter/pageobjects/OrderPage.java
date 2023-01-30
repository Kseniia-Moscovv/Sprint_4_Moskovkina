package ru.yandex.praktikum.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;

    // Заголовок формы заказа "Для кого самокат"
    private final By orderFormTittle = By.xpath(".//div[@class='Order_Header__BZXOb'][text()='Для кого самокат']");

    // Поле ввода "Имя"
    private final By nameInput = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");

    // Поле ввода "Фамилия"
    private final By surnameInput = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']");

    // Поле ввода "Адрес: куда привезти заказ"
    private final By addressInput = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле выбора станции метро
    private final By metroStationInput = By.className("select-search__input");

    // Выбрать станцию
    private By getMetroStationOption(String index) {
        return By.xpath(".//ul[@class='select-search__options']/li[@data-index='" + index + "']");
    }

    // Поле ввода "Телефон: на него позвонит курьер"
    private final By phoneInput = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private final By nextButton = By.className("Button_Middle__1CSJM");

    // Заголовок "Про аренду"
    private final By rentFormTittle = By.xpath(".//div[@class='Order_Header__BZXOb'][text()='Про аренду']");

    // Поле ввода "Когда привезти самокат"
    private final By rentDataDropdown = By.xpath(".//div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']");

    // Поле выбора срока аренды
    private final By rentTimeDropdown = By.className("Dropdown-placeholder");

    // Срок аренды
    private By getRentTime(String rentTime) {
        return By.xpath(".//div[@class='Dropdown-option'][text()='" + rentTime + "']");
    }

    // Выбрать цвет самоката: Чекбокс "чёрный жемчуг"
    public static final By BLACK_COLOUR = By.id("black");

    // Выбрать цвет самоката: Чекбокс "серая безысходность"
    public static final By GREY_COLOUR = By.id("grey");

    // Поле ввода "Комментарий для курьера"
    private final By commentInput = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='Комментарий для курьера']");

    // Кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    // Окно подтверждения заказа
    private final By approveOrderModal = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ'][text()='Хотите оформить заказ?']");

    //Кнопка "Да"
    private final By approveOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    // Окно "Заказ оформлен"
    private final By approvedOrderModal = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ'][text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getOrderFormTittle() {
        return orderFormTittle;
    }

    public void clickOnNameInput() {
        driver.findElement(nameInput).click();
    }

    public void inputName(String userName) {
        driver.findElement(nameInput).sendKeys(userName);
    }

    public void clickOnSurnameInput() {
        driver.findElement(surnameInput).click();
    }

    public void inputSurname(String userSurname) {
        driver.findElement(surnameInput).sendKeys(userSurname);
    }

    public void clickOnAddressInput() {
        driver.findElement(addressInput).click();
    }

    public void inputAddress(String userAddress) {
        driver.findElement(addressInput).sendKeys(userAddress);
    }

    public void clickOnMetroStationInput() {
        driver.findElement(metroStationInput).click();
    }

    public void searchMetroStation(String index) {
        driver.findElement(getMetroStationOption(index)).click();
    }

    public void clickOnPhoneInput() {
        driver.findElement(phoneInput).click();
    }

    public void inputPhoneNumber(String userPhoneNumber) {
        driver.findElement(phoneInput).sendKeys(userPhoneNumber);
    }

    public void clickOnNextButton() {
        driver.findElement(nextButton).click();
    }

    public void waitForRentFormToLoad() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(rentFormTittle));
    }

    public void clickOnRentDataDropdown() {
        driver.findElement(rentDataDropdown).click();
    }

    public void inputRentData(String rentData) {
        WebElement dropdown = driver.findElement(rentDataDropdown);
        dropdown.sendKeys(rentData);
        dropdown.sendKeys(Keys.RETURN);
    }

    public void clickOnRentTimeInput() {
        driver.findElement(rentTimeDropdown).click();
    }

    public void selectRentTime(String rentTime) {
        driver.findElement(getRentTime(rentTime)).click();
    }

    public void clickOnColourCheckbox(By colour) {
        driver.findElement(colour).click();
    }

    public void clickOnCommentInput() {
        driver.findElement(commentInput).click();
    }

    public void inputComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickOnOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void waitForApproveOrderModalToLoad() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(approveOrderModal));
    }

    public void clickOnApproveOrderButtonButton() {
        driver.findElement(approveOrderButton).click();
    }

    public void waitForApprovedOrderModalToLoad() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(approvedOrderModal));
    }

    public void fillInClientForm(String userName, String userSurname, String userAddress, String metroStation, String userPhone) {
        clickOnNameInput();
        inputName(userName);
        clickOnSurnameInput();
        inputSurname(userSurname);
        clickOnAddressInput();
        inputAddress(userAddress);
        clickOnMetroStationInput();
        searchMetroStation(metroStation);
        clickOnPhoneInput();
        inputPhoneNumber(userPhone);
        clickOnNextButton();
    }

    public void fillInRentForm(String rentData, String rentTime, By colour, String comment) {
        clickOnRentDataDropdown();
        inputRentData(rentData);
        clickOnRentTimeInput();
        selectRentTime(rentTime);
        clickOnColourCheckbox(colour);
        clickOnCommentInput();
        inputComment(comment);
        clickOnOrderButton();
    }

    public void approveOrder() {
        waitForApproveOrderModalToLoad();
        clickOnApproveOrderButtonButton();
        waitForApprovedOrderModalToLoad();
    }
}
