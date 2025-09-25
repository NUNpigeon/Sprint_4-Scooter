import Pages.MainPageScooter;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderButtonTest extends BaseTest {

    private MainPageScooter mainPage; // Page Object для главной страницы


    @Test
    public void checkTopOrderButtonLeadsToOrderPage() {
        mainPage = new MainPageScooter(driver);
        mainPage.open();// 1. Клик на кнопку "Заказать" в верхней части страницы
        mainPage.clickHeaderOrderButton();
        // 2. Проверка, что после клика URL содержит "order", указывая на переход на страницу заказа
        assertTrue(driver.getCurrentUrl().contains("order"));

    }

    @Test
    public void checkBottomOrderButtonLeadsToOrderPage() {
        mainPage = new MainPageScooter(driver);
        mainPage.open();
        mainPage.clickHeaderOrderButton();
        // 2. Проверка, что после клика URL содержит "order", указывая на переход на страницу заказа
        assertTrue(driver.getCurrentUrl().contains("order"));

    }

    @After
    public void tearDown() {
        // Закрытие браузера после выполнения каждого теста
        driver.quit();
    }
}
