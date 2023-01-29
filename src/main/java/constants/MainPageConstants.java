package constants;

import org.openqa.selenium.By;

public class MainPageConstants {
    // Вопрос от цене: "Сколько это стоит? И как оплатить?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_PRICE = By.id("accordion__heading-0");

    // Отвтет на вопрос о цене
    public static final By ANSWER_ABOUT_PRICE = By.id("accordion__panel-0");

    public static final String ANSWER_ABOUT_PRICE_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    // Вопрос о количестве самокатов: "Хочу сразу несколько самокатов! Так можно?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_SEVERAL = By.id("accordion__heading-1");

    // Ответ на вопрос о количестве самокатов
    public static final By ANSWER_ABOUT_SEVERAL = By.id("accordion__panel-1");

    public static final String ANSWER_ABOUT_SEVERAL_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    // Вопрос о расчете времени аренды: "Как рассчитывается время аренды?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_RENTAL_TIME = By.id("accordion__heading-2");

    // Ответ о расчете времени аренды
    public static final By ANSWER_ABOUT_RENTAL_TIME = By.id("accordion__panel-2");

    public static final String ANSWER_ABOUT_RENTAL_TIME_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    // Вопрос о заказе на текущий день: "Можно ли заказать самокат прямо на сегодня?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_ORDER_TODAY = By.id("accordion__heading-3");

    //Ответ о заказе на текущий день
    public static final By ANSWER_ABOUT_ORDER_TODAY = By.id("accordion__panel-3");

    public static final String ANSWER_ABOUT_ORDER_TODAY_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

    // Вопрос об изменении срока аренды: "Можно ли продлить заказ или вернуть самокат раньше?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_RENT_TIME_EDIT = By.id("accordion__heading-4");

    // Ответ об изменении срока аренды
    public static final By ANSWER_ABOUT_RENT_TIME_EDIT = By.id("accordion__panel-4");

    public static final String ANSWER_ABOUT_RENT_TIME_EDIT_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

    // Вопрос "Вы привозите зарядку вместе с самокатом?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_CHARGING = By.id("accordion__heading-5");

    // Ответ о наличии зарядки для самоката
    public static final By ANSWER_ABOUT_CHARGING = By.id("accordion__panel-5");

    public static final String ANSWER_ABOUT_CHARGING_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

    // Вопрос "Можно ли отменить заказ?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_CANCEL = By.id("accordion__heading-6");

    // Ответ об отмене заказа
    public static final By ANSWER_ABOUT_CANCEL = By.id("accordion__panel-6");

    public static final String ANSWER_ABOUT_CANCEL_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

    // Вопрос "Я жиз(в?)у за МКАДом, привезёте?" в списке "Вопросы о важном"
    public static final By QUESTION_ABOUT_OUTSIDE_MKAD = By.id("accordion__heading-7");

    // Ответ о зоне доставки за МКАД
    public static final By ANSWER_ABOUT_OUTSIDE_MKAD = By.id("accordion__panel-7");

    public static final String ANSWER_ABOUT_OUTSIDE_MKAD_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
}
